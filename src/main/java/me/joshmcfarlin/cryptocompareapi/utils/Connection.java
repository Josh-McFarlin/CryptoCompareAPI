package me.joshmcfarlin.cryptocompareapi.utils;

import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.net.URI;
import java.time.Duration;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
     * @throws InterruptedException when the connection is interrupted
     */
    static Reader getJSON(String urlString) throws IOException, InterruptedException {
        URI url = URI.create(urlString);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(url).GET()
                .timeout(Duration.ofSeconds(10))
                .build();

        HttpResponse response = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
        return new InputStreamReader((InputStream) response.body());
    }

    /**
     * Gets JSON data from a provided URL after checking call availability
     * @param urlString The URL to get JSON information from
     * @param type The type of API call being made
     * @return Reader containing Json information
     * @throws IOException when a connection cannot be made
     * @throws InterruptedException when the connection is interrupted
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Reader getJSON(String urlString, CallTypes type) throws IOException, OutOfCallsException, InterruptedException {
        URI url = URI.create(urlString);

        if (RateLimiting.callable(type)) {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(url).GET()
                    .timeout(Duration.ofSeconds(10))
                    .build();

            HttpResponse response = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
            return new InputStreamReader((InputStream) response.body());
        } else {
            throw new OutOfCallsException(String.format("No more %s calls are left, please try later.", type));
        }
    }
}
