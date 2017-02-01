package gui_panels;

import database_handler.Connector;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private static int count = 0;
	private static int rsSize = 0;

	/**
	 * Create the panel.
	 */
	public DepartmentsPanel() {
		setLayout(new BorderLayout());

		String[] columnNames = {"ID Oddziału",
				"Lokalizacjia Oddziału",
				"Nazwa Oddziału"};

		try{
			String sql = "SELECT * FROM STORES";

			Connector con = Connector.getInstance();
			con.connect();
			ResultSet rs1 = con.executeQuery(sql, null);
			con.disconnect();
			while(rs1.next()){
				rsSize++;
			}
			con.connect();
			ResultSet rs = con.executeQuery(sql, null);
			con.disconnect();
			Object[][] data = new Object[rsSize][3];
			while(rs.next()){

				//Retrieve by column name
				String storeId = rs.getString("STORE_ID");
				String storeLoc  = rs.getString("LOCALIZATION");
				String storeName = rs.getString("NAME");


				data[count][0] = storeId;
				data[count][1] = storeLoc;
				data[count][2] = storeName;

				count++;
			}
			JTable table = new JTable(data, columnNames);
			table.setVisible(true);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);

			add(scrollPane, BorderLayout.CENTER) ;
		}catch (SQLException sqlEx){
			System.out.println("Couldn't prepare statement");
		}
	}
}
