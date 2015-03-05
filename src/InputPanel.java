
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;


class InputPanel extends JPanel {

	public InputPanel() {
		setLayout(new GridLayout(5, 2));
		add(new JLabel("Length"));
		add(new JSpinner());
		add(new JLabel("Start height"));
		add(new JSpinner());
		add(new JLabel("End height"));
		add(new JSpinner());
	}

}
