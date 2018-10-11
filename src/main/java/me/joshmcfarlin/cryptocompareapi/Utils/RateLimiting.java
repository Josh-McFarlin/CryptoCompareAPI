package me.joshmcfarlin.cryptocompareapi.Utils;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Contains methods for limiting API calls to provided limits
 * @author joshuamcfarlin
 * @version 1
 */
public class RateLimiting {
    /**
     * Gets number of API calls used and available for the next second
     * @return Rates A class containing different API rates
     * @throws IOException When a connection fails
     */
    public static Rates checkSecond() throws IOException {
        URL url = new URL("https://min-api.cryptocompare.com/stats/rate/second/limit");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setDoOutput(true);
        request.setRequestMethod("GET");
        request.connect();

        InputStream in = new BufferedInputStream(request.getInputStream());
        Reader r = new InputStreamReader(in);

        return new Gson().fromJson(r, Rates.class);
    }

    /**
     * Gets number of API calls used and available for the next minute
     * @return Rates A class containing different API rates
     * @throws IOException When a connection fails
     */
    public static Rates checkMinute() throws IOException {
        URL url = new URL("https://min-api.cryptocompare.com/stats/rate/minute/limit");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setDoOutput(true);
        request.setRequestMethod("GET");
        request.connect();

        InputStream in = new BufferedInputStream(request.getInputStream());
        Reader r = new InputStreamReader(in);

        return new Gson().fromJson(r, Rates.class);
    }

    /**
     * Gets number of API calls used and available for the next hour
     * @return Rates A class containing different API rates
     * @throws IOException When a connection fails
     */
    public static Rates checkHour() throws IOException {
        URL url = new URL("https://min-api.cryptocompare.com/stats/rate/hour/limit");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setDoOutput(true);
        request.setRequestMethod("GET");
        request.connect();

        InputStream in = new BufferedInputStream(request.getInputStream());
        Reader r = new InputStreamReader(in);
        return new Gson().fromJson(r, Rates.class);
    }

    /**
     * Checks if an API call is available
     * @param type The API call type to be checked
     * @return true if a call can be made, false if no more calls are available
     * @throws IOException When a connection fails
     */
    public static boolean callable(CallTypes type) throws IOException {
        Rates second = checkSecond();
        Rates minute = checkMinute();
        Rates hour = checkHour();

        return second.CallsLeft.available(type) && minute.CallsLeft.available(type) && hour.CallsLeft.available(type);
    }

    /**
     * A class to represent API calls made and remaining
     */
    public class Rates {
        /**
         * Stores API calls made
         */
        public CallsMade CallsMade;
        /**
         * Stores API calls remaining
         */
        public CallsLeft CallsLeft;

        /**
         * A class to represent API calls made
         */
        public class CallsMade {
            /**
             * API calls made for historic endpoints
             */
            public int Histo;
            /**
             * API calls made for price endpoints
             */
            public int Price;
            /**
             * API calls made for news endpoints
             */
            public int News;

            @Override
            public String toString() {
                return String.format("Histo: %d, Market: %d, News: %d", Histo, Price, News);
            }
        }

        /**
         * A class to represent API calls remaining
         */
        public class CallsLeft {
            /**
             * Remaining API calls for historic endpoints
             */
            public int Histo;
            /**
             * Remaining API calls for price endpoints
             */
            public int Price;
            /**
             * Remaining API calls for news endpoints
             */
            public int News;

            /**
             * Checks if an API call can be made for the provided type
             * @param type The type of API call being made
             * @return true if a call can be made, false if no more calls are available
             */
            public boolean available(CallTypes type) {
                if (type == CallTypes.HISTO) {
                    return Histo > 0;
                } else if (type == CallTypes.PRICE) {
                    return Price > 0;
                } else if (type == CallTypes.NEWS) {
                    return News > 0;
                } else if (type == CallTypes.OTHER) {
                    return true;
                }
                return false;
            }

            @Override
            public String toString() {
                return String.format("Histo: %d, Market: %d, News: %d", Histo, Price, News);
            }
        }
    }
}
