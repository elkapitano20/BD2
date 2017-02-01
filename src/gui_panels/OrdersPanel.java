package gui_panels;

import database_handler.Connector;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private static int count = 0;
	private static int rsSize = 0;

	/**
	 * Create the panel.
	 */
	public OrdersPanel() {
		setLayout(new BorderLayout());

		String[] columnNames = {"ID Zamówienia",
				"ID Faktury",
				"Data zamówienia"};


		try{
			String sql = "SELECT * FROM ORDERS";

			Connector con = Connector.getInstance();
			con.connect();
			ResultSet rs1 = con.executeQuery(sql, null);
			while(rs1.next()){
				rsSize++;
			}
			ResultSet rs =  con.executeQuery(sql, null);
			
			Object[][] data = new Object[rsSize][3];
			while(rs.next()){

				//Retrieve by column name
				String orderID  = rs.getString("ORDER_ID");
				String cartID = rs.getString("CART_ID");
				String orderDate = rs.getString("ORDER_DATE");

				data[count][0] = orderID;
				data[count][1] = cartID;
				data[count][2] = orderDate;
				count++;
			}
			con.disconnect();
			JTable table = new JTable(data, columnNames);
			table.setVisible(true);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			scrollPane.setVisible(true);
			add(scrollPane, BorderLayout.CENTER) ;
		}catch (SQLException sqlEx){
			System.out.println("Couldn't prepare statement");
		}
	}
}
