
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class QuotationPanel extends JPanel {

    private final DrawingGUI gui;

    private final DefaultTableModel tableModel;
    private JTable quote;
    private JLabel subTotal;

    public QuotationPanel(DrawingGUI gui) {
        this.gui = gui;
        quote = new JTable();
        Container c = this;
        setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        setPreferredSize(new Dimension(800, 300));

        //create a table model to chance cells to not allow editing
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        //Set the table with the bays and sleeper information
        quote.setModel(tableModel);
        JScrollPane quoteSP = new JScrollPane(quote);
        quoteSP.setPreferredSize(new Dimension(650, 100));
        c.add(quoteSP);

        //subtotal information
        JPanel subtotalPanel = new JPanel();
        subtotalPanel.setLayout(new BoxLayout(subtotalPanel, BoxLayout.X_AXIS));

        subTotal = new JLabel("Sub Total = ");
        subtotalPanel.add(subTotal);

        subTotal = new JLabel();
        subtotalPanel.add(subTotal);
        c.add(subtotalPanel);
    }

    public void drawQuote() {
        Wall wall = gui.wall;
        int subtotal = 0;

        Object[][] data = new Object[wall.getNumberOfSegments()][5];

        for (int i = 0; i < wall.getNumberOfSegments(); i++) {
            WallSegment segment = wall.getSegment(i);

            data[i][0] = i + 1; // Segment number
            data[i][1] = segment.getNumberOfBays(); // qty of bays
            data[i][2] = segment.getSleepersInWallSegment(); // qty of sleepers
            data[i][3] = "$" + 170; // base sleeper cost
            data[i][4] = "$" + segment.getSleepersInWallSegment() * 170; // total cost
            subtotal += segment.getSleepersInWallSegment() * 170;
        }

        String[] colTitles = {"Segment", "Qty of Bays", "Qty of Sleepers", "Price Per Sleeper", "Total"};
        tableModel.setDataVector(data, colTitles);
        quote.setPreferredSize(new Dimension(650, 850));
        setColumnWidths();
        subTotal.setText("$" + subtotal);

    }

    private void setColumnWidths() {
            //set columns in table to be unique sizes
        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = quote.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(80);

            } else {
                column.setPreferredWidth(120);
            }
        }
    }
}
