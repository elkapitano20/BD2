package gui;

import javax.swing.*;

import database_handler.Connector;
import exceptions.LoginException;
import main.LoginData;
import main.Main;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LoginFrame {

	private JFrame frame, frameAlert;
	private JTextField loginTxtField;
	private JTextPane txtpnLogin;
	private JTextPane txtpnPassword;
	private JButton registrationBtn;
	private JPasswordField passwordField;
	private ActionListener actionListener;

	List<LoginData> logDatLst = new ArrayList<>();

	/**
	 * Create the application.
	 */

	public LoginFrame() {
		// Test data List for logging in
		// logDatLst.add(new LoginData("andrii", "111"));
		// logDatLst.add(new LoginData("savchuk", "222"));
		// logDatLst.add(new LoginData("olha", "333"));
		// -----

		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("Rejestracja")) {
					Main.goToRegisterFrame();
				} else if (command.equals("Zaloguj")) {
					try {
						String login = loginTxtField.getText();

						String password = getPassword();
						LoginData logDat = new LoginData(login, password);

						if (login(logDat)) {
							Main.goToMainFrame();
						}
					} catch (LoginException e1) {
						e1.printStackTrace();
						frameAlert = new JFrame();
						JOptionPane.showMessageDialog(frameAlert, "Niepoprawne dane logowania",
								"Wrong Login or password!", JOptionPane.WARNING_MESSAGE);
					} catch (SQLException sqlE) {
						frameAlert = new JFrame();
						JOptionPane.showMessageDialog(frameAlert, "Niepoprawne dane logowania",
								"Wrong Login or password!", JOptionPane.WARNING_MESSAGE);
						sqlE.printStackTrace();
					} catch (NoSuchAlgorithmException e1) {
						e1.printStackTrace();
					}
				}

			}
		};
		initialize();

	}

	protected boolean login(LoginData loginObj) throws LoginException, SQLException {
		Vector<String> login = new Vector<String>();
		login.addElement(loginObj.getLogin());
		Connector.getInstance().connect();
		ResultSet rs = Connector.getInstance().executeQuery("SELECT CLIENT_ID, PASSWORD FROM CLIENTS WHERE USERNAME = ?", login);
		boolean isValid = false;
		while (rs.next()) {
			String s = rs.getString("PASSWORD");
			if (s.equals(loginObj.getPassword())) {
				System.out.println("pass matches~!");
				Main.setClient(login.elementAt(0), rs.getInt("CLIENT_ID"));
				isValid = true;
			} else {
				System.out.println("pass dont match~!");
				frameAlert = new JFrame();
				JOptionPane.showMessageDialog(frameAlert, "Brak klienta",
						"No client with this username had been found!", JOptionPane.WARNING_MESSAGE);
				rs.close();
				Connector.getInstance().disconnect();
				throw new LoginException();
			}
		}
		Connector.getInstance().disconnect();
//		System.out.println("login - false");
		return isValid;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 229);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton loginBtn = new JButton("Zaloguj");
		loginBtn.setBounds(335, 50, 80, 20);
		loginBtn.addActionListener(actionListener);
		frame.getContentPane().add(loginBtn);

		loginTxtField = new JTextField();
		loginTxtField.setBounds(65, 50, 100, 20);
		frame.getContentPane().add(loginTxtField);
		loginTxtField.setColumns(10);

		txtpnLogin = new JTextPane();
		txtpnLogin.setBackground(SystemColor.menu);
		txtpnLogin.setEditable(false);
		txtpnLogin.setText("Login");
		txtpnLogin.setBounds(20, 50, 40, 20);
		frame.getContentPane().add(txtpnLogin);

		txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(SystemColor.menu);
		txtpnPassword.setText("Has\u0142o");
		txtpnPassword.setBounds(180, 50, 40, 20);
		frame.getContentPane().add(txtpnPassword);

		registrationBtn = new JButton("Rejestracja");
		registrationBtn.setBounds(180, 112, 100, 20);
		frame.getContentPane().add(registrationBtn);
		registrationBtn.setActionCommand("Rejestracja");
		registrationBtn.addActionListener(actionListener);

		passwordField = new JPasswordField();
		passwordField.setBounds(225, 50, 100, 20);
		frame.getContentPane().add(passwordField);

	}

	public void show() {
		this.frame.setVisible(true);
	}

	public void dispose() {
		frame.dispose();
	}

	private String getPassword() throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digested = md.digest(new String(passwordField.getPassword()).getBytes());
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < digested.length; j++) {
			sb.append(Integer.toHexString(0xff & digested[j]));
		}
		return sb.toString();
	}
}
