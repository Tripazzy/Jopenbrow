package salsaboy.jopenbrow;

import java.io.*;
import java.net.URL;
import java.net.URISyntaxException;
import java.util.Properties;

public class Jopenbrow {
    public static URL homepage;
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        Properties appProperties = new Properties();
        appProperties.load(Jopenbrow.class.getResourceAsStream("config.properties"));

        homepage = new URL(appProperties.getProperty("homepage"));

        new Window();
    }
}
