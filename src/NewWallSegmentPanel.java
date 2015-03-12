
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

class NewWallSegmentPanel extends JPanel {

	public NewWallSegmentPanel() {
		setLayout(new GridLayout(5, 2));
		add(new JLabel("Length"));
		length = new JSpinner(new SpinnerNumberModel(10, 0, 100, 2));
		add(length);
		add(new JLabel("Start height"));
		startHeight = new JSpinner(new SpinnerNumberModel(1, 0, 100, 0.2));
		add(startHeight);
		add(new JLabel("End height"));
		endHeight = new JSpinner(new SpinnerNumberModel(15, 0, 100, 0.2));
		add(endHeight);
		add(new JLabel("Angle"));
		angle = new JSpinner(new SpinnerNumberModel(0, 0, 90, 1));
		add(angle);
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
