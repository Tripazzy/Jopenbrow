package salsaboy.jopenbrow;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HTMLRequest {
    public static String requestString(URL location) throws IOException {
        InputStream html = location.openStream();
    
        String ret = "";
        
        //Make this better later.
        int val = 0;
        do {
            val = html.read();
            ret += ((char) val);
        } while (val != -1);
        
        return ret;
    }
    public static String requestErrorPage() {
        return "<!doctype html><html><head><title>Error</title</head><body><h1>Cannot find the page required.</h1></body></html>";
    }
}
