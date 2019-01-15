package salsaboy.jopenbrow;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Jopenbrow implements HyperlinkListener
{
    private static JFrame frame = new JFrame("Jopenbrow");
    private static JEditorPane window = new JEditorPane();
    private static JScrollPane scrollPane = new JScrollPane(window);
    private static JTextField searchbar = new JTextField("Search");
    
    private static void gotoPage(URL page)
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
    
    public static void main(String[] args) throws MalformedURLException
    {
        frame.setLayout(new BorderLayout());
    
        window.setEditable(false);
        window.addHyperlinkListener(new Jopenbrow());
        
        frame.add(searchbar, BorderLayout.NORTH);
        frame.add(scrollPane);
        
        gotoPage(new URL("https://www.bing.com/"));
        
        searchbar.addActionListener(e ->
        {
            try
            {
                gotoPage(new URL(searchbar.getText()));
            } catch (MalformedURLException e1)
            {
                e1.printStackTrace();
            }
        });
        
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    @Override
    public void hyperlinkUpdate(HyperlinkEvent e)
    {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
        {
            gotoPage(e.getURL());
        }
    }
}
