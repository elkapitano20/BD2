package database_objects;

public class Client {
    private int idClient;
    private int idKoszyka;
    private String nameClient;
    private String lastNameClient;
    private int peselClient;
    private String usernameClient;
    private String adresClient;
    private String emailClient;
    private String telephoneClient;

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdKoszyka(int idKoszyka) {
        this.idKoszyka = idKoszyka;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public void setPeselClient(int peselClient) {
        this.peselClient = peselClient;
    }

    public void setUsernameClient(String usernameClient) {
        this.usernameClient = usernameClient;
    }

    public void setAdresClient(String adresClient) {
        this.adresClient = adresClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public void setTelephoneClient(String telephoneClient) {
        this.telephoneClient = telephoneClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdKoszyka() {
        return idKoszyka;
    }

    public String getNameClient() {

        return nameClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public int getPeselClient() {
        return peselClient;
    }

    public String getUsernameClient() {
        return usernameClient;
    }

    public String getAdresClient() {
        return adresClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public String getTelephoneClient() {
        return telephoneClient;
    }
}
