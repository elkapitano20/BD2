package gui_panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class SettingsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public SettingsPanel() {
		setLayout(null);
		
		JLabel lblHelloFromSettings = new JLabel("Hello from settings panel");
		lblHelloFromSettings.setBounds(50, 100, 150, 20);
		add(lblHelloFromSettings);

	}
}
