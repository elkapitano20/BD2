package database_objects;

/**
 * Created by Pelmen on 22.01.2017.
 */
public class Category {

    private int categoryId;
    private int productId;
    private String name;

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getProductId() {
        return this.productId;
    }

    public String getName() {
        return this.name;
    }

}
