package views;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author junggue, ed
 */
public class ClassroomFrame extends JFrame{
    public ClassroomFrame () {
        this.setTitle("Classroom");
        this.setSize(670,510);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.validate();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
