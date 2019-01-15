package salsaboy.jopenbrow;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import java.io.IOException;
import java.net.URL;

public class Jopenbrow
{
    private static JFrame frame = new JFrame("Jopenbrow");
    private static JEditorPane window = new JEditorPane();
    private static JScrollPane scrollPane = new JScrollPane(window);
    
    public static void main(String[] args)
    {
        try
        {
            window.setPage(new URL("https://www.ecosia.org/"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    
        window.setEditable(false);
        
        frame.add(scrollPane);
        
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
