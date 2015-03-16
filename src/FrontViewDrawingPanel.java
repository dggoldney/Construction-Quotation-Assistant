import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FrontViewDrawingPanel extends JPanel {
    
    int sleeperDisplayHeight = 80;
    int sleeperDisplayWidth = 8;
    
    int currentWindowHeight;
    int currentWindowWidth;
    
    WallSegment activeWallSegment;
    
    /*
    the pattern of passing a reference to the gui should probably be removed with something more loosely binding, e.g. an observer in the parent class or a reference to the parent,
    instead of passing gui around everywhere?
    */
    DrawingGUI gui;
    
    public FrontViewDrawingPanel(DrawingGUI gui) {
        this.gui = gui;
        setPreferredSize(new Dimension(720, 430));
        setBackground(Color.GRAY);
        add(new JLabel("Front View"));
    }
    
    public void setWallSegment(WallSegment wallSegment) {
        activeWallSegment = wallSegment;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        activeWallSegment = gui.wall.getSegment(0);
        drawWall(g, activeWallSegment.bayHeights);
    }
    
    private void drawBay(Graphics g, int pos, int height) {
        //draw each sleeper in the bay
        for (int i = 0; i < height; i++) {
            //draw a black outline.
            g.setColor(Color.BLACK);
            g.drawRect(0 + (sleeperDisplayWidth + 1) * pos, currentWindowHeight - (i + 1) * sleeperDisplayHeight, sleeperDisplayWidth, sleeperDisplayHeight);
            //fill in the rectangle with white.
            g.setColor(Color.WHITE);
            g.fillRect(0 + (sleeperDisplayWidth + 1) * pos, currentWindowHeight - (i + 1) * sleeperDisplayHeight, sleeperDisplayWidth, sleeperDisplayHeight);
        }

    }

    private void drawWall(Graphics g, ArrayList<Integer> bayHeights) {
        
        currentWindowHeight = this.getSize().height;
        currentWindowWidth = this.getSize().width;
        //calculate width values to make use of available screen space
        sleeperDisplayWidth = currentWindowWidth / bayHeights.size();
        //calculate height values to make use of available screen space
        sleeperDisplayHeight = currentWindowHeight / findTallestBay(bayHeights);
        //lower one or the other so that the proper ratio is reached.
        if (sleeperDisplayWidth > 10 * sleeperDisplayHeight) {
            sleeperDisplayWidth = 10 * sleeperDisplayHeight;
        } else if (sleeperDisplayHeight > sleeperDisplayWidth / 10) {
            sleeperDisplayHeight = sleeperDisplayWidth / 10;
        }
        //draw each bay in the wall
        for (int i = 0; i < bayHeights.size(); i++) {
            drawBay(g, i, bayHeights.get(i));
        }
    }
    private int findTallestBay(ArrayList<Integer> wall) {
        int max = 0;
        for (int i = 0; i < wall.size(); i++) {
            if (wall.get(i) > max) {
                max = wall.get(i);
            }

        }
        return max;
    }
}
