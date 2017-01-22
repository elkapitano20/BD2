package database_objects;

import java.util.Date;
/**
 * Created by savch on 21.01.2017.
 * All rights is okey =)
 */
public class Deliver {
    private Date timeDelivery;
    private String aboutDelivery;
    private int idOrder;
    private int idFaktury;
    private int idKosz;

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setIdFaktury(int idFaktury) {
        this.idFaktury = idFaktury;
    }

    public void setIdKosz(int idKosz) {
        this.idKosz = idKosz;
    }

    public int getIdOrder() {

        return idOrder;
    }

    public int getIdFaktury() {
        return idFaktury;
    }

    public int getIdKosz() {
        return idKosz;
    }

    public void setTimeDelivery(Date timeDelivery) {
        this.timeDelivery = timeDelivery;
    }

    public void setAboutDelivery(String aboutDelivery) {
        this.aboutDelivery = aboutDelivery;
    }

    public Date getTimeDelivery() {
        return timeDelivery;
    }

    public String getAboutDelivery() {
        return aboutDelivery;
    }
}
