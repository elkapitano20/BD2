package gui_panels;

import database_handler.Connector;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private static int count = 0;
	private static int rsSize = 0;

	/**
	 * Create the panel.
	 */
	public CartPanel() {
		setLayout(new BorderLayout());

		String[] columnNames = {"ID Koszyka",
				"Imię",
				"Nazwisko",
				"Adres klienta",
				"Email"};

		try{
			String sql = "SELECT c.CART_ID AS cartId" +
							", cl.FIRST_NAME AS firstName" +
							", cl.LAST_NAME AS lastName" +
							", cl.ADDRESS AS clientAdress" +
							", cl.EMAIL AS clientEmail " +
							"FROM CARTS c " +
							"INNER JOIN CLIENTS cl " +
							"ON c.CLIENT_ID = cl.CLIENT_ID";

			/*String sql = "SELECT p.PRODUCT_ID AS prodID" +
				", c.NAME AS categName" +
				", w.QUANTITY AS warehQuantity" +
				", p.NAME AS prodName" +
				", p.OPIS AS prodOpis" +
				", p.PRICE AS prodPrice" +
				", p.STATUS AS prodStat " +
				"FROM PRODUCTS p " +
				"INNER JOIN CATEGORIES c " +
				"ON p.CATEGORY_ID = c.CATEGORY_ID " +
				"INNER JOIN WAREHOUSE w " +
				"ON p.WAREHOUSE_PRODUCT_ID = w.WAREHOUSE_PRODUCT_ID";*/

			Connector con = new Connector();
			ResultSet rs1 = con.executeQuery(sql);
			while(rs1.next()){
				rsSize++;
			}
			ResultSet rs = con.executeQuery(sql);
			Object[][] data = new Object[rsSize][5];
			while(rs.next()){

				//Retrieve by column name
				String cartId = rs.getString("cartId");
				String firstName  = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String clientAdress = rs.getString("clientAdress");
				String clientEmail = rs.getString("clientEmail");


				data[count][0] = cartId;
				data[count][1] = firstName;
				data[count][2] = lastName;
				data[count][3] = clientAdress;
				data[count][4] = clientEmail;

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
