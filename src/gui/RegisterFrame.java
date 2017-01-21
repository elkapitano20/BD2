package gui;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class RegisterFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the application.
	 */
	public RegisterFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnFormularzRejestracyjny = new JTextPane();
		txtpnFormularzRejestracyjny.setBackground(SystemColor.menu);
		txtpnFormularzRejestracyjny.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnFormularzRejestracyjny.setEditable(false);
		txtpnFormularzRejestracyjny.setText("  Formularz rejestracyjny");
		txtpnFormularzRejestracyjny.setBounds(10, 11, 460, 40);
		frame.getContentPane().add(txtpnFormularzRejestracyjny);
		
		JTextPane txtpnImi = new JTextPane();
		txtpnImi.setBackground(SystemColor.menu);
		txtpnImi.setEditable(false);
		txtpnImi.setText("Imi\u0119");
		txtpnImi.setBounds(20, 60, 100, 20);
		frame.getContentPane().add(txtpnImi);
		
		JTextPane txtpnNazwisko = new JTextPane();
		txtpnNazwisko.setBackground(SystemColor.menu);
		txtpnNazwisko.setText("Nazwisko");
		txtpnNazwisko.setBounds(20, 90, 100, 20);
		frame.getContentPane().add(txtpnNazwisko);
		
		JTextPane txtpnPesel = new JTextPane();
		txtpnPesel.setBackground(SystemColor.menu);
		txtpnPesel.setEditable(false);
		txtpnPesel.setText("PESEL");
		txtpnPesel.setBounds(20, 120, 100, 20);
		frame.getContentPane().add(txtpnPesel);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setBackground(SystemColor.menu);
		txtpnUsername.setEditable(false);
		txtpnUsername.setText("Nazwa u\u017Cytkownika");
		txtpnUsername.setBounds(20, 150, 100, 20);
		frame.getContentPane().add(txtpnUsername);
		
		JTextPane txtpnAdres = new JTextPane();
		txtpnAdres.setBackground(SystemColor.menu);
		txtpnAdres.setEditable(false);
		txtpnAdres.setText("Adres");
		txtpnAdres.setBounds(20, 180, 100, 20);
		frame.getContentPane().add(txtpnAdres);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setEditable(false);
		txtpnEmail.setBackground(SystemColor.menu);
		txtpnEmail.setText("Email");
		txtpnEmail.setBounds(20, 210, 100, 20);
		frame.getContentPane().add(txtpnEmail);
		
		JTextPane txtpnNumerTelefonu = new JTextPane();
		txtpnNumerTelefonu.setBackground(SystemColor.menu);
		txtpnNumerTelefonu.setEditable(false);
		txtpnNumerTelefonu.setText("Numer telefonu");
		txtpnNumerTelefonu.setBounds(20, 240, 100, 20);
		frame.getContentPane().add(txtpnNumerTelefonu);
		
		textField = new JTextField();
		textField.setBounds(130, 62, 340, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 90, 340, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 120, 340, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 150, 340, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(130, 180, 340, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(130, 210, 340, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(130, 240, 340, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton registerBtn = new JButton("Zarejestruj si\u0119");
		registerBtn.setBounds(360, 299, 110, 20);
		frame.getContentPane().add(registerBtn);
		
		JButton backToLoginBtn = new JButton("Powr\u00F3t");
		backToLoginBtn.setBounds(360, 330, 110, 20);
		frame.getContentPane().add(backToLoginBtn);
	}

	public void show() {
		frame.setVisible(true);
	}

}
