package salsaboy.jopenbrow;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {
    public List<Tab> tabs = new ArrayList<>();
    
    public Window() {
        super("Jopenbrow");
        
        tabs.add(new Tab());
        
        setSize(1115, 690);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public Window(String site) {
        super("Jopenbrow");
    
        try {
            tabs.add(new Tab(new URL(site)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    
        setSize(1115, 690);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
