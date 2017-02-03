package gui_panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import database_handler.Connector;
import main.Main;

public class CartPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private static int count = 0;
	private static int rsSize = 0;
	private JTable table;
	private DefaultTableModel dm;
	private ActionListener actionListener;
	private Object[][] data;
	private JLabel total;

	/**
	 * Create the panel.
	 */
	public CartPanel() {
		setLayout(new BorderLayout());
		rsSize = 0;
		count = 0;
		actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					createOrder();
					Main.getClient().setIdKoszyka();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};

		String[] columnNames = {"Nazwa produktu",
				"Cena za sztukę",
				"Ilość sztuk",
				"Wartość", "Ustaw ilość", "Usuń" };

		try{
			String sql = "SELECT p.NAME, pb.QUANTITY, pb.ITEM_PRICE, pb.PRODUCT_BOUGHT_ID FROM PRODUCTS_BOUGHT pb "+
					"INNER JOIN PRODUCTS p ON p.PRODUCT_ID = pb.PRODUCT_ID WHERE CART_ID = ?";

			Connector con =  Connector.getInstance();
			con.connect();
			Vector<String> args = new Vector<String>();
			args.add(String.valueOf(Main.getClient().getIdKoszyka()));
			ResultSet rs1 = con.executeQuery(sql,args);
			while(rs1.next()){
				rsSize++;
			}
			ResultSet rs = con.executeQuery(sql,args);
			
			data = new Object[rsSize][6];
			while(rs.next()){

				//Retrieve by column name
				String name = rs.getString(1);
				int quantity = rs.getInt(2);
				double itemPrice  = rs.getDouble(3);
				
				data[count][0] = name;
				data[count][1] = itemPrice;
				data[count][2] = quantity;
				data[count][3] = (double) (itemPrice * quantity);
				data[count][4] = rs.getInt(4);
				data[count][5] = data[count][4];

				count++;
			}
			con.disconnect();
			dm = new DefaultTableModel();
	        dm.setDataVector(data, columnNames);
			table = new JTable(dm);
			table.getColumn("Usuń").setCellRenderer(new ButtonRenderer("Usuń"));
			table.getColumn("Ustaw ilość").setCellRenderer(new ButtonRenderer("Ustaw ilość"));
	        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if(e.getValueIsAdjusting()){
						if (table.getSelectedColumn() == 5 ){
							deleteProductBought(table.getValueAt(table.getSelectedRow(), 5));
						}else if (table.getSelectedColumn() == 4){
							updateProductQuantity(table.getValueAt(table.getSelectedRow(), 4), table.getValueAt(table.getSelectedRow(), 2), table.getSelectedRow());
							revalidateSummary();
						}
					}
					
				}
			});
			table.setVisible(true);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			add(scrollPane, BorderLayout.CENTER) ;
			
			total = new JLabel(setTotal());
			add(total, BorderLayout.NORTH);
			
			JButton btnDodaj = new JButton("Złóż zamówienie");
			btnDodaj.addActionListener(actionListener);
			add(btnDodaj, BorderLayout.SOUTH);
			
		}catch (SQLException sqlEx){
			System.out.println("Couldn't prepare statement");
		}
	}
	
	private String setTotal() {
		StringBuilder sb = new StringBuilder();
		double total = 0;
		for (int i=0; i< data.length;i++){
			total += Double.parseDouble(data[i][3].toString());
		}
		DecimalFormat df = new DecimalFormat("#.##");
		sb.append("Łączna wartość zamówienia: ").append(df.format(total).replace(',', '.')).append(" zł");
		
		return sb.toString();
	}

	protected void createOrder() throws SQLException {
		if (data.length>0){
			Connector connector = Connector.getInstance();
			connector.connect();
			Connection conn = connector.getConnection();
			CallableStatement storedProc = conn.prepareCall("{call CREATE_ORDER(?,?)}");
			ResultSet rs = connector.executeQuery("SELECT MAX(ORDER_ID) FROM ORDERS", new Vector<String>());
			int id = 1;
			while(rs.next()){
				try{
					id = rs.getInt(1) +1;
				}catch(Exception e){
					e.printStackTrace();
					id = 1;
				}
			}
	        storedProc.setInt(1, id);
	        storedProc.setInt(2, Main.getClient().getIdKoszyka());
	        storedProc.execute();
	        storedProc.close();
	        conn.close();
	        connector.disconnect();
		}else{
			JOptionPane.showMessageDialog(new JFrame(), "Brak produktów w koszyku",
					"Brak produktów w koszyku", JOptionPane.WARNING_MESSAGE);
		}
        
		
	}

	protected void revalidateSummary() {
		this.remove(total);
		total = new JLabel(setTotal());
		add(total, BorderLayout.NORTH);
		this.repaint();
		this.revalidate();
		
	}

	protected void updateProductQuantity(Object productBoughtId, Object quantity, int row) {
		String s = (String)JOptionPane.showInputDialog("Podaj ilość", quantity);
		table.setValueAt(s, row, 2);
		table.setValueAt((double)(Double.parseDouble(s) * Double.parseDouble(table.getValueAt(row, 1).toString())), row, 3);
		table.repaint();
		table.revalidate();
		Connector connector = Connector.getInstance();
		String sql = "#insUPDATE PRODUCTS_BOUGHT SET QUANTITY = ? WHERE PRODUCT_BOUGHT_ID = ?";
		Vector<String> args = new Vector<String>();
		args.add(s);
		args.add(productBoughtId.toString());
		connector.executeDB(sql, args);
		
	}

	protected void deleteProductBought(Object productBoughtId) {
		Connector connector = Connector.getInstance();
		String sql = "#insDELETE FROM PRODUCTS_BOUGHT WHERE PRODUCT_BOUGHT_ID = ?";
		Vector<String> args = new Vector<String>();
		args.add(productBoughtId.toString());
		connector.executeDB(sql, args);
		
		
	}

	@SuppressWarnings("serial")
	class ButtonRenderer extends JButton implements TableCellRenderer {
		String name;
        public ButtonRenderer(String string) {
            setOpaque(true);
            name = string;
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText(name);
            return this;
        }


    }
}
