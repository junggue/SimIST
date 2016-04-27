package views;

import controllers.ClassroomController;
import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;
import java.awt.event.*;
import models.*;

/**
 *
 * @author junggue, ed
 */
public class ClassroomPanel extends JPanel {
    //final variables
    private final int CLASS_WIDTH = 700;
    private final int CLASS_HEIGHT = 700;
    
    //Classes from other packets
    private ClassroomController theClassroomController;
    
    private JLabel mousePointerInfo;
    
    //Rectangles for the teleport
    private final int ABPTeleportHEIGHT = 40;
    private final int ABPTeleportWIDTH = 42;
    public Rectangle ABPTeleport;
    
    public ClassroomPanel (ClassroomController parentController) {
        //super();
        
        this.theClassroomController = parentController;
        
        setSize(CLASS_WIDTH, CLASS_HEIGHT);
        
        theClassroomController.getCustomer().setBounds(70,300, theClassroomController.getCustomer().width, theClassroomController.getCustomer().height);
        
        mousePointerInfo = new JLabel();
        add(mousePointerInfo);
        mousePointerInfo.setBounds(200, 200, 200, 200);
        setVisible(true);
        
        initializingRectangle();
        setRectBounds();
        
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e)
            {
//                System.out.println(e.getPoint());
                mousePointerInfo.setText(e.getPoint().toString());
            }
        });
        
        this.addKeyListener(theClassroomController.getCharacterMovement());
        this.setFocusable(true);
    }

    // reference: http://stackoverflow.com/questions/28017537/how-do-you-draw-and-fill-a-parallelogram-in-java-swing
    // I learned how to create diverse shape form other than rectangles and circles from the above link
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("classroom_renderModifiedPng.png").getImage(), 0,0, this);
        g.drawImage(new ImageIcon(theClassroomController.getCharacterMovement().getAnimation()).getImage(), 
                theClassroomController.getCustomer().x, theClassroomController.getCustomer().y, null);
    }
    
    public void initializingRectangle() {
        ABPTeleport = new Rectangle();
    }
    
    public void setRectBounds () {
        ABPTeleport.setBounds(567,279,ABPTeleportHEIGHT,ABPTeleportWIDTH);
    }
}