package gui_panels;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.xml.internal.bind.v2.TODO;
import database_handler.*;
import database_objects.Product;

public class ProductsPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 2L;
	private static int count = 0;
	private static int rsSize = 0;
	/**
	 * Create the panel.
	 */
	public ProductsPanel() {
		setLayout(new BorderLayout());
		//setBackground(new Color(77,81,84));

		String[] columnNames = {"ID Produktu",
				"Categoria",
				"Ilość produktów w magazynie",
				"Nazwa produktu",
				"Opis produktu",
				"Cena produktu",
				"Status"};

		try{
			String sql = "SELECT p.PRODUCT_ID AS prodID" +
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
									"ON p.WAREHOUSE_PRODUCT_ID = w.WAREHOUSE_PRODUCT_ID";

			Connector con = new Connector();
			ResultSet rs1 = con.executeQuery(sql);
			while(rs1.next()){
				rsSize++;
			}
			ResultSet rs = con.executeQuery(sql);
			Object[][] data = new Object[rsSize][7];
			while(rs.next()){

				//Retrieve by column name
				String prodID  = rs.getString("prodID");
				String catID = rs.getString("categName");
				String werProdID = rs.getString("warehQuantity");
				String name  = rs.getString("prodName");
				String opis = rs.getString("prodOpis");
				String price = rs.getString("prodPrice");
				String stat = rs.getString("prodStat");

				/*String prodID  = rs.getString("PRODUCT_ID");
				String catID = rs.getString("CATEGORY_ID");
				String werProdID = rs.getString("WAREHOUSE_PRODUCT_ID");
				String name  = rs.getString("NAME");
				String opis = rs.getString("OPIS");
				String price = rs.getString("PRICE");
				String stat = rs.getString("STATUS");*/

				data[count][0] = prodID;
				data[count][1] = catID;
				data[count][2] = werProdID;
				data[count][3] = name;
				data[count][4] = opis;
				data[count][5] = price;
				data[count][6] = stat;

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


