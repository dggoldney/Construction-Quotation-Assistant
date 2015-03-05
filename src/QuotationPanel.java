
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class QuotationPanel extends JPanel {

	public QuotationPanel() {
		setPreferredSize (new Dimension(400,200));
		setBackground(Color.RED);
		add(new JLabel("Quotation"));
	}

}
