package database_objects;

/**
 * Created by savch on 21.01.2017.
 * All rights is okey =)
 */
public class Products {
    private String nameProduct;
    private String aboutProduct;
    private String priceProduct;

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setAboutProduct(String aboutProduct) {
        this.aboutProduct = aboutProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {

        return nameProduct;
    }

    public String getAboutProduct() {
        return aboutProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }
}
