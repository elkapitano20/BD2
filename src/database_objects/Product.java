package database_objects;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by savch on 21.01.2017.
 * All rights is okey =)
 */
public class Product {

    private int idProduct;
    private int idCategory;
    private int idPozWar;
    private String nameProduct;
    private String aboutProduct;
    private float priceProduct;
    private int status;
    
    public Product(int id, int catId, int idPozMag, String name, String description,float price, int stat ){
    	idProduct = id;
    	idCategory = catId;
    	idPozWar = idPozMag;
    	nameProduct = name;
    	aboutProduct = description;
    	priceProduct = price;
    	status = stat;
    }
    
    public void create(Statement stmt) throws SQLException{
    	StringBuilder sb = new StringBuilder();
    	sb.append("INSERT INTO PRODUCTS (PRODUCT_ID, CATEGORY_ID, WAREHOUSE_PRODUCT_ID, NAME, OPIS, PRICE, STATUS) VALUES (").append(idProduct).
    		append(", ").append(idCategory).append(", ").append(idPozWar).append(", '").append(nameProduct).append("', '").append(aboutProduct).
    		append("', ").append(priceProduct).append(", ").append(status).append(")");
    	System.out.println(sb.toString());
    	stmt.execute(sb.toString());
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdPozWar() {
        return idPozWar;
    }

    public void setIdPozWar(int idPozWar) {
        this.idPozWar = idPozWar;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getAboutProduct() {
        return aboutProduct;
    }

    public void setAboutProduct(String aboutProduct) {
        this.aboutProduct = aboutProduct;
    }

    public float getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(float priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
