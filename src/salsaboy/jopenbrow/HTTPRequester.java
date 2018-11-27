package salsaboy.jopenbrow;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HTTPRequester implements AutoCloseable {

	private final CloseableHttpClient client;

	public HTTPRequester() {
		client = HttpClients.createDefault();
	}

	public static String requestStringOld(URL location) throws IOException {
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

	public String requestPage(URI location) throws IOException {
		HttpUriRequest request = RequestBuilder.get(location)
				.setHeader("User-Agent", "JOpenBrowser v0.1")
				.build();
		CloseableHttpResponse response = client.execute(request);

		String contentTypeFull = response.getEntity().getContentType().getValue();
		String contentType;

		int loc = contentTypeFull.indexOf("charset=");
		if (loc != -1) {
			int spaceLoc = contentTypeFull.indexOf(' ', loc);
			contentType = contentTypeFull.substring(loc + 8, spaceLoc > 0 ? spaceLoc : contentTypeFull.length());
		} else {
			contentType = "utf-8";
		}

		String content;
		Scanner s = new Scanner(response.getEntity().getContent(), contentType).useDelimiter("\\A");

		content = s.hasNext() ? s.next() : "";
		return content;
	}

	public static String requestErrorPage() {
		return "<!doctype html><html><head><title>Error</title></head><body><h1>Cannot find the page required.</h1></body></html>";
	}

	@Override
	public void close() throws Exception {
		client.close();
	}
}
