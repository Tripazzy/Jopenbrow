package salsaboy.jopenbrow;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Window extends JFrame implements AutoCloseable {

    HTTPRequester httpClient;

    Tab currentPage;
    
    public Window() {
        super("Jopenbrow");
        httpClient = new HTTPRequester();
        
        currentPage = new Tab(httpClient);
        setTitle(currentPage.title);
    
        setSize(1115, 690);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public Window(String site) {
        super("Jopenbrow");
        httpClient = new HTTPRequester();

        try {
            currentPage = new Tab(httpClient, new URI(site));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        setTitle(currentPage.title);
        setSize(1115, 690);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void close() throws Exception {
        currentPage.close();
    }
}
