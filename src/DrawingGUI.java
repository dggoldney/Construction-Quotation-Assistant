
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Hayden
 */
public class DrawingGUI extends JFrame {

	public static void main(String[] args) {
		final DrawingGUI drawingGUI = new DrawingGUI();
	}

	public DrawingGUI() throws HeadlessException {
		super("Banana Construction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(new DrawingPanel());
		mainPanel.add(new JButton("Open"));
		final JButton addSegment = new JButton("Add segment");
		mainPanel.add(addSegment);
		addSegment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel inputPanel = new InputPanel();
				int result = JOptionPane.showConfirmDialog(DrawingGUI.this, inputPanel, "Add a wall segment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					// TODO add wall segment from fields in inputPanel
				}
			}

		});

		JScrollPane drawingPanelScrollPane = new JScrollPane(new QuotationPanel());
		mainPanel.add(drawingPanelScrollPane);

		getContentPane().add(mainPanel);
		pack();
		setVisible(true);

	}

}
