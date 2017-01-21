package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import database_objects.Client;
import gui.LoginFrame;
import gui.MainFrame;

public class Main implements MouseListener{

	private static LoginFrame loginFrame;
	private static MainFrame mainFrame;
	private static Client client;
	
	public static void main(String[] args) {
		loginFrame = new LoginFrame();
		loginFrame.show();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		loginFrame.getMouseListener().mouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
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

}
