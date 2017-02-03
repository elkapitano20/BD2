package gui_panels;

import database_handler.Connector;
import main.Main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OrdersPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private static int count = 0;
	private static int rsSize = 0;
	private Object[][] data;

	/**
	 * Create the panel.
	 */
	public OrdersPanel() {
		count = 0;
		rsSize = 0;
		setLayout(new BorderLayout());

		String[] columnNames = { "ID Zamówienia", "Data zamówienia", "Szczegóły zamówienia" };

		try {
			String sql = "SELECT o.ORDER_ID, o.ORDER_DATE, o.CART_ID FROM ORDERS o INNER JOIN CARTS c ON o.CART_ID = c.CART_ID WHERE c.CLIENT_ID = ?";
			Vector<String> args = new Vector<String>();
			args.add(String.valueOf(Main.getClient().getIdClient()));
			Connector con = Connector.getInstance();
			con.connect();
			ResultSet rs1 = con.executeQuery(sql, args);
			while (rs1.next()) {
				rsSize++;
			}
			ResultSet rs = con.executeQuery(sql, args);

			data = new Object[rsSize][3];
			while (rs.next()) {

				String orderID = rs.getString(1);
				String orderDate = rs.getString(2);

				data[count][0] = orderID;
				data[count][1] = orderDate;
				data[count][2] = rs.getString(3);
				count++;
			}
			con.disconnect();
			DefaultTableModel dm = new DefaultTableModel();
			dm.setDataVector(data, columnNames);
			JTable table = new JTable(dm);
			table.getColumn("Szczegóły zamówienia").setCellRenderer(new ButtonRenderer());
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (e.getValueIsAdjusting()) {
						if (table.getSelectedColumn() == 2) {
							showDetails(table.getValueAt(table.getSelectedRow(), 2));
						}
					}

				}
			});
			table.setVisible(true);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			scrollPane.setVisible(true);
			add(scrollPane, BorderLayout.CENTER);
		} catch (SQLException sqlEx) {
			System.out.println("Couldn't prepare statement");
			sqlEx.printStackTrace();
		}
	}

	protected void showDetails(Object valueAt) {
		this.removeAll();
		rsSize =0;
		count =0;
		int cart_id = Integer.parseInt(valueAt.toString());
		String[] columnNames = { "Nazwa produktu", "Cena za sztukę", "Ilość sztuk", "Całkowita cena" };
		try {
			String sql = "SELECT p.NAME, pb.QUANTITY, pb.ITEM_PRICE FROM PRODUCTS_BOUGHT pb "+
					"INNER JOIN PRODUCTS p ON p.PRODUCT_ID = pb.PRODUCT_ID WHERE CART_ID = ?";
			Vector<String> args = new Vector<String>();
			args.add(String.valueOf(cart_id));
			Connector con = Connector.getInstance();
			con.connect();
			ResultSet rs1 = con.executeQuery(sql, args);
			while (rs1.next()) {
				rsSize++;
			}
			ResultSet rs = con.executeQuery(sql, args);

			data = new Object[rsSize][4];
			while (rs.next()) {

				String orderID = rs.getString(1);
				String orderDate = rs.getString(3);
				String quan = rs.getString(2);

				data[count][0] = orderID;
				data[count][1] = new String(orderDate + " zł");
				data[count][2] = quan;
				data[count][3] = new String(String.valueOf(Double.parseDouble(orderDate) * Double.parseDouble(data[count][2].toString())) + " zł");
				count++;
			}
			con.disconnect();
			DefaultTableModel dm = new DefaultTableModel();
			dm.setDataVector(data, columnNames);
			JTable table = new JTable(dm);
			table.setVisible(true);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			scrollPane.setVisible(true);
			add(scrollPane, BorderLayout.CENTER);
		} catch (SQLException sqlEx) {
			System.out.println("Couldn't prepare statement");
			sqlEx.printStackTrace();
		}
		this.revalidate();
		this.repaint();
	}

	@SuppressWarnings("serial")
	class ButtonRenderer extends JButton implements TableCellRenderer {
		public ButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText("Szczegóły");
			return this;
		}

	}
}
