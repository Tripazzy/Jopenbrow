package salsaboy.jopenbrow;

import javax.swing.JPanel;
import java.io.IOException;
import java.net.URL;

public class Tab extends JPanel {
    private void display() {
        //Get the title first
        title = contentOfTag("title");
        
        //Display
        
    }
    
    private String contentOfTag(String tag) {
        return html.split("<" + tag + ">")[1].split("</" + tag + ">")[0];
    }
    
    public URL currentURL;
    public String html;
    public String title;
    
    public Tab() {
        this(Jopenbrow.homepage);
    }
    public Tab(URL location) {
        currentURL = location;
        try {
            html = HTMLRequest.requestString(currentURL);
        } catch (IOException e) {
            html = HTMLRequest.requestErrorPage();
        }
        
        display();
    }
}
