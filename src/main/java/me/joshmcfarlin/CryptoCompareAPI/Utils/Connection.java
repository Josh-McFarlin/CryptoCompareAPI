package me.joshmcfarlin.CryptoCompareAPI.Utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Contains methods for creating JSON GET requests
 * @author joshuamcfarlin
 * @version 1
 */
public class Connection {
    /**
     * Gets JSON data from a provided URL
     * @param url The URL to get JSON information from
     * @param type The type of API call being made
     * @return Reader containing Json information
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Reader getJSON(URL url, CallTypes type) throws IOException, OutOfCallsException {
        if (RateLimiting.callable(type)) {
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.setDoOutput(true);
            request.setRequestMethod("GET");
            request.connect();

            InputStream in = new BufferedInputStream(request.getInputStream());
            return new InputStreamReader(in);
        } else {
            throw new OutOfCallsException(String.format("No more %s calls are left, please try later.", type));
        }
    }
}
