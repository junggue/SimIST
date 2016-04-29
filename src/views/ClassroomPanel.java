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
    
    //Height and width for the rectangles
    private final int height = 40;
    private final int width = 42;

    //Rectangles for the teleport    
    public Rectangle ABPTeleport;
    public Rectangle Room206Teleport;
    public Rectangle MeetingRoomTeleport;
    public Rectangle CybertoriumTeleport;
    
    //initialize the character
    Customer student;
    
    public ClassroomPanel (ClassroomController parentController) {
        this.theClassroomController = parentController;
        
        setSize(CLASS_WIDTH, CLASS_HEIGHT);
        
        theClassroomController.getCustomer().setBounds(70,300, theClassroomController.getCustomer().width, theClassroomController.getCustomer().height);
        
        mousePointerInfo = new JLabel();
        add(mousePointerInfo);
        mousePointerInfo.setBounds(200, 200, 200, 200);
        setVisible(true);
        
        initializingRectangle();
        
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e)
            {
                mousePointerInfo.setText(e.getPoint().toString());
            }
        });
        
        this.addKeyListener(theClassroomController.getCharacterMovement());
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("classroom_renderModifiedPng.png").getImage(), 0,0, this);
        g.drawImage(new ImageIcon(theClassroomController.getCharacterMovement().getAnimation()).getImage(), 
                theClassroomController.getCustomer().x, theClassroomController.getCustomer().y, null);
    }
    
    public void initializingRectangle() {
        ABPTeleport = new Rectangle(545, 205, height, width);
        Room206Teleport = new Rectangle(427, 97, height, width);
        MeetingRoomTeleport = new Rectangle(300, 131, height, width);
        CybertoriumTeleport = new Rectangle(0, 267, height, width);
    }
}

