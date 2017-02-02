package gui_panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database_handler.Connector;
import database_objects.Client;
import main.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AddToCart extends JFrame implements WindowListener{

	private JPanel contentPane;
	private static AddToCart instance;
	private JTextField textField;
	private int maxQuantity;
	private int productId;
	private double price;
	private ActionListener actionListener;
	
	public static AddToCart getInsance(Object object) throws SQLException{
		if (instance==null){
			instance = new AddToCart(object);
		}
		return instance;
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	private AddToCart(Object object) throws SQLException {
		productId = Integer.parseInt(object.toString());
		String getProduct = "SELECT p.NAME, p.PRICE, w.QUANTITY FROM PRODUCTS p INNER JOIN WAREHOUSE w ON p.WAREHOUSE_PRODUCT_ID = w.WAREHOUSE_PRODUCT_ID WHERE p.PRODUCT_ID = ?";
		Vector<String> productsId = new Vector<String>();
		productsId.add(object.toString());
		actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equalsIgnoreCase("ANULUJ")){
					instance = null;
					dispose();
				}else{
					try {
						int quantity = Integer.parseInt(textField.getText());
						if (quantity >0 && quantity< maxQuantity){
							addToCart(quantity);
						}else{
							JOptionPane.showMessageDialog(new JFrame(), "Niepoprawna ilość produktów",
									"Niepoprawna ilość produktów!", JOptionPane.WARNING_MESSAGE);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch(RuntimeException e1){
						JOptionPane.showMessageDialog(new JFrame(), "Niepoprawna ilość produktów",
								"Niepoprawna ilość produktów!", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		};
		
		Connector connector = Connector.getInstance();
		connector.connect();
		ResultSet rs = connector.executeQuery(getProduct, productsId);

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKoszyk = new JLabel("Koszyk");
		lblKoszyk.setBounds(12, 25, 426, 26);
		contentPane.add(lblKoszyk);
		
		JLabel lblProdukt = new JLabel("Produkt: ");
		lblProdukt.setBounds(12, 76, 70, 15);
		contentPane.add(lblProdukt);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(83, 76, 355, 15);
		contentPane.add(lblNewLabel);
		
		while (rs.next()){
			lblNewLabel.setText(rs.getString(1));
			price = rs.getDouble(2);
			maxQuantity = rs.getInt(3);
		}
		
		JLabel lblIloSztuk = new JLabel("Ilość sztuk:");
		lblIloSztuk.setBounds(12, 150, 107, 15);
		contentPane.add(lblIloSztuk);
		
		textField = new JTextField();
		textField.setBounds(108, 148, 330, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(321, 233, 117, 25);
		btnDodaj.addActionListener(actionListener);
		contentPane.add(btnDodaj);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.setBounds(192, 233, 117, 25);
		btnAnuluj.addActionListener(actionListener);
		contentPane.add(btnAnuluj);
		this.addWindowListener(this);
		this.setVisible(true);
	}
	
	protected void addToCart(int quantity) throws SQLException {
		Client client = Main.getClient();
		Connector connector = Connector.getInstance();
		connector.connect();
		String getLastSql = "SELECT MAX(PRODUCT_BOUGHT_ID) FROM PRODUCTS_BOUGHT";
		ResultSet rs = connector.executeQuery(getLastSql, new Vector<String>());
		int maxId = 1;
		while (rs.next()){
			try {
				maxId = rs.getInt(1) +1;
			}
			catch (Exception e) {
				maxId =1;
			}
		}
		
		rs.close();
		String sql = "#insINSERT INTO PRODUCTS_BOUGHT (PRODUCT_ID, CART_ID, QUANTITY, ITEM_PRICE, PRODUCT_BOUGHT_ID) VALUES(?,?,?,?,?)";
		Vector<String> args = new Vector<String>();
		args.add(String.valueOf(productId));
		args.add(String.valueOf(client.getIdKoszyka()));
		args.add(String.valueOf(quantity));
		args.add(String.valueOf(price));
		args.add(String.valueOf(maxId));
		connector.executeDB(sql, args);
		connector.disconnect();
		instance = null;
		dispose();
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowClosed(WindowEvent e) {
		instance = null;
		this.dispose();
	}
	@Override
	public void windowClosing(WindowEvent e) {
		instance = null;
		this.dispose();
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowOpened(WindowEvent e) {
	}

}
