
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DrawingGUI extends JFrame {

	public Wall wall;
	final static String[] difficultyOptions = {"Normal", "Sandy", "Limestone", "Bluestone"};

	public static void main(String[] args) {
		DrawingGUI gui = new DrawingGUI();

		NewWallSegmentPanel inputPanel = new NewWallSegmentPanel();
		int result = JOptionPane.showConfirmDialog(null, inputPanel, "Add a wall segment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			gui.wall.addWallSegment(new WallSegment(inputPanel.getLength(), inputPanel.getStartHeight(), inputPanel.getEndHeight(), inputPanel.getAngle()));
		}
		
		gui.pack();
		gui.setVisible(true);
	}

	public DrawingGUI() throws HeadlessException {
		super("Construction Quotation Assistant");
		wall = new Wall(false, false, Difficulty.normal);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createMenu();
		Container c = getContentPane();
		setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		final DrawingPanel drawingPanel = new DrawingPanel(this);
		c.add(drawingPanel);

		JPanel widgetsPanel = new JPanel();
		widgetsPanel.setLayout(new BoxLayout(widgetsPanel, BoxLayout.X_AXIS));

		JButton addSegmentButton = new JButton("Add segment");
		widgetsPanel.add(addSegmentButton);

		widgetsPanel.add(Box.createRigidArea(new Dimension(30, 0)));

		JPanel optionsPanel = new JPanel();
		optionsPanel.setMaximumSize(new Dimension(300, 150));
		optionsPanel.setBorder(BorderFactory.createTitledBorder("Options"));
		optionsPanel.setLayout(new GridLayout(3, 1));

		JCheckBox local = new JCheckBox("Is the wall to be built locally?");
		optionsPanel.add(local, 0);
		JCheckBox access = new JCheckBox("Is there adequate access to the site?");
		optionsPanel.add(access, 1);
		JComboBox difficulty = new JComboBox(difficultyOptions);
		optionsPanel.add(difficulty, 2);
		
		ActionListener settingsListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DrawingGUI.this.wall.setLocal(local.isSelected());
				DrawingGUI.this.wall.setAccess(access.isSelected());
				DrawingGUI.this.wall.setDifficulty((String) difficulty.getSelectedItem());
			}
		};
		
		local.addActionListener(settingsListener);
		access.addActionListener(settingsListener);
		difficulty.addActionListener(settingsListener);

		widgetsPanel.add(optionsPanel);

		c.add(widgetsPanel);

		addSegmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NewWallSegmentPanel inputPanel = new NewWallSegmentPanel();
				int result = JOptionPane.showConfirmDialog(DrawingGUI.this, inputPanel, "Add a wall segment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					wall.addWallSegment(new WallSegment(inputPanel.getLength(), inputPanel.getStartHeight(), inputPanel.getEndHeight(), inputPanel.getAngle()));
					drawingPanel.repaint();
				}
			}

		});

		JScrollPane drawingPanelScrollPane = new JScrollPane(new QuotationPanel());
		c.add(drawingPanelScrollPane);
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem menuItemNew = new JMenuItem("New");
		JMenuItem menuItemOpen = new JMenuItem("Open");
		menu.add(menuItemNew);
		menu.add(menuItemOpen);
		setJMenuBar(menuBar);
	}
}
