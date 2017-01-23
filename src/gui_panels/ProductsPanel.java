package gui_panels;

import javax.swing.*;
import java.awt.*;

public class ProductsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	

	/**
	 * Create the panel.
	 */
	public ProductsPanel() {
		setLayout(new BorderLayout());
		setBackground(new Color(77,81,84));

		String[] columnNames = {"First Name",
				"Last Name",
				"Sport",
				"# of Years",
				"Vegetarian"};

		Object[][] data = {
				{"Kathy", "Smith",
						"Snowboarding", new Integer(5), new Boolean(false)},
				{"John", "Doe",
						"Rowing", new Integer(3), new Boolean(true)},
				{"Sue", "Black",
						"Knitting", new Integer(2), new Boolean(false)},
				{"Jane", "White",
						"Speed reading", new Integer(20), new Boolean(true)},
				{"Joe", "Brown",
						"Pool", new Integer(10), new Boolean(false)}
		};

		JTable table = new JTable(data, columnNames);
		table.setVisible(true);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		/*setLayout(new BorderLayout());
		add(table.getTableHeader(), BorderLayout.PAGE_START);
		add(table, BorderLayout.CENTER);*/
		add(table, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.CENTER) ;

		/*JLabel txtpnHelloFromProducts = new JLabel("Hello from products panel");
		txtpnHelloFromProducts.setBounds(50, 100, 150, 20);
		add(txtpnHelloFromProducts);*/
	}
}
