package database_objects;

/**
 * Created by savch on 21.01.2017.
 * All rights is okey =)
 */
public class Warehouse {
    private int priceProdWar;
    private String aboutProdWar;
    private String aboutWar;
    private int idPozMagaz;

    public int getPriceProdWar() {
        return priceProdWar;
    }

    public void setPriceProdWar(int priceProdWar) {
        this.priceProdWar = priceProdWar;
    }

    public String getAboutProdWar() {
        return aboutProdWar;
    }

    public void setAboutProdWar(String aboutProdWar) {
        this.aboutProdWar = aboutProdWar;
    }

    public String getAboutWar() {
        return aboutWar;
    }

    public void setAboutWar(String aboutWar) {
        this.aboutWar = aboutWar;
    }

    public int getIdPozMagaz() {
        return idPozMagaz;
    }

    public void setIdPozMagaz(int idPozMagaz) {
        this.idPozMagaz = idPozMagaz;
    }
}
