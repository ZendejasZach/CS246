package Prove03.Zendejas;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class SendRequest {
    public SendRequest(WeatherRequest w) throws IOException {

        // Setup for query
        String charset = "UTF-8";
        String units = "imperial"; // For correct temp units
        String query = String.format("q=%s&units=%s&apiKey=%s",
                URLEncoder.encode(w.getCity(), charset),
                URLEncoder.encode(units, charset),
                URLEncoder.encode(w.getApi(), charset));

        // Send the query
        URLConnection connection = new URL(w.getUrl() + "?" + query).openConnection();
        connection.setRequestProperty("Accept-charset", charset);
        InputStream response = connection.getInputStream();

        // Response
        try (Scanner scanner = new Scanner(response)) {
            w.setData(scanner.useDelimiter("//A").next());
        }
    }
}
