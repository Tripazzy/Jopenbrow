package salsaboy.jopenbrow;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Window extends JFrame implements AutoCloseable {

	Tab currentPage;

	public Window() {
		super("Jopenbrow");

		currentPage = new Tab();
		setTitle(currentPage.title);

		setSize(1115, 690);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public Window(String site) {
		super("Jopenbrow");

		try {
			currentPage = new Tab(new URI(site));
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
