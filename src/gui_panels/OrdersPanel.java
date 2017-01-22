package gui_panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class OrdersPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	/**
	 * Create the panel.
	 */
	public OrdersPanel() {
		setLayout(null);
		
		JLabel lblHelloFromOrders = new JLabel("Hello from orders panel");
		lblHelloFromOrders.setBounds(50, 100, 150, 20);
		add(lblHelloFromOrders);

	}
}
