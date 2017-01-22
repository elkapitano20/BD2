package gui_panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class SearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setLayout(null);
		
		JLabel lblHelloFromSearch = new JLabel("Hello from search panel");
		lblHelloFromSearch.setBounds(50, 100, 150, 20);
		add(lblHelloFromSearch);

	}
}
