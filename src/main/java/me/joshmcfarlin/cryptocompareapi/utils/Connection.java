package me.joshmcfarlin.cryptocompareapi.utils;

import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Contains methods for creating JSON GET requests
 * @author Josh McFarlin
 */
public class Connection {
    /**
     * Gets JSON data from a provided URL without checking call availability
     * @param urlString The URL to get JSON information from
     * @return Reader containing Json information
     * @throws IOException when a connection cannot be made
     */
    public static Reader getJSON(String urlString) throws IOException {
        URL url = new URL(urlString);

        HttpURLConnection response = (HttpURLConnection) url.openConnection();
        response.setDoOutput(true);
        response.setRequestMethod("GET");
        response.connect();

        return new InputStreamReader(new BufferedInputStream(response.getInputStream()));
    }

    /**
     * Gets JSON data from a provided URL after checking call availability
     * @param urlString The URL to get JSON information from
     * @return Reader containing Json information
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Reader getJSONWithLimitVerif(String urlString) throws IOException, OutOfCallsException {
        if (RateLimiting.callable()) {
            return getJSON(urlString);
        } else {
            throw new OutOfCallsException(String.format("No more calls are left, please try later."));
        }
    }
}
