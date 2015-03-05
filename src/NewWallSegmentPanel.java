
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


class NewWallSegmentPanel extends JPanel {

	public NewWallSegmentPanel() {
		setLayout(new GridLayout(5, 2));
		add(new JLabel("Length"));
		add(new JSpinner(new SpinnerNumberModel(0, 0, 100, 2)));
		add(new JLabel("Start height"));
		add(new JSpinner(new SpinnerNumberModel(0, 0, 100, 0.2)));
		add(new JLabel("End height"));
		add(new JSpinner(new SpinnerNumberModel(0, 0, 100, 0.2)));
	}

}
