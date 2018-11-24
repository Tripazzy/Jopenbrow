package salsaboy.jopenbrow;

import java.io.IOException;
import java.net.URL;

public class Tab {
    public URL currentURL;
    public String html;
    
    public Tab() {
        this(Jopenbrow.homepage);
    }
    public Tab(URL location) {
        currentURL = location;
        try {
            html = HTMLRequest.requestString(currentURL);
        } catch (IOException e) {
            try {
                html = HTMLRequest.requestString(this.getClass().getResource("error.html"));
            } catch (IOException e1) {
                System.err.println("error.html has the big loss");
            }
        }
    }
}
