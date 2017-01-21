package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import main.Main;

import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame {

	private JFrame frame;
	private JTextField loginTxtField;
	private JTextPane txtpnLogin;
	private JTextPane txtpnPassword;
	private JButton registrationBtn;
	private JPasswordField passwordField;
	private MouseListener mouseListener;


	/**
	 * Create the application.
	 */
	public LoginFrame() {
		mouseListener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String login= loginTxtField.getText();
				String password = new String(passwordField.getPassword());
				if (login(login,password)){
					Main.setClient(login);
					Main.goToMainFrame();
				}
			}
		};
		initialize();
		
	}

	protected boolean login(String login, String password) {
		return true;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		class ButtonClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if( command.equals( "Rejestracja" ))  {
					RegisterFrame RegFrame = new RegisterFrame();
					RegFrame.show();
                    frame.setVisible(false);
				}
			}
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 229);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton loginBtn = new JButton("Zaloguj");
		loginBtn.setBounds(335, 50, 80, 20);
		loginBtn.addMouseListener(mouseListener);
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
		txtpnPassword.setBackground(SystemColor.menu);
		txtpnPassword.setText("Has\u0142o");
		txtpnPassword.setBounds(180, 50, 40, 20);
		frame.getContentPane().add(txtpnPassword);

		registrationBtn = new JButton("Rejestracja");
		registrationBtn.setBounds(180, 112, 100, 20);
		frame.getContentPane().add(registrationBtn);
		registrationBtn.setActionCommand("Rejestracja");
		registrationBtn.addActionListener(new ButtonClickListener());

		passwordField = new JPasswordField();
		passwordField.setBounds(225, 50, 100, 20);
		frame.getContentPane().add(passwordField);



	}
	
	public void show(){
		this.frame.setVisible(true);
	}

	public MouseListener getMouseListener() {
		return mouseListener;
	}

	public void setMouseListener(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}

	public void dispose() {
		frame.dispose();
	}
}
