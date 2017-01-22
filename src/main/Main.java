package main;

import database_objects.Client;
import gui.LoginFrame;
import gui.MainFrame;
import gui.RegisterFrame;

import database_handler.*;
public class Main{

	private static LoginFrame loginFrame;
	private static MainFrame mainFrame;
	private static RegisterFrame registerFrame;
	private static Client client;
	
	public static void main(String[] args) {
		Connector conn = new Connector();
		conn.connect();
		loginFrame = new LoginFrame();
		loginFrame.show();
	}

	public static Client getClient() {
		return client;
	}

	public static void setClient(String login) {
		//TODO wyciagniecie clienta na podstawie loginu(username)
		client = null;
	}

	public static void goToMainFrame() {
		loginFrame.dispose();
		mainFrame = new MainFrame();
		mainFrame.show();
	}
	
	public static void goToRegisterFrame() {
		loginFrame.dispose();
		registerFrame = new RegisterFrame();
		registerFrame.show();
	}


}
