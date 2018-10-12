package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about historic cryptocurrency prices
 * @author Josh McFarlin
 */
public class Historic {
    /**
     * Get market data for a symbol pair by minute up to to the provided limit
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @param limit The number of prices by minute to get
     * @return History A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     * @throws InterruptedException When the connection is interrupted
     */
    public static History getMinute(String fromSym, String toSym, int limit) throws IOException, OutOfCallsException, InterruptedException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/histominute?fsym=%s&tsym=%s&limit=%d",
                fromSym.toUpperCase(), toSym.toUpperCase(), limit);
        Reader r = Connection.getJSON(formattedUrl, CallTypes.HISTO);

        return new Gson().fromJson(r, History.class);
    }

    /**
     * Gets market data for a symbol pair by hour up to to the provided limit
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @param limit The number of prices by hour to get
     * @return History A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     * @throws InterruptedException When the connection is interrupted
     */
    public static History getHour(String fromSym, String toSym, int limit) throws IOException, OutOfCallsException, InterruptedException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/histohour?fsym=%s&tsym=%s&limit=%d",
                fromSym.toUpperCase(), toSym.toUpperCase(), limit);
        Reader r = Connection.getJSON(formattedUrl, CallTypes.HISTO);

        return new Gson().fromJson(r, History.class);
    }

    /**
     * Gets market data for a symbol pair by day up to to the provided limit
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @param limit The number of prices by day to get
     * @return History A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     * @throws InterruptedException When the connection is interrupted
     */
    public static History getDay(String fromSym, String toSym, int limit) throws IOException, OutOfCallsException, InterruptedException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/histoday?fsym=%s&tsym=%s&limit=%d",
                fromSym.toUpperCase(), toSym.toUpperCase(), limit);
        Reader r = Connection.getJSON(formattedUrl, CallTypes.HISTO);

        return new Gson().fromJson(r, History.class);
    }

    /**
     * Gets the price of a symbol pair at an input Unix time
     * @param timestamp Unix time to find price at
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return Map containing information about price at input time
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     * @throws InterruptedException When the connection is interrupted
     */
    public static Map getPriceAtTime(int timestamp, String fromSym, String... toSym) throws IOException, OutOfCallsException, InterruptedException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/pricehistorical?fsym=%s&tsyms=%s&ts=%d",
                fromSym.toUpperCase(), String.join(",", toSym).toUpperCase(), timestamp);

        Reader r = Connection.getJSON(formattedUrl, CallTypes.HISTO);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        return new Gson().fromJson(jsonObject.get(fromSym), Map.class);
    }

    /**
     * Represents historic data provided by the CryptoCompare API
     */
    public class History {
        /**
         * Indicates request success
         */
        @SerializedName("Response")
        private String response;

        /**
         * Indicates HTML request response type
         */
        @SerializedName("Type")
        private int type;

        /**
         * Historic data returned by the API
         */
        @SerializedName("Data")
        private List<Data> data;

        /**
         * Indicates the Unix starting time of the request
         */
        @SerializedName("TimeTo")
        private int timeTo;

        /**
         * Indicates the Unix ending time of the request
         */
        @SerializedName("TimeFrom")
        private int timeFrom;

        /**
         * Indicates first value in array
         */
        @SerializedName("FirstValueInArray")
        private boolean firstValueInArray;

        /**
         * Indicates if a currency conversion was used to get the data
         */
        @SerializedName("ConversionType")
        private ConversionType conversionType;

        /**
         * Indicates if the data was aggregated
         */
        @SerializedName("Aggregated")
        private boolean aggregated;

        /**
         * {@link History#response}
         */
        public String getResponse() {
            return response;
        }

        /**
         * {@link History#type}
         */
        public int getType() {
            return type;
        }

        /**
         * {@link History#data}
         */
        public List<Data> getData() {
            return data;
        }

        /**
         * {@link History#timeTo}
         */
        public int getTimeTo() {
            return timeTo;
        }

        /**
         * {@link History#timeFrom}
         */
        public int getTimeFrom() {
            return timeFrom;
        }

        /**
         * {@link History#firstValueInArray}
         */
        public boolean isFirstValueInArray() {
            return firstValueInArray;
        }

        /**
         * {@link History#conversionType}
         */
        public ConversionType getConversionType() {
            return conversionType;
        }

        /**
         * {@link History#aggregated}
         */
        public boolean isAggregated() {
            return aggregated;
        }

        /**
         * Represents data returned by the API
         */
        public class Data {
            /**
             * Represents Unix time
             */
            private int time;

            /**
             * Symbol close on provided date
             */
            private double close;

            /**
             * Symbol high on provided date
             */
            private double high;

            /**
             * Symbol low on provided date
             */
            private double low;

            /**
             * Symbol open on provided date
             */
            private double open;

            /**
             * Volume from the symbol on provided date
             */
            @SerializedName("volumefrom")
            private double volumeFrom;

            /**
             * Volume to the symbol on provided date
             */
            @SerializedName("volumeto")
            private double volumeTo;

            /**
             * {@link Data#time}
             */
            public int getTime() {
                return time;
            }

            /**
             * {@link Data#close}
             */
            public double getClose() {
                return close;
            }

            /**
             * {@link Data#high}
             */
            public double getHigh() {
                return high;
            }

            /**
             * {@link Data#low}
             */
            public double getLow() {
                return low;
            }

            /**
             * {@link Data#open}
             */
            public double getOpen() {
                return open;
            }

            /**
             * {@link Data#volumeFrom}
             */
            public double getVolumeFrom() {
                return volumeFrom;
            }

            /**
             * {@link Data#volumeTo}
             */
            public double getVolumeTo() {
                return volumeTo;
            }
        }

        /**
         * Represents a conversion type between cryptocurrencies or currencies
         */
        public class ConversionType {
            /**
             * The type of currency used to make the conversion
             */
            private String type;

            /**
             * The symbol of the currency used in the conversion
             */
            private String conversionSymbol;

            /**
             * {@link ConversionType#type}
             */
            public String getType() {
                return type;
            }

            /**
             * {@link ConversionType#conversionSymbol}
             */
            public String getConversionSymbol() {
                return conversionSymbol;
            }
        }
    }
}
