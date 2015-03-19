
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

class NewWallSegmentPanel extends JPanel {

	public NewWallSegmentPanel(boolean hasAngle) {
		setLayout(new GridLayout(5, 2));
		add(new JLabel("Length (m)"));
		length = new JSpinner(new SpinnerNumberModel(10, 0, 100, 2));
		add(length);
		add(new JLabel("Start height (m)"));
		startHeight = new JSpinner(new SpinnerNumberModel(1, 0, 100, 0.2));
		add(startHeight);
		add(new JLabel("End height (m)"));
		endHeight = new JSpinner(new SpinnerNumberModel(15, 0, 100, 0.2));
		add(endHeight);
		angle = new JSpinner(new SpinnerNumberModel(180, 0, 360, 1));
		if (hasAngle) {
			add(new JLabel("Angle "));
			add(angle);
		}
	}
	private final JSpinner angle;
	private final JSpinner endHeight;
	private final JSpinner startHeight;
	private final JSpinner length;

	public int getLength() {
		return (Integer) length.getValue();
	}

	public double getEndHeight() {
		return (Double) endHeight.getValue();
	}

	public double getStartHeight() {
		return (Double) startHeight.getValue();
	}

	public int getAngle() {
		return (Integer) angle.getValue();
	}
}
