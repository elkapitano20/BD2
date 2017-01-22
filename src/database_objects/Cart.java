package database_objects;

/**
 * Created by savch on 21.01.2017.
 * All rights is okey =)
 */
public class Cart {
    private int idKosz;
    private int idClient;
    private int idOrder;
    private int idProduct;

    public void setIdKosz(int idKosz) {
        this.idKosz = idKosz;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdKosz() {

        return idKosz;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }
}
