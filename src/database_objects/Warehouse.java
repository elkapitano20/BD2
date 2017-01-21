package database_objects;

/**
 * Created by savch on 21.01.2017.
 * All rights is okey =)
 */
public class Warehouse {
    private String priceProdWar;
    private String aboutProdWar;
    private String aboutWar;

    public void setPriceProdWar(String priceProdWar) {
        this.priceProdWar = priceProdWar;
    }

    public void setAboutProdWar(String aboutProdWar) {
        this.aboutProdWar = aboutProdWar;
    }

    public void setAboutWar(String aboutWar) {
        this.aboutWar = aboutWar;
    }

    public String getPriceProdWar() {

        return priceProdWar;
    }

    public String getAboutProdWar() {
        return aboutProdWar;
    }

    public String getAboutWar() {
        return aboutWar;
    }
}
