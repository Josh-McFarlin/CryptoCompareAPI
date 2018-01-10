package me.joshmcfarlin.CryptoCompareAPI;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.CryptoCompareAPI.Utils.CallTypes;
import me.joshmcfarlin.CryptoCompareAPI.Utils.Connection;
import me.joshmcfarlin.CryptoCompareAPI.Utils.OutOfCallsException;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about historic cryptocurrency prices
 * @author joshuamcfarlin
 * @version 1
 */
public class Historic {
    /**
     * Get market data for a symbol pair by minute up to to the provided limit
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @param limit The number of prices by minute to get
     * @return History A class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static History getMinute(String fromSym, String toSym, int limit) throws IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/histominute?fsym=%s&tsym=%s&limit=%d",
                fromSym.toUpperCase(), toSym.toUpperCase(), limit);
        Reader r = Connection.getJSON(new URL(formattedUrl), CallTypes.HISTO);
        return new Gson().fromJson(r, History.class);
    }

    /**
     * Gets market data for a symbol pair by hour up to to the provided limit
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @param limit The number of prices by hour to get
     * @return History A class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static History getHour(String fromSym, String toSym, int limit) throws IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/histohour?fsym=%s&tsym=%s&limit=%d",
                fromSym.toUpperCase(), toSym.toUpperCase(), limit);
        Reader r = Connection.getJSON(new URL(formattedUrl), CallTypes.HISTO);
        return new Gson().fromJson(r, History.class);
    }

    /**
     * Gets market data for a symbol pair by day up to to the provided limit
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @param limit The number of prices by day to get
     * @return History A class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static History getDay(String fromSym, String toSym, int limit) throws IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/histoday?fsym=%s&tsym=%s&limit=%d",
                fromSym.toUpperCase(), toSym.toUpperCase(), limit);
        Reader r = Connection.getJSON(new URL(formattedUrl), CallTypes.HISTO);
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
     */
    public static Map getPriceAtTime(int timestamp, String fromSym, String... toSym) throws IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/pricehistorical?fsym=%s&tsyms=%s&ts=%d",
                fromSym.toUpperCase(), String.join(",", toSym).toUpperCase(), timestamp);

        Reader r = Connection.getJSON(new URL(formattedUrl), CallTypes.HISTO);
        JsonObject jobject = new Gson().fromJson(r, JsonObject.class);
        return new Gson().fromJson(jobject.get(fromSym), Map.class);
    }

    public class History {
        /**
         * Indicates request success
         */
        @SerializedName("Response")
        public String response;
        /**
         * Indicates HTML request response type
         */
        @SerializedName("Type")
        public int type;
        /**
         * Historic data returned by the API
         */
        @SerializedName("Data")
        public List<Data> data;
        /**
         * Indicates the Unix starting time of the request
         */
        @SerializedName("TimeTo")
        public int timeTo;
        /**
         * Indicates the Unix ending time of the request
         */
        @SerializedName("TimeFrom")
        public int timeFrom;
        /**
         * Indicates first value in array
         */
        @SerializedName("FirstValueInArray")
        public boolean firstValueInArray;
        /**
         * Indicates if a currency conversion was used to get the data
         */
        @SerializedName("ConversionType")
        public ConversionType conversionType;
        /**
         * Indicates if the data was aggregated
         */
        @SerializedName("Aggregated")
        boolean aggregated;

        /**
         * Represents data returned by the API
         */
        public class Data {
            /**
             * Represents Unix time
             */
            public int time;
            /**
             * Symbol close on provided date
             */
            public double close;
            /**
             * Symbol high on provided date
             */
            public double high;
            /**
             * Symbol low on provided date
             */
            public double low;
            /**
             * Symbol open on provided date
             */
            public double open;
            /**
             * Volume from the symbol on provided date
             */
            @SerializedName("volumefrom")
            public double volumeFrom;
            /**
             * Volume to the symbol on provided date
             */
            @SerializedName("volumeto")
            public double volumeTo;
        }

        public class ConversionType {
            /**
             * The type of currency used to make the conversion
             */
            public String type;
            /**
             * The symbol of the currency used in the conversion
             */
            public String conversionSymbol;
        }
    }
}
