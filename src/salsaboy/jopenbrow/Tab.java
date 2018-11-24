package salsaboy.jopenbrow;

import javax.swing.JPanel;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class Tab extends JPanel implements AutoCloseable {
    private void display() {
        //Get the title first
        title = contentOfTag("title");
        
        //Display
        
    }
    
    private String contentOfTag(String tag) {
        return html.split("<" + tag + ">")[1].split("</" + tag + ">")[0];
    }

    private HTTPRequester httpClient;

    public URI currentURI;
    public String html;
    public String title;
    
    public Tab(HTTPRequester httpClient) {
        this(httpClient, Jopenbrow.homepage);
    }
    public Tab(HTTPRequester httpClient, URI location) {
        this.httpClient = httpClient;

        currentURI = location;
        try {
            html = httpClient.requestPage(currentURI);
        } catch (IOException e) {
            html = HTTPRequester.requestErrorPage();
        }
        
        display();
    }

    @Override
    public void close() throws Exception {
        httpClient.close();
    }
}
