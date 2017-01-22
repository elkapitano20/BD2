package gui_panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class AdminPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	/**
	 * Create the panel.
	 */
	public AdminPanel() {
		setLayout(null);
		
		JLabel lblHelloFromAdmin = new JLabel("Hello from administration panel");
		lblHelloFromAdmin.setBounds(50, 100, 150, 20);
		add(lblHelloFromAdmin);

	}
}
