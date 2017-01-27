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

		String[] columnNames = {"ID Zamuwienia",
				"ID Faktury",
				"Data zamuwienia"};


		try{
			String sql = "SELECT * FROM ORDERS";

			Connector con = new Connector();
			ResultSet rs1 = con.executeQuery(sql);
			while(rs1.next()){
				rsSize++;
			}
			ResultSet rs = con.executeQuery(sql);
			Object[][] data = new Object[rsSize][3];
			while(rs.next()){

				//Retrieve by column name
				String orderID  = rs.getString("ORDER_ID");
				String cartID = rs.getString("CART_ID");
				String orderDate = rs.getString("ORDER_DATE");

				data[count][0] = orderID;
				data[count][1] = cartID;
				data[count][2] = orderDate;

				//Display values
				/*System.out.print("prodID: " + prodID);
				System.out.print(", catID: " + catID);
				System.out.print(", werProdID: " + werProdID);
				System.out.print(", name: " + name);
				System.out.print(", opis: " + opis);
				System.out.print(", price: " + price);
				System.out.print(", stat: " + stat);
				System.out.println();
				System.out.println(rs.getFetchSize());*/
				count++;
			}
			/*System.out.println(count);*/
			JTable table = new JTable(data, columnNames);
			table.setVisible(true);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);

			add(scrollPane, BorderLayout.CENTER) ;
		}catch (SQLException sqlEx){
			System.out.println("Couldn't prepare statement");
			//sqlEx.printStackTrace();
		}
	}
}
