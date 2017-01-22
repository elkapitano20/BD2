package database_objects;

/**
 * Created by Pelmen on 22.01.2017.
 */
public class ListOfProductsInDeliever {

    private int listId;//PK
    private int productId;//FK
    private int deliverId;//FK

    public void setListId(int listId) {
        this.listId = listId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setDeliverId(int deliverId) {
        this.deliverId = deliverId;
    }

    public int getListId() {
        return this.listId;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getDeliverId() {
        return this.deliverId;
    }

}
