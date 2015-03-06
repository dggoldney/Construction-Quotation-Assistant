
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DrawingGUI extends JFrame {
	static String[] difficultyOptions = { "Normal", "Sandy", "Limestone", "Bluestone"};

	public static void main(String[] args) {
		final DrawingGUI drawingGUI = new DrawingGUI();
	}

	public DrawingGUI() throws HeadlessException {
		super("Construction Quotation Assistant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		Container c = getContentPane();
		setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.add(new DrawingPanel());
		
		JPanel widgetsPanel = new JPanel();
		widgetsPanel.setLayout(new BoxLayout(widgetsPanel, BoxLayout.X_AXIS));
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setMaximumSize(new Dimension(250, 60));
		buttonsPanel.setLayout(new GridLayout(2, 2));
		
		buttonsPanel.add(new JLabel("Job identifier"));
		JTextField jobIdentifier = new JTextField();
		jobIdentifier.setPreferredSize(new Dimension(70, 30));
		buttonsPanel.add(jobIdentifier);
		
		JButton addSegmentButton = new JButton("Add segment");
		buttonsPanel.add(addSegmentButton);
		widgetsPanel.add(buttonsPanel);
		
		widgetsPanel.add(Box.createRigidArea(new Dimension(30,0)));
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setMaximumSize(new Dimension(300, 150));
		optionsPanel.setBorder(BorderFactory.createTitledBorder("Options"));
		optionsPanel.setLayout(new GridLayout(3,1));
		
		JCheckBox local = new JCheckBox("Is the wall to be built locally?");
		optionsPanel.add(local, 0);
		JCheckBox access = new JCheckBox("Is there adequate access to the site?");
		optionsPanel.add(access, 1);
		JComboBox difficulty = new JComboBox(difficultyOptions);
		optionsPanel.add(difficulty, 2);
		
		widgetsPanel.add(optionsPanel);
		
		c.add(widgetsPanel);
		
		addSegmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel inputPanel = new NewWallSegmentPanel();
				int result = JOptionPane.showConfirmDialog(DrawingGUI.this, inputPanel, "Add a wall segment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					// TODO add wall segment from fields in inputPanel
				}
			}

		});

		JScrollPane drawingPanelScrollPane = new JScrollPane(new QuotationPanel());
		c.add(drawingPanelScrollPane);

		pack();
		setVisible(true);

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
