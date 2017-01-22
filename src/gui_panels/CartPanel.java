package gui_panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class CartPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	/**
	 * Create the panel.
	 */
	public CartPanel() {
		setLayout(null);
		
		JLabel lblHelloFromCarts = new JLabel("Hello from carts panel");
		lblHelloFromCarts.setBounds(50, 100, 150, 20);
		add(lblHelloFromCarts);

	}
}
