
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	public DrawingPanel() {
		setPreferredSize (new Dimension(720,430));
		setBackground(Color.BLUE);
		add(new JLabel("Drawing space"));
	}

}
