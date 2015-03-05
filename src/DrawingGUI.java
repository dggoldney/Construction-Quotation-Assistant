
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DrawingGUI extends JFrame {
	static String[] difficultyOptions = { "Not difficult", "Sandy", "Limestone", "Bluestone"};

	public static void main(String[] args) {
		final DrawingGUI drawingGUI = new DrawingGUI();
	}

	public DrawingGUI() throws HeadlessException {
		super("Construction Quotation Assistant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(new DrawingPanel());
		
		JPanel widgetsPanel = new JPanel();
		widgetsPanel.setLayout(new BoxLayout(widgetsPanel, BoxLayout.X_AXIS));
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2, 2));
		
		buttonsPanel.add(new JLabel("Job identifier"));
		JTextField jobIdentifier = new JTextField();
		jobIdentifier.setPreferredSize(new Dimension(70, 30));
		buttonsPanel.add(jobIdentifier);
		
		JButton openButton = new JButton("Open");
		buttonsPanel.add(openButton);
		JButton addSegmentButton = new JButton("Add segment");
		buttonsPanel.add(addSegmentButton);
		widgetsPanel.add(buttonsPanel);
		
		JPanel optionsPane = new JPanel();
//		optionsPane.setPreferredSize(new Dimension(200, 200));
		optionsPane.setBorder(BorderFactory.createTitledBorder("Options"));
		
		JCheckBox local = new JCheckBox("Is the wall to be built locally?");
		optionsPane.add(local, 0);
		JCheckBox access = new JCheckBox("Is there adequate access to the site?");
		optionsPane.add(access, 1);
		JComboBox difficulty = new JComboBox(difficultyOptions);
		optionsPane.add(difficulty, 2);
		
		widgetsPanel.add(optionsPane);
		
		mainPanel.add(widgetsPanel);
		
		addSegmentButton.addActionListener(new ActionListener() {

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
