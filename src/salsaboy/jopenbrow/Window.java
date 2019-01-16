package salsaboy.jopenbrow;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Window extends JFrame implements HyperlinkListener, KeyListener
{
	public static String homepage = "https://www.google.com/";
	
	private JEditorPane page = new JEditorPane();
	private JTextField search = new JTextField();
	private JScrollPane scrollPane = new JScrollPane(page);
	
	public Window(URL url)
	{
		setLayout(new BorderLayout());
		
		try
		{
			page.setPage(url);
		} catch (IOException e)
		{
			page.setText("404 Page not found");
		}
		
		page.setEditable(false);
		
		search.setText(url.toString());
		
		add(scrollPane);
		add(search, BorderLayout.NORTH);
		
		page.addHyperlinkListener(this);
		scrollPane.addKeyListener(this);
		
		search.addActionListener(e ->
		{
			try
			{
				page.setPage(search.getText());
			} catch (IOException e1)
			{
				page.setText("404 Page not found");
			}
		});
		
		repaint();
		
		setSize(1280, 720);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void gotoPage(URL url)
	{
		try
		{
			page.setPage(url);
		} catch (IOException e)
		{
			page.setText("404 Page not found");
		}
		
		repaint();
	}
	
	@Override
	public void hyperlinkUpdate(HyperlinkEvent e)
	{
		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
		{
			gotoPage(e.getURL());
			search.setText(e.getURL().toString());
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
	}
	
	private boolean control, t;
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		t = e.getKeyChar() == 't';
		control = e.getKeyCode() == KeyEvent.VK_META || e.getKeyCode() == KeyEvent.VK_CONTROL;
		
		if (control && t)
		{
			try
			{
				new Window(new URL(Window.homepage));
			} catch (MalformedURLException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyChar() == 't') t = false;
		if (e.getKeyCode() == KeyEvent.VK_CONTROL || e.getKeyCode() == KeyEvent.VK_META) control = false;
		
		if (e.getKeyCode() == KeyEvent.VK_F12) page.setEditable(!page.isEditable());
	}
}
