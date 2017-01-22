package gui;

import javax.swing.*;

import exceptions.LoginException;
import main.LoginData;
import main.Main;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		//Test data List for logging in
		logDatLst.add(new LoginData("andrii", "111"));
		logDatLst.add(new LoginData("savchuk", "222"));
		logDatLst.add(new LoginData("olha", "333"));
		//-----

		actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if( command.equals( "Rejestracja" ))  {
					Main.goToRegisterFrame();
				}else if (command.equals( "Zaloguj" )) {
					String login= loginTxtField.getText();
					String password = new String(passwordField.getPassword());
					LoginData logDat = new LoginData(login, password);
					try {
						if (login(logDat)) {
							Main.setClient(logDat.getLogin());
							Main.goToMainFrame();
						}
					}catch (LoginException e1){
						frameAlert = new JFrame();
						JOptionPane.showMessageDialog(frameAlert,
								"Niepoprawne dane logowania",
								"Wrong Login or password!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		};
		initialize();
		
	}


	protected boolean login(LoginData loginObj) throws LoginException{
			for (LoginData x : logDatLst) {
				if (Objects.equals(x.getLogin(), loginObj.getLogin()) && Objects.equals(x.getPassword(), loginObj.getPassword())) {
					//System.out.print("Hello");
					return true;
				}
			}
		//System.out.print("Bye");
		throw new LoginException();
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
	
	public void show(){
		this.frame.setVisible(true);
	}

	public void dispose() {
		frame.dispose();
	}
}
