package models;

/**
 *
 * @author Paul
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharacterMovement  implements KeyListener{
    //Classes from other packets
    Customer student;
    
    private String animation = "left1.png";
    private String facing = "";
    private boolean isInteracting = false;
    private int frame = 0;
    private int stationNumber;

    //int variables
    int oldX = 0;
    int oldY = 0;
    
    //Empty constructor
    public CharacterMovement() {
        
    }
    
    //Constructor to initialize the student
    public CharacterMovement(Customer student) {
        this.student = student;
    }
    
    public void keyPressed(KeyEvent ke) {
//        System.out.println("Working?");
        oldX = student.x;
        oldY = student.y;

        if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D) {
            if (frame < 5) {
                animation = student.getAnimation()[0];
                frame++;
            } else if (frame >= 5 && frame < 10) {
                animation = student.getAnimation()[1];
                frame++;
            } else if (frame > 9) {
                frame = 0;
            }
            student.x = student.x + 5;
        } else if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A) {
            if (frame < 5) {
                animation = student.getAnimation()[2];
                frame++;
            } else if (frame >= 5 && frame < 10) {
                animation = student.getAnimation()[3];
                frame++;
            } else if (frame > 9) {
                frame = 0;
            }
            student.x = student.x - 5;
        } else if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_W) {
            if (frame < 5) {
                animation = student.getAnimation()[4];
                frame++;
            } else if (frame >= 5 && frame < 10) {
                animation = student.getAnimation()[5];
                frame++;
            } else if (frame > 9) {
                frame = 0;
            }
            student.y = student.y - 5;
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_S) {
            if (frame < 5) {
                animation = student.getAnimation()[6];
                frame++;
            } else if (frame >= 5 && frame < 10) {
                animation = student.getAnimation()[7];
                frame++;
            } else if (frame > 9) {
                frame = 0;
            }
            student.y = student.y + 5;
        }
    }

    public String getAnimation() {
        return animation;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    /*
        PAUL'S CODE
    */

    public void setAnimation(String set) {
        animation = set;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String set) {
        facing = set;
    }
    

    public boolean getIsInteracting()
    {
        return isInteracting;

    }
    
    public void setIsInteracting(boolean set)
    {
        isInteracting = set;
    }
    
    public int getFrame()
    {
        return frame;
    }
    
    public void setFrame(int set)
    {
        frame = set;
    }

    public int getStationNumber()
    {
        return stationNumber;
    }
    
    public void setStationNumber(int set)
    {
        stationNumber = set;
    }
    
}
