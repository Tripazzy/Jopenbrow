package salsaboy.jopenbrow;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class Jopenbrow {
    public static URL homepage;
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner configReader = new Scanner(new File(Jopenbrow.class.getResource("data").toURI()));
        while (configReader.hasNext()) {
            String full = configReader.nextLine();
            String command = full.split(":")[0];
            String param = full.split(":")[1] + ":" + full.split(":")[2];
            
            switch (command) {
                case "homepage":
                    homepage = new URL(param);
                    break;
            }
        }
        
        new Window();
    }
}
