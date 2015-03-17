
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 the top view requires that the rectangles representing the bays can be drawn at varying angles. it seems drawRect can't support this so drawPolygon may be necessary
 a custom method for drawing bays may be created using drawPolygon to make the rest of the code simpler.
 */

/*
TODO:
    * resizing and/or scrolling
    * user interaction (selection of a wallsegment for display on the frontPanel)
    * wall segments should default to the angle of the previous segment, rather than parallel with the x axis
*/
public class TopViewDrawingPanel extends JPanel {

    DrawingGUI gui;

    int sleeperDisplayHeight = 80;
    int sleeperDisplayWidth = 8;

    int currentWindowHeight;
    int currentWindowWidth;

    public TopViewDrawingPanel(DrawingGUI gui) {
        this.gui = gui;
        setPreferredSize(new Dimension(720, 430));
        setBackground(Color.GRAY);
        add(new JLabel("Top View"));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentWindowHeight = this.getSize().height;
        currentWindowWidth = this.getSize().width;
        drawWall(g, 100, 100, gui.wall);

    }

    protected Point drawBay(Graphics g, int positionX, int positionY, int angle) {
        angle = 360 - angle;
        Polygon p = new Polygon();
        int lastX = positionX;
        int lastY = positionY;
        p.addPoint(lastX, lastY);
        angle -= 90;
        lastX += sleeperDisplayWidth * Math.cos(Math.toRadians(angle));
        lastY += sleeperDisplayWidth * Math.sin(Math.toRadians(angle));
        p.addPoint(lastX, lastY);
        angle -= 90;
        lastX += sleeperDisplayHeight * Math.cos(Math.toRadians(angle));
        lastY += sleeperDisplayHeight * Math.sin(Math.toRadians(angle));
        p.addPoint(lastX, lastY);
        angle -= 90;
        lastX += sleeperDisplayWidth * Math.cos(Math.toRadians(angle));
        lastY += sleeperDisplayWidth * Math.sin(Math.toRadians(angle));
        p.addPoint(lastX, lastY);

        g.setColor(Color.BLUE);
        g.fillPolygon(p);
        g.setColor(Color.WHITE);
        g.drawPolygon(p);

        return new Point(lastX, lastY);
    }

    protected Point drawWallSegment(Graphics g, int positionX, int positionY, int angle, int numberOfBays) {
        //draw all bays in the wall segment
        for (int i = 0; i < numberOfBays; i++) {
            Point x = drawBay(g, positionX, positionY, angle);
            positionX = (int) x.getX();
            positionY = (int) x.getY();
        }
        return new Point(positionX, positionY);
    }

    protected void drawWall(Graphics g, int positionX, int positionY, Wall wall) {
        //draw all wall segments in the wall
        for (int i = 0; i < wall.getNumberOfSegments(); i++) {
            Point x = drawWallSegment(g, positionX, positionY, gui.wall.getSegment(i).angle, gui.wall.getSegment(i).getNumberOfBays());
            positionX = (int) x.getX();
            positionY = (int) x.getY();
        }
    }
}
