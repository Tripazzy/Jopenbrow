package salsaboy.jopenbrow;

import java.net.URL;

public class Tab {
    public URL currentURL;
    public String html;
    
    public Tab() {
        this(Jopenbrow.homepage);
    }
    public Tab(URL location) {
    
    }
}
