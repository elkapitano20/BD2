package database_objects;

import java.util.Date;

/**
 * Created by savch on 21.01.2017.
 * All rights is okey =)
 */
public class Invoice {
    private String dateFaktura;
    private int idFaktury;
    private Date dataFaktury;
    private int idClient;

    public int getIdFaktury() {
        return idFaktury;
    }

    public void setIdFaktury(int idFaktury) {
        this.idFaktury = idFaktury;
    }

    public Date getDataFaktury() {
        return dataFaktury;
    }

    public void setDataFaktury(Date dataFaktury) {
        this.dataFaktury = dataFaktury;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setDateFaktura(String dateFaktura) {
        this.dateFaktura = dateFaktura;
    }

    public String getDateFaktura() {

        return dateFaktura;
    }
}
