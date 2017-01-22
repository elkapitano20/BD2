package database_objects;

import java.util.Date;
/**
 * Created by savch on 21.01.2017.
 * All rights is okey =)
 */
public class Order {
    private Date dateOrder;
    private int idOrder;
    private int idFaktury;
    private int idKosz;

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdFaktury() {
        return idFaktury;
    }

    public void setIdFaktury(int idFaktury) {
        this.idFaktury = idFaktury;
    }

    public int getIdKosz() {
        return idKosz;
    }

    public void setIdKosz(int idKosz) {
        this.idKosz = idKosz;
    }
}
