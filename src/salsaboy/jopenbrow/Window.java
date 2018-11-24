package salsaboy.jopenbrow;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {
    public List<Tab> tabs = new ArrayList<>();
    
    public Window() {
        super("Jopenbrow");
        
        setSize(1115, 690);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void addTab() {
    
    }
}
