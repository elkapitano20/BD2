package database_objects;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import database_handler.Connector;

/**
 * Klasa do generacji kategori i produktów
 * @author tomasz
 *
 */
public class ProductGenerator {
	
	private static final String [] CATEGORIES = {
			"PRALKA", "SUSZARKA", "KUCHNIA", "ZMYWARKA", "OKAP", "KUCHENKI MIROFALOWE", "EKSPRES DO KAWY", "LODÓWKA", "ZAMRAŻARKA",
			"PIEKARNIK", "INNE AKCESORIA"
	};
	private static final String [] OTHER_ACCESORIES = {
			"CZAJNIK", "ZESTAW NACZYŃ", "FILTR DO WODY", "GRILL", "MASZYNA DO MIĘSA", "MIKSER", "BLENDER", "TOSTER", "WAGA"
	};
	
	private static final String [] PRODUCERS = {
			"AMICA", "SAMSUNG", "WHIRLPOOL", "BEKO", "ELETROLUX", "BOSCH", "SIEMENS", "INTEX"
			
	};
	
	private static final float [] CATEGORIES_PRICES = {	800, 50, 50, 600, 500, 300, 200, 700, 500, 400};
	private static final float [] OTHER_CATEGORIES_PRICES = {	40, 100, 50, 100, 30, 80, 120, 50, 50};
	public ProductGenerator(){
		Connector con = Connector.getInstance();
		con.connect();
		Connection connection = con.getConnection();
		Statement stmt=null;
		try{
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			String name = null;
			int id = 3;
			int cat_id = 1;
			for (String cat:CATEGORIES){
				Category category = new Category(cat_id, cat);
				category.create(stmt);
				cat_id++;
			}
			connection.commit();
			cat_id = 1;
			for (int i =0; i<10;i++){
				for (String producer:PRODUCERS){
					Warehouse warehouse = new Warehouse(id, (int)(Math.random() * 100));
					warehouse.create(stmt);
					name = CATEGORIES[i] + " " + producer;
					Product product = new Product(id, cat_id, warehouse.getIdPozMagaz(), name, name, getPrice(i), 1);
					product.create(stmt);
					id++;
				}
				cat_id++;
			}
			connection.commit();
			id = 112;
			cat_id = 11;
			int category =0;
			for (String other:OTHER_ACCESORIES){
				for (String producer:PRODUCERS){
					Warehouse warehouse = new Warehouse(id, (int)(Math.random() * 100));
					warehouse.create(stmt);
					name = other + " " + producer;
					Product product = new Product(id, cat_id, warehouse.getIdPozMagaz(), name, name, getOtherPrice(category), 1);
					product.create(stmt);
					id++;
				}
				category++;
			}
			connection.commit();
		}catch (SQLException e){
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			connection.commit();
			connection.setAutoCommit(true);
			stmt.close();
			connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.disconnect();
		
	}
	private float getOtherPrice(int i) {
		float random = (float) (Math.random() / 2.5 -0.2);
		float value = (1+random)* OTHER_CATEGORIES_PRICES[i];
		DecimalFormat df = new DecimalFormat("#.##");
		return Float.parseFloat(df.format(value).replace(',', '.'));
	}
	
	private float getPrice(int i) {
		float random = (float) (Math.random() / 2.5 -0.2);
		float value = (1+random)* CATEGORIES_PRICES[i];
		DecimalFormat df = new DecimalFormat("#.##");
		return Float.parseFloat(df.format(value).replace(',', '.'));
	}
}
