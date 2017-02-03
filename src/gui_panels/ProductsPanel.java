package gui_panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import database_handler.Connector;

public class ProductsPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 2L;
	private static int count = 0;
	private static int rsSize = 0;
	/**
	 * Create the panel.
	 * @param frame 
	 */
	public ProductsPanel() {
		setLayout(new BorderLayout());

		String[] columnNames = {"ID Produktu",
				"Categoria",
				"Ilość produktów w magazynie",
				"Nazwa produktu",
				"Cena produktu","Koszyk"};

		try{
			String sql = "SELECT p.PRODUCT_ID AS prodID" +
					", c.NAME AS categName" +
					", w.QUANTITY AS warehQuantity" +
					", p.NAME AS prodName" +
					", p.PRICE AS prodPrice " +
					"FROM PRODUCTS p " +
					"INNER JOIN CATEGORIES c " +
					"ON p.CATEGORY_ID = c.CATEGORY_ID " +
					"INNER JOIN WAREHOUSE w " +
					"ON p.WAREHOUSE_PRODUCT_ID = w.WAREHOUSE_PRODUCT_ID";


			Connector con = Connector.getInstance();
			con.connect();
			ResultSet rs1 = con.executeQuery("SELECT COUNT(*) FROM PRODUCTS", null);
			while(rs1.next()){
				rsSize = rs1.getInt(1);
			}
			ResultSet rs = con.executeQuery(sql, null);

			Object[][] data = new Object[rsSize][6];
			while(rs.next()){

				//Retrieve by column name
				String prodID  = rs.getString("prodID");
				String catID = rs.getString("categName");
				String werProdID = rs.getString("warehQuantity");
				String name  = rs.getString("prodName");
				String price = rs.getString("prodPrice");

				data[count][0] = prodID;
				data[count][1] = catID;
				data[count][2] = werProdID;
				data[count][3] = name;
				data[count][4] = price+ " zl";
				data[count][5] = prodID;
				count++;
			}
			count = 0;
	        DefaultTableModel dm = new DefaultTableModel();
	        dm.setDataVector(data, columnNames);
	        JTable table = new JTable(dm);
	        table.setVisible(true);
	        table.getColumn("Koszyk").setCellRenderer(new ButtonRenderer());
	        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (table.getSelectedColumn() == 5){
						try {
							addToCart(table.getValueAt(table.getSelectedRow(), 5));
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					
				}
			});
	        table.setFillsViewportHeight(true);
			con.disconnect();
			table.setVisible(true);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			
			scrollPane.setVisible(true);
			add(scrollPane, BorderLayout.CENTER) ;
		}catch (SQLException sqlEx){
			System.out.println("Couldn't prepare statement");
		}

	}
	
	public ProductsPanel(String search) {
		setLayout(new BorderLayout());

		String[] columnNames = {"ID Produktu",
				"Categoria",
				"Ilość produktów w magazynie",
				"Nazwa produktu",
				"Cena produktu","Koszyk"};

		try{
			String sql = "SELECT p.PRODUCT_ID AS prodID" +
					", c.NAME AS categName" +
					", w.QUANTITY AS warehQuantity" +
					", p.NAME AS prodName" +
					", p.PRICE AS prodPrice " +
					"FROM PRODUCTS p " +
					"INNER JOIN CATEGORIES c " +
					"ON p.CATEGORY_ID = c.CATEGORY_ID " +
					"INNER JOIN WAREHOUSE w " +
					"ON p.WAREHOUSE_PRODUCT_ID = w.WAREHOUSE_PRODUCT_ID WHERE UPPER(p.NAME) LIKE UPPER(?) ";


			Connector con = Connector.getInstance();
			con.connect();
			Connection connection = con.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM PRODUCTS WHERE UPPER(NAME) LIKE UPPER(?)");
			preparedStatement.setString(1, search+"%");
			ResultSet rs1 =preparedStatement.executeQuery();
			while(rs1.next()){
				rsSize = rs1.getInt(1);
			}
			rs1.close();
			preparedStatement.close();
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
			preparedStatement1.setString(1, search+"%");
			ResultSet rs =preparedStatement1.executeQuery();

			Object[][] data = new Object[rsSize][6];
			while(rs.next()){

				//Retrieve by column name
				String prodID  = rs.getString("prodID");
				String catID = rs.getString("categName");
				String werProdID = rs.getString("warehQuantity");
				String name  = rs.getString("prodName");
				String price = rs.getString("prodPrice");

				data[count][0] = prodID;
				data[count][1] = catID;
				data[count][2] = werProdID;
				data[count][3] = name;
				data[count][4] = price+ " zl";
				data[count][5] = prodID;
				count++;
			}
			count = 0;
	        DefaultTableModel dm = new DefaultTableModel();
	        dm.setDataVector(data, columnNames);
	        JTable table = new JTable(dm);
	        table.setVisible(true);
	        table.getColumn("Koszyk").setCellRenderer(new ButtonRenderer());
	        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (table.getSelectedColumn() == 5){
						try {
							addToCart(table.getValueAt(table.getSelectedRow(), 5));
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					
				}
			});
	        table.setFillsViewportHeight(true);
			con.disconnect();
			table.setVisible(true);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			
			scrollPane.setVisible(true);
			add(scrollPane, BorderLayout.CENTER) ;
		}catch (SQLException sqlEx){
			System.out.println("Couldn't prepare statement");
		}

	}
	
	
	private void addToCart(Object object) throws SQLException{
		AddToCart.getInsance(object);
		
	}
	
    @SuppressWarnings("serial")
	class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Do koszyka");
            return this;
        }


    }
    

}