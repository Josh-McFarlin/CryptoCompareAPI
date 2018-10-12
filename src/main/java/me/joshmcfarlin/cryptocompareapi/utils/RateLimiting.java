package me.joshmcfarlin.cryptocompareapi.utils;

import com.google.gson.Gson;

import java.io.*;

/**
 * Contains methods for limiting API calls to provided limits
 * @author Josh McFarlin
 */
public class RateLimiting {
    /**
     * Gets the number of API calls used and available in the current interval
     * @param interval The time-frame to check API rates
     * @return Rates A class containing different API rates
     * @throws IOException When the connection fails
     * @throws InterruptedException When the connection is interrupted
     */
    public static Rates getInterval(IntervalTypes interval) throws InterruptedException, IOException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/stats/rate/%s/limit", interval.name().toLowerCase());
        Reader r = Connection.getJSON(formattedUrl);

        return new Gson().fromJson(r, Rates.class);
    }

    /**
     * Checks if the provided call type has calls left in the provided interval
     * @param type The API call type to be checked
     * @return boolean True if calls of the provided type are left
     * @throws IOException When the connection fails
     * @throws InterruptedException When the connection is interrupted
     */
    public static boolean checkInterval(CallTypes type, IntervalTypes interval) throws InterruptedException, IOException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/stats/rate/%s/limit", interval.name().toLowerCase());
        Reader r = Connection.getJSON(formattedUrl);

        Rates rates = new Gson().fromJson(r, Rates.class);
        return rates.CallsLeft.available(type);
    }

    /**
     * Checks if an API call is available
     * @param type The API call type to be checked
     * @return true if a call can be made, false if no more calls are available
     * @throws IOException When a connection fails
     */
    public static boolean callable(CallTypes type) throws InterruptedException, IOException {
        //return checkSecond(type) && checkMinute(type) && checkHour(type);
        return checkInterval(type, IntervalTypes.SECOND)
                && checkInterval(type, IntervalTypes.MINUTE)
                && checkInterval(type, IntervalTypes.HOUR);
    }

    /**
     * A class to represent API calls made and remaining
     */
    public class Rates {
        /**
         * Stores API calls made
         */
        private CallsMade CallsMade;

        /**
         * Stores API calls remaining
         */
        private CallsLeft CallsLeft;

        /**
         * {@link Rates#CallsMade}
         */
        public Rates.CallsMade getCallsMade() {
            return CallsMade;
        }

        /**
         * {@link Rates#CallsLeft}
         */
        public Rates.CallsLeft getCallsLeft() {
            return CallsLeft;
        }

        /**
         * A class to represent API calls made
         */
        public class CallsMade {
            /**
             * API calls made for historic endpoints
             */
            private int Histo;

            /**
             * API calls made for price endpoints
             */
            private int Price;

            /**
             * API calls made for news endpoints
             */
            private int News;

            @Override
            public String toString() {
                return String.format("API calls made: Histo: %d, Market: %d, News: %d", Histo, Price, News);
            }

            /**
             * {@link CallsMade#Histo}
             */
            public int getHisto() {
                return Histo;
            }

            /**
             * {@link CallsMade#Price}
             */
            public int getPrice() {
                return Price;
            }

            /**
             * {@link CallsMade#News}
             */
            public int getNews() {
                return News;
            }
        }

        /**
         * A class to represent API calls remaining
         */
        public class CallsLeft {
            /**
             * Remaining API calls for historic endpoints
             */
            private int Histo;

            /**
             * Remaining API calls for price endpoints
             */
            private int Price;

            /**
             * Remaining API calls for news endpoints
             */
            private int News;

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
                } else {
                    return type == CallTypes.OTHER;
                }
            }

            @Override
            public String toString() {
                return String.format("API calls left: Histo: %d, Market: %d, News: %d", Histo, Price, News);
            }

            /**
             * {@link CallsLeft#Histo}
             */
            public int getHisto() {
                return Histo;
            }

            /**
             * {@link CallsLeft#Price}
             */
            public int getPrice() {
                return Price;
            }

            /**
             * {@link CallsLeft#News}
             */
            public int getNews() {
                return News;
            }
        }
    }
}
