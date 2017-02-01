package database_objects;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by savch on 21.01.2017.
 * All rights is okey =)
 */
public class Warehouse {
    private int idPozMagaz;
    private int quantity;

    public Warehouse(int id, int quant){
    	idPozMagaz = id;
    	quantity = quant;
    }
    
    public void create(Statement stmt) throws SQLException{
    	StringBuilder sb = new StringBuilder();
    	sb.append("INSERT INTO WAREHOUSE (WAREHOUSE_PRODUCT_ID, QUANTITY) VALUES (").append(idPozMagaz).append(", ").append(quantity).append(")");
    	System.out.println(sb.toString());
    	stmt.execute(sb.toString());
    }
    public int getIdPozMagaz() {
        return idPozMagaz;
    }

    public void setIdPozMagaz(int idPozMagaz) {
        this.idPozMagaz = idPozMagaz;
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
