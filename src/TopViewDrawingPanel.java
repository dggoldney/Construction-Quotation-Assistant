
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
the top view requires that the rectangles representing the bays can be drawn at varying angles. it seems drawRect can't support this so drawPolygon may be necessary
a custom method for drawing rects may be created using drawPolygon to make the rest of the code simpler.
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
        //TODO resizing and/or scrolling
        drawBay(g, 100, 100, 135);
        
    }
    
    
    protected void drawBay(Graphics g, int positionX, int positionY, int angle) {
        angle = 360 - angle;
        Polygon p = new Polygon();
        int lastX = positionX;
        int lastY = currentWindowHeight - positionY;
        p.addPoint(lastX, lastY);
        angle -= 90;
        lastX += sleeperDisplayWidth * Math.cos(Math.toRadians(angle));
        lastY += sleeperDisplayWidth * Math.sin(Math.toRadians(angle));
        p.addPoint(lastX, lastY);
        angle -= 90;
        lastX += sleeperDisplayHeight * Math.cos(Math.toRadians(angle));
        lastY += sleeperDisplayHeight * Math.sin(Math.toRadians(angle));
        //one of these points should be the one the next wall will be following. maybe return the coordinates to use for the positionX and positionY of the next wall
        p.addPoint(lastX, lastY);
        angle -= 90;
        lastX += sleeperDisplayWidth * Math.cos(Math.toRadians(angle));
        lastY += sleeperDisplayWidth * Math.sin(Math.toRadians(angle));
        p.addPoint(lastX, lastY);
        
        
        
        g.drawPolygon(p);
        g.setColor(Color.BLUE);
        g.fillPolygon(p);
    }
    
    protected void drawWallSegment() {
        //draw all bays in the wall segment
    }
    
    protected void drawWall() {
        //draw all wall segments in the wall
    }
}
