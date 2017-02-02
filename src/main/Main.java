package main;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import database_objects.Client;
import gui.LoginFrame;
import gui.MainFrame;
import gui.RegisterFrame;
public class Main{

	private static LoginFrame loginFrame;
	private static MainFrame mainFrame;
	private static RegisterFrame registerFrame;
	private static Client client;


	
	public static void main(String[] args) throws NoSuchAlgorithmException, SQLException {
		loginFrame = new LoginFrame();
		loginFrame.show();
	}
	public static Client getClient() {
		return client;
	}

	public static void setClient(String login, int i) {
		client = new Client(login, i);
	}

	public static void goToMainFrame() throws SQLException {
		loginFrame.dispose();
		loginFrame = null;
		mainFrame = new MainFrame();
		mainFrame.show();
		client.setIdKoszyka();
	}
	
	public static void goToRegisterFrame() {
		loginFrame.dispose();
		loginFrame = null;
		registerFrame = new RegisterFrame();
		registerFrame.show();
	}
	
	public static void logout() {
		client = null;
		mainFrame.dispose();
		mainFrame = null;
		loginFrame = new LoginFrame();
		loginFrame.show();
	}
	public static void goFromRegisterToLogin(){
		registerFrame.dispose();
		registerFrame = null;
		loginFrame = new LoginFrame();
		loginFrame.show();
	}

}
