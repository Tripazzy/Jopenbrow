package salsaboy.jopenbrow;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends JFrame {
    public Window() {
        super("Jopenbrow");
        
        setSize(1115, 690);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
