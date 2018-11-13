package me.joshmcfarlin.cryptocompareapi.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.CryptoCompareAPIConstant;

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
    public static TotalRate getRates() throws IOException {
        Reader r = Connection.getJSON(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL_STATS + "/rate/limit");

        return new Gson().fromJson(r, TotalRate.class);
    }

    /**
     * Checks if the provided call type has calls left in the provided intervals
     * @param intervals A number of IntervalTypes which will each be checked
     * @return boolean True if calls of the provided type are left for all of the provided intervals
     * @throws IOException When the connection fails
     */
    public static boolean checkInterval(IntervalTypes... intervals) throws IOException {
        for (IntervalTypes interval: intervals) {
            TotalRate rates = getRates();
            Long callsLeft = rates.getData().getCallsLeft().getInterval(interval);
            if (callsLeft <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if an API call is available
     * @return true if a call can be made, false if no more calls are available
     * @throws IOException When a connection fails
     */
    public static boolean callable() throws IOException {
        return checkInterval(IntervalTypes.HOUR, IntervalTypes.MINUTE, IntervalTypes.SECOND);
    }

    public class TotalRate{
        /**
         * The message returned by the CryptoCompare API
         */
        @SerializedName("Message")
        private String message;

        /**
         * The message returned by the CryptoCompare API
         */
        @SerializedName("Data")
        private RateData data;

        public String getMessage() {
            return message;
        }

        public RateData getData() {
            return data;
        }

        public class RateData {

            /**
             * Contains data about the number of api calls used in the time period
             */
            @SerializedName("calls_made")
            private RatePerInterval callsMade;

            /**
             * Contains data about the number of api calls remaining in the time period
             */
            @SerializedName("calls_left")
            private RatePerInterval callsLeft;

            public RatePerInterval getCallsMade() {
                return callsMade;
            }

            public RatePerInterval getCallsLeft() {
                return callsLeft;
            }

            public class RatePerInterval{
                /**
                 * The number of api calls used or left in the current month
                 */
                @SerializedName("month")
                private Long month;
                /**
                 * The number of api calls used or left in the current day
                 */
                @SerializedName("day")
                private Long day;
                /**
                 * The number of api calls used or left in the current hour
                 */
                @SerializedName("hour")
                private Long hour;

                /**
                 * The number of api calls used or left in the current minute
                 */
                @SerializedName("minute")
                private Long minute;

                /**
                 * The number of api calls used or left in the current second
                 */
                @SerializedName("second")
                private Long second;

                /**
                 * Gets a interval from a provided IntervalTypes object
                 * @param interval The provided IntervalTypes object
                 * @return Interval A class containing data about the number of api calls used in the time period
                 */
                public Long getInterval(IntervalTypes interval) {
                    if (interval == IntervalTypes.HOUR) {
                        return hour;
                    } else if (interval == IntervalTypes.MINUTE) {
                        return minute;
                    } else {
                        return second;
                    }
                }
            }


        }

    }
}
