package database_objects;

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
    private int priceProduct;
    private int status;

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

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
