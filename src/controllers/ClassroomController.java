package controllers;

import java.awt.Dimension;
import views.ClassroomFrame;
import views.ClassroomPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import models.*;
import views.Cybertorium;

/**
 *
 * @author junggue, ed
 */
public class ClassroomController {

    private ClassroomFrame classroomFrame;
    private ClassroomPanel classroomPanel;
    private Timer gameTimer;
    
    // Attributes related to character
    public Customer student;
    private CharacterMovement charMovement;
    
    private int height;
    private int width;

    public ClassroomController() {
        // bring the character and characterMoevement
        student = new Customer();
        charMovement = new CharacterMovement(student);

        // frame and panel
        classroomFrame = new ClassroomFrame();
        classroomPanel = new ClassroomPanel(this);

        classroomFrame.add(classroomPanel);

        gameTimer = new Timer(5, new GameTimer());
        gameTimer.start();
    }

    public Customer getCustomer() {
        return student;
    }

    public CharacterMovement getCharacterMovement() {
        return charMovement;
    }

    class GameTimer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            classroomPanel.repaint();
            collision();
        }
    }
    
    
    public void collision (){
//        this.height = student.height;
//        this.width = student.width;
//        System.out.println ("This is the height: " + height);
//        System.out.println ("This is the width: " + width);
        if (student.intersects(classroomPanel.ABPTeleport)) {
            try {
                    gameTimer.stop();
                    ABPController ABPpanel = new ABPController();
                } catch (Exception ex) {
                    System.err.println(ex);
                }
        }
        
        if (student.intersects(classroomPanel.Room206Teleport)) {
            try {
                    gameTimer.stop();
                    RoomController room206 = new RoomController();
                } catch (Exception ex) {
                    System.err.println(ex);
                }
        }
        if (student.intersects(classroomPanel.CybertoriumTeleport)) {
            try {
                    gameTimer.stop();
                    FrameTester frame = new FrameTester(new Cybertorium());
                } catch (Exception ex) {
                    System.err.println(ex);
                }
        }
        if (student.intersects(classroomPanel.MeetingRoomTeleport)) {
            try {
                    gameTimer.stop();
                    MRController meetingRoom = new MRController();
                } catch (Exception ex) {
                    System.err.println(ex);
                }
        }
    }
}
