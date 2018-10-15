package me.joshmcfarlin.cryptocompareapi.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.*;

/**
 * Contains methods for limiting API calls to provided limits
 * @author Josh McFarlin
 */
public class RateLimiting {
    /**
     * Gets the number of API calls used and available in the current interval
     * @return Rates A class containing different API rates
     * @throws IOException When the connection fails
     */
    public static Rates getRates() throws IOException {
        Reader r = Connection.getJSON("https://min-api.cryptocompare.com/stats/rate/limit");

        return new Gson().fromJson(r, Rates.class);
    }

    /**
     * Checks if the provided call type has calls left in the provided intervals
     * @param type The API call type to be checked
     * @param intervals A number of IntervalTypes which will each be checked
     * @return boolean True if calls of the provided type are left for all of the provided intervals
     * @throws IOException When the connection fails
     */
    public static boolean checkInterval(CallTypes type, IntervalTypes ...intervals) throws IOException {
        for (IntervalTypes interval: intervals) {
            Rates rates = getRates();
            Rates.Interval.Usage callsLeft = rates.getInterval(interval).callsLeft;

            if (type == CallTypes.HISTO && callsLeft.histo <= 0) {
                return false;
            } else if (type == CallTypes.PRICE && callsLeft.price <= 0) {
                return false;
            } else if (type == CallTypes.NEWS && callsLeft.news <= 0) {
                return false;
            } else if (type == CallTypes.STRICT && callsLeft.strict <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if an API call is available
     * @param type The API call type to be checked
     * @return true if a call can be made, false if no more calls are available
     * @throws IOException When a connection fails
     */
    public static boolean callable(CallTypes type) throws IOException {
        return checkInterval(type, IntervalTypes.HOUR, IntervalTypes.MINUTE, IntervalTypes.SECOND);
    }

    public class Rates {
        /**
         * The message returned by the CryptoCompare API
         */
        @SerializedName("Message")
        private String message;

        /**
         * The number of api calls used and left in the current hour
         */
        @SerializedName("Hour")
        private Interval hour;

        /**
         * The number of api calls used and left in the current minute
         */
        @SerializedName("Minute")
        private Interval minute;

        /**
         * The number of api calls used and left in the current second
         */
        @SerializedName("Second")
        private Interval second;

        /**
         * {@link Rates#message}
         */
        public String getMessage() {
            return message;
        }

        /**
         * {@link Rates#hour}
         */
        public Interval getHour() {
            return hour;
        }

        /**
         * {@link Rates#minute}
         */
        public Interval getMinute() {
            return minute;
        }

        /**
         * {@link Rates#second}
         */
        public Interval getSecond() {
            return second;
        }

        /**
         * Gets a interval from a provided IntervalTypes object
         * @param interval The provided IntervalTypes object
         * @return Interval A class containing data about the number of api calls used in the time period
         */
        public Interval getInterval(IntervalTypes interval) {
            if (interval == IntervalTypes.HOUR) {
                return hour;
            } else if (interval == IntervalTypes.MINUTE) {
                return minute;
            } else {
                return second;
            }
        }

        public class Interval {
            /**
             * Contains data about the number of api calls used in the time period
             */
            @SerializedName("CallsMade")
            private Usage callsMade;

            /**
             * Contains data about the number of api calls remaining in the time period
             */
            @SerializedName("CallsLeft")
            private Usage callsLeft;

            /**
             * {@link Interval#callsMade}
             */
            public Usage getCallsMade() {
                return callsMade;
            }

            /**
             * {@link Interval#callsLeft}
             */
            public Usage getCallsLeft() {
                return callsLeft;
            }

            /**
             * Represents the number of api calls for a time period
             */
            public class Usage {
                /**
                 * The number of Histo calls
                 */
                @SerializedName("Histo")
                private Integer histo;

                /**
                 * The number of Price calls
                 */
                @SerializedName("Price")
                private Integer price;

                /**
                 * The number of News calls
                 */
                @SerializedName("News")
                private Integer news;

                /**
                 * The number of Strict calls
                 */
                @SerializedName("Strict")
                private Integer strict;

                @Override
                public String toString() {
                    return String.format("API calls: Histo: %d, Market: %d, News: %d, Strict: %d", histo, price, news, strict);
                }

                /**
                 * {@link Usage#histo}
                 */
                public Integer getHisto() {
                    return histo;
                }

                /**
                 * {@link Usage#price}
                 */
                public Integer getPrice() {
                    return price;
                }

                /**
                 * {@link Usage#news}
                 */
                public Integer getNews() {
                    return news;
                }

                /**
                 * {@link Usage#strict}
                 */
                public Integer getStrict() {
                    return strict;
                }
            }
        }
    }
}
