package main;

import database_objects.Client;
import gui.LoginFrame;
import gui.MainFrame;
import gui.RegisterFrame;

public class Main{

	private static LoginFrame loginFrame;
	private static MainFrame mainFrame;
	private static RegisterFrame registerFrame;
	private static Client client;
	
	public static void main(String[] args) {
		loginFrame = new LoginFrame();
		loginFrame.show();
	}
	public static Client getClient() {
		return client;
	}

	public static void setClient(String login) {
		client = null;
	}

	public static void goToMainFrame() {
		loginFrame.dispose();
		loginFrame = null;
		mainFrame = new MainFrame();
		mainFrame.show();
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
