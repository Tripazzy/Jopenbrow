package salsaboy.jopenbrow;

import javax.swing.*;
import java.awt.BorderLayout;
import java.io.IOException;

public class Jopenbrow
{
    private static JFrame frame = new JFrame("Jopenbrow");
    private static JEditorPane window = new JEditorPane();
    private static JScrollPane scrollPane = new JScrollPane(window);
    private static JTextField searchbar = new JTextField("Search");
    
    private static void gotoPage(String page)
    {
        try
        {
            window.setPage(page);
        } catch (IOException e)
        {
            window.setText("404 Page not found");
        }
        
        frame.repaint();
    }
    
    public static void main(String[] args)
    {
        frame.setLayout(new BorderLayout());
    
        window.setEditable(false);
        
        frame.add(searchbar, BorderLayout.NORTH);
        frame.add(scrollPane);
        
        gotoPage("foo");
        
        searchbar.addActionListener(e -> gotoPage(searchbar.getText()));
        
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
