package gui_panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class DepartmentsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;

	/**
	 * Create the panel.
	 */
	public DepartmentsPanel() {
		setLayout(null);
		
		JLabel lblHelloFromDepartments = new JLabel("Hello from departments panel");
		lblHelloFromDepartments.setBounds(50, 100, 150, 20);
		add(lblHelloFromDepartments);

	}
}
