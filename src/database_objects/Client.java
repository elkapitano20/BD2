package database_objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import database_handler.Connector;

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

    public Client(String login, int i) {
    	usernameClient = login;
    	idClient = i;
    }

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

	public void setIdKoszyka() throws SQLException{
		Connector con = Connector.getInstance();
		con.connect();
		String getCartNoOrderSQL = "SELECT * FROM CARTS WHERE CLIENT_ID = ? AND (SELECT COUNT(*) FROM ORDERS o INNER JOIN CARTS c ON c.CART_ID = o.CART_ID WHERE c.CLIENT_ID = ?)=0";
		Vector <String> clientId = new Vector<String>();
		clientId.add(String.valueOf(idClient));
		clientId.add(String.valueOf(idClient));
		ResultSet rs = con.executeQuery(getCartNoOrderSQL, clientId);
		boolean isEmpty=true;
		
		while(rs.next()){
			isEmpty= false;
			idKoszyka = rs.getInt("CART_ID");
		}
		rs.close();
		if (isEmpty){
			ResultSet rs1 = con.executeQuery("SELECT MAX(CART_ID) FROM CARTS", new Vector<String>());
			while(rs1.next()){
				idKoszyka = rs.getInt(1) +1;
			}
			rs1.close();
			String insertCart = "#insINSERT INTO CARTS (CLIENT_ID, CART_ID) VALUES (" + idClient + ", " + idKoszyka + ")";
			con.executeDB(insertCart, new Vector<String>());
		}
		con.disconnect();
	}
}
