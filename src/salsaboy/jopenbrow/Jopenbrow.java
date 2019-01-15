package salsaboy.jopenbrow;

import java.net.MalformedURLException;
import java.net.URL;

public class Jopenbrow
{
    public static void main(String[] args) throws MalformedURLException
    {
        new Window(new URL(Window.homepage));
    }
}
