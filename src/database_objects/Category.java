package database_objects;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Pelmen on 22.01.2017.
 */
public class Category {

    private int categoryId;
    private String name;

    public Category(int id, String name){
    	categoryId = id;
    	this.name = name;
    }
    
    public void create(Statement stmt) throws SQLException{
    	StringBuilder sb = new StringBuilder();
    	sb.append("INSERT INTO CATEGORIES (CATEGORY_ID, NAME) VALUES (").append(categoryId).append(", '").append(name).append("')");
    	System.out.println(sb.toString());
    	stmt.execute(sb.toString());
    }
    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getName() {
        return this.name;
    }

}
