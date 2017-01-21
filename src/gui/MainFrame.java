package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame {

	private JFrame frame;
	private JTextField searchTxtField;

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton productBtn = new JButton("Produkty");
		productBtn.setBackground(Color.LIGHT_GRAY);
		productBtn.setBounds(30, 10, 100, 20);
		frame.getContentPane().add(productBtn);
		
		JButton settingsBtn = new JButton("Ustawienia");
		settingsBtn.setBounds(135, 10, 100, 20);
		frame.getContentPane().add(settingsBtn);
		
		JButton ordersBtn = new JButton("Zam\u00F3wienia");
		ordersBtn.setBounds(240, 10, 100, 20);
		frame.getContentPane().add(ordersBtn);
		
		JButton adminBtn = new JButton("Administracja");
		adminBtn.setBounds(345, 10, 100, 20);
		frame.getContentPane().add(adminBtn);
		
		JButton cartBtn = new JButton("Koszyk");
		cartBtn.setBounds(450, 10, 100, 20);
		frame.getContentPane().add(cartBtn);
		
		JButton departmentsBtn = new JButton("Oddzia\u0142y");
		departmentsBtn.setBounds(555, 10, 100, 20);
		frame.getContentPane().add(departmentsBtn);
		
		JButton searchBtn = new JButton("Wyszukaj");
		searchBtn.setBounds(545, 45, 85, 20);
		frame.getContentPane().add(searchBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 72, 784, 489);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		searchTxtField = new JTextField();
		searchTxtField.setToolTipText("Wyszukaj produkt");
		searchTxtField.setBounds(180, 45, 356, 20);
		frame.getContentPane().add(searchTxtField);
		searchTxtField.setColumns(10);
		
		JButton logoutBtn = new JButton("Wyloguj");
		logoutBtn.setBounds(660, 9, 100, 20);
		frame.getContentPane().add(logoutBtn);
	}
}
