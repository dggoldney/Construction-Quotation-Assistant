
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

    
    /*
    this functionality of this class has been split in to two subclasses, FrontViewDrawingPanel and TopViewDrawingPanel
    the function of this class will be to manage these two new panels,
    e.g. hiding and showing frontPanel as needed, handing it a new wallsegment reference when one is selected on the topPanel, etc
    */
    
    /*
    
    */
    
    // TODO Spec says that the job identifier should be included in the drawing space
    //TODO modify the height of individual bays by clicking and dragging
    //TODO multiple view angles with buttons to switch between them.

    //seperate panels for the top view and front view.
    TopViewDrawingPanel topPanel;
    FrontViewDrawingPanel frontPanel;

    DrawingGUI gui;

    public DrawingPanel(DrawingGUI gui) {
        this.gui = gui;
        setPreferredSize(new Dimension(720, 430));
        setBackground(Color.GRAY);

        setLayout(new GridLayout(2,1));
        topPanel = new TopViewDrawingPanel(gui);
        frontPanel = new FrontViewDrawingPanel(gui);
        
        this.add(topPanel);
        this.add(frontPanel);
        
    }
    
    public void ShowFrontPanel() {
        this.add(frontPanel);
        setLayout(new GridLayout(2,1));
        this.revalidate();
    }
    
    public void HideFrontPanel() {
        this.remove(frontPanel);
        setLayout(new GridLayout());
        this.revalidate();
    }
}
