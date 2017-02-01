package gui_panels;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AddToCart extends JFrame {

	private JPanel contentPane;
	private static AddToCart instance;
	
	public static AddToCart getInsance(Object object){
		if (instance==null){
			instance = new AddToCart(object);
		}
		return instance;
	}
	/**
	 * Create the frame.
	 */
	private AddToCart(Object object) {
		int cartId = Integer.parseInt(object.toString());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKoszyk = new JLabel("Koszyk");
		lblKoszyk.setBounds(112, 25, 70, 26);
		contentPane.add(lblKoszyk);
		this.setVisible(true);
	}
	
	
}
