package gui_panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProductsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Create the panel.
	 */
	public ProductsPanel() {
		setLayout(null);
		
		JLabel txtpnHelloFromProducts = new JLabel("Hello from products panel");
		txtpnHelloFromProducts.setBounds(50, 100, 150, 20);
		add(txtpnHelloFromProducts);
	}
}
