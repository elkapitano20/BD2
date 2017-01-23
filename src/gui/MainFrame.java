package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui_panels.*;
import main.Main;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

	private JFrame frame;
	private JTextField searchTxtField;
	private JPanel panel;
	private ActionListener actionListener;
	/**
	 * Create the application.
	 */
	public MainFrame() {
		actionListener = new ActionListener() {
			
			
			/*
			 * IMPORTANT!!!!
			 * Ta metoda jest do przemieszczania pomiêdzy zawartoœci¹ poszczególnych zak³adek w menu g³ównym. Zawartoœci tych zak³adek s¹ w panelu gui_panels
			 * 
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				switch (command){
				case "Produkty":
					setCurrentPanel(new ProductsPanel());
					break;
				case "Ustawienia":
					setCurrentPanel(new SettingsPanel());
					break;
				case "Zamówienia":
					setCurrentPanel(new OrdersPanel());
					break;
				case "Administracja":
					setCurrentPanel(new AdminPanel());
					break;
				case "Koszyk":
					setCurrentPanel(new CartPanel());
					break;
				case "Oddzia³y":
					setCurrentPanel(new DepartmentsPanel());
					break;
				case "Wyszukaj":
					setCurrentPanel(new SearchPanel());
					break;
				case "Wyloguj":
					Main.logout();
					break;
				default:
					System.out.println("Nieznane polecenie");
					break;
				}
			}	
		};
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
		productBtn.setBackground(SystemColor.menu);
		productBtn.setBounds(30, 10, 100, 20);
		productBtn.addActionListener(actionListener);
		frame.getContentPane().add(productBtn);
		
		JButton settingsBtn = new JButton("Ustawienia");
		settingsBtn.setBounds(135, 10, 100, 20);
		settingsBtn.addActionListener(actionListener);
		frame.getContentPane().add(settingsBtn);
		
		JButton ordersBtn = new JButton("Zam\u00F3wienia");
		ordersBtn.setBounds(240, 10, 100, 20);
		ordersBtn.addActionListener(actionListener);
		frame.getContentPane().add(ordersBtn);
		
		JButton adminBtn = new JButton("Administracja");
		adminBtn.setBounds(345, 10, 100, 20);
		adminBtn.addActionListener(actionListener);
		frame.getContentPane().add(adminBtn);
		
		JButton cartBtn = new JButton("Koszyk");
		cartBtn.setBounds(450, 10, 100, 20);
		cartBtn.addActionListener(actionListener);
		frame.getContentPane().add(cartBtn);
		
		JButton departmentsBtn = new JButton("Oddzia\u0142y");
		departmentsBtn.setBounds(555, 10, 100, 20);
		departmentsBtn.addActionListener(actionListener);
		frame.getContentPane().add(departmentsBtn);
		
		JButton searchBtn = new JButton("Wyszukaj");
		searchBtn.setBounds(545, 45, 85, 20);
		searchBtn.addActionListener(actionListener);
		frame.getContentPane().add(searchBtn);
		
		panel = new JPanel();
		panel.setBounds(0, 72, 784, 489);
		panel.setLayout(null);
		setCurrentPanel(new SearchPanel());
		
		searchTxtField = new JTextField();
		searchTxtField.setToolTipText("Wyszukaj produkt");
		searchTxtField.setBounds(180, 45, 356, 20);
		frame.getContentPane().add(searchTxtField);
		searchTxtField.setColumns(10);
		
		JButton logoutBtn = new JButton("Wyloguj");
		logoutBtn.setBounds(660, 9, 100, 20);
		logoutBtn.addActionListener(actionListener);
		frame.getContentPane().add(logoutBtn);
	}

	public void show() {
		frame.setVisible(true);
	}
	
	public <T extends JPanel> void setCurrentPanel(T t){
		frame.getContentPane().remove(panel);
		panel = t;
		panel.setBounds(0, 72, 784, 489);
//		panel.setLayout(null);
		frame.getContentPane().add(panel);
		frame.repaint();
	}

	public void dispose() {
		frame.dispose();
	}
}
