
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	// TODO Spec says that the job identifier should be included in the drawing space
	// TODO modify the height of individual bays by clicking and dragging
	
    //TODO multiple view angles with buttons to switch between them.
    //TODO support for multiple walls connecting at an angle
    //TODO improve visual design to appear more like a wall and less like a boring game of tetris? the edges of bays could look a lot better but doing so might take up more space and complicate the visualization.
    //TODO ???
    
    //the height and width of an individual sleeper in pixels. are calculated later so these assignments are probably unnecessary now.
    int sleeperDisplayHeight = 80;
    int sleeperDisplayWidth = 8;
    //the current dimensions of the frame. doesn't need to be variables but is easier than typing this.getSize().height every time. needs to be updated every frame e.g. in the draw method
    int currentWindowHeight;
    int currentWindowWidth;

    //a wall used for testing.
    //TODO: stop using this and connect this panel up with the wall object calculated from the user input.
//    int[] testWall = new int[]{4, 6, 8, 9, 10, 12, 12, 10};

	DrawingGUI gui;
	
    public DrawingPanel(DrawingGUI gui) {
		this.gui = gui;
        setPreferredSize(new Dimension(720, 430));
        setBackground(Color.GRAY);
        add(new JLabel("Drawing space"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentWindowHeight = this.getSize().height;
        currentWindowWidth = this.getSize().width;
        drawWall(g, gui.wall.getSegment(gui.wall.getNumberOfSegments() - 1).bayHeights);
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
        //TODO: Consider absolute sizes with scroll bars instead of scaling as implemented below. maybe a combination of both if time permits.
        
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

    //returns the height of the tallest bay in specified wall
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
