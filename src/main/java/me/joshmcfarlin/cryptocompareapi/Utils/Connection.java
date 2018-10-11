package me.joshmcfarlin.cryptocompareapi.Utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
    public static Reader getJSON(URL url, CallTypes type) throws IOException, OutOfCallsException, InterruptedException {
        if (RateLimiting.callable(type)) {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url.toString())).GET()
                    .timeout(Duration.ofSeconds(10))
                    .build();

            HttpResponse response = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
            return new InputStreamReader((InputStream) response.body());
        } else {
            throw new OutOfCallsException(String.format("No more %s calls are left, please try later.", type));
        }
    }
}
