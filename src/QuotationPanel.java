
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QuotationPanel extends JPanel {

	private final DrawingGUI gui;

	private DefaultTableModel tableModel;
	
	public QuotationPanel(DrawingGUI gui) {
		this.gui = gui;
		JTable quote = new JTable();
		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		quote.setModel(tableModel);
		add(new JScrollPane(quote));
	}
	
	public void drawQuote() {
		Wall wall = gui.wall;

		Object[][] data = new Object[wall.getNumberOfSegments()][5];
		
		for (int i = 0; i < wall.getNumberOfSegments(); i++) {
			WallSegment segment = wall.getSegment(i);
			
			data[i][0] = i + 1; // Segment number
			data[i][1] = segment.getNumberOfBays(); // qty of bays
			data[i][2] = segment.getSleepersInWallSegment(); // qty of sleepers
			data[i][3] = 170; // base sleeper cost
			data[i][4] = segment.getSleepersInWallSegment() * 170; // total cost
		}
	
		String[] colTitles = {"Segment", "Qty of Bays", "Qty of Sleepers", "Price Per Sleeper", "Total"};
		tableModel.setDataVector(data, colTitles);

		JLabel subTotal = new JLabel("Sub Total");
		add(subTotal);
	}

}
