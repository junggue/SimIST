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

/**
 *
 * @author junggue, ed
 */
public class ClassroomController {

    private ClassroomFrame classroomFrame;
    private ClassroomPanel classroomPanel;
    private Timer gameTimer;
    
    // Attributes related to character
    private Customer student;
    private CharacterMovement charMovement;

    //Collision
    boolean collision = false;
    
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
    
    
    public void collision () {
        if (student.intersects(classroomPanel.ABPTeleport))
            System.out.println("Collision");
//            collision = true;
    }
    
}
