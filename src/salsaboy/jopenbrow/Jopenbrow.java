package salsaboy.jopenbrow;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Jopenbrow {
    public static URL homepage;
    
    public static void main(String[] args) throws IOException {
        Scanner configReader = new Scanner(Jopenbrow.class.getResource("data").toString());
        while (configReader.hasNext()) {
            String full = configReader.nextLine();
            String command = full.split(":")[0];
            String param = full.split(":")[1];
            
            switch (command) {
                case "homepage":
                    homepage = new URL(param);
                    break;
            }
        }
        
        new Window();
    }
}
