package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.Utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.Utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Utils.OutOfCallsException;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about the cryptocurrency market on multiple exchanges
 * @author joshuamcfarlin
 * @version 1
 */
public class Market {
    /**
     * Gets price of an input symbol in multiple output symbols
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return Map containing price for each to symbol
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Map<String, Double> getPrice(String fromSym, String... toSym) throws
            IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/price?fsym=%s&tsyms=%s",
                fromSym.toUpperCase(), String.join(",", toSym).toUpperCase());
        Reader r = Connection.getJSON(new URL(formattedUrl), CallTypes.PRICE);
        Type type = new TypeToken<Map<String, Double>>() {}.getType();
        return new Gson().fromJson(r, type);
    }

    /**
     * Gets price of multiple input symbols to multiple output symbols
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return Map containing price for each from and to symbol
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Map<String, Map<String, Double>> getMultiPrice(String[] fromSym, String[] toSym) throws
            IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/pricemulti?fsyms=%s&tsyms=%s",
                String.join(",", fromSym).toUpperCase(), String.join(",", toSym).toUpperCase());
        Reader r = Connection.getJSON(new URL(formattedUrl), CallTypes.PRICE);
        Type type = new TypeToken<Map<String, Map<String, Double>>>() {}.getType();
        return new Gson().fromJson(r, type);
    }

    /**
     * Gets full information about multiple input symbols to multiple output symbols
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return MultiFull A class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Map<String, Map<String, toSym>> getMultiFull(String[] fromSym, String[] toSym) throws
            IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/pricemultifull?fsyms=%s&tsyms=%s",
                String.join(",", fromSym).toUpperCase(), String.join(",", toSym).toUpperCase());
        Reader r = Connection.getJSON(new URL(formattedUrl), CallTypes.PRICE);
        JsonObject jobject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<Map<String, Map<String, toSym>>>() {}.getType();
        return new Gson().fromJson(jobject.get("RAW"), type);
    }

    /**
     * Gets the current day price average for a symbol pair
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return DayAverage A class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static double getDayAverage(String fromSym, String toSym) throws
            IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/dayAvg?fsym=%s&tsym=%s",
                fromSym.toUpperCase(), toSym.toUpperCase());
        Reader r = Connection.getJSON(new URL(formattedUrl), CallTypes.PRICE);

        JsonObject jobj = new Gson().fromJson(r, JsonObject.class);
        return jobj.get(toSym).getAsDouble();
    }

    /**
     * Gets the day average price for a symbol pair on multiple exchanges
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @param exchanges The exchanges to consider in the price average
     * @return ExchangeAverage A class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static ExchangeAverage getExchangeAverage(String fromSym, String toSym, String... exchanges) throws
            IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/generateAvg?fsym=%s&tsym=%s&e=%s",
                fromSym.toUpperCase(), toSym.toUpperCase(), String.join(",", exchanges).toUpperCase());
        Reader r = Connection.getJSON(new URL(formattedUrl), CallTypes.PRICE);
        JsonObject jobject = new Gson().fromJson(r, JsonObject.class);
        return new Gson().fromJson(jobject.getAsJsonObject("RAW"), ExchangeAverage.class);
    }

    /**
     * Gets the top cryptocurrencies trading to the input symbol by volume
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return TopVolumes A class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static List<Coin> getTopVolumes(String toSym) throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON(new URL("https://min-api.cryptocompare.com/data/top/volumes?tsym="
                + toSym.toUpperCase()), CallTypes.PRICE);
        JsonObject jobject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<List<Coin>>() {}.getType();
        return new Gson().fromJson(jobject.get("Data"), type);
    }

    /**
     * Gets the top trading pairs from an input symbol by volume
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @return TopPairs A class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static List<Pair> getTopPairs(String fromSym) throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON(new URL("https://min-api.cryptocompare.com/data/top/pairs?fsym="
                + fromSym.toUpperCase()), CallTypes.PRICE);
        JsonObject jobject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<List<Pair>>() {}.getType();
        return new Gson().fromJson(jobject.get("Data"), type);
    }

    /**
     * Represents the trading pair to-symvol
     */
    public class toSym {
        /**
         * Type
         */
        @SerializedName("TYPE")
        public String type;
        /**
         * Shortened names of markets used for data
         */
        @SerializedName("MARKET")
        public String market;
        /**
         * From symbol in trading pair
         */
        @SerializedName("FROMSYMBOL")
        public String fromSymbol;
        /**
         * To symbol in trading pair
         */
        @SerializedName("TOSYMBOL")
        public String toSymbol;
        /**
         * Number of flags used
         */
        @SerializedName("FLAGS")
        public int flags;
        /**
         * Coin price
         */
        @SerializedName("PRICE")
        public double price;
        /**
         * Unix time of last update
         */
        @SerializedName("LASTUPDATE")
        public int lastUpdate;
        /**
         * Last volume
         */
        @SerializedName("LASTVOLUME")
        public double lastVolume;
        /**
         * Last volume to
         */
        @SerializedName("LASTVOLUMETO")
        public double lastVolumeTo;
        /**
         * Last trade ID
         */
        @SerializedName("LASTTRADEID")
        public String lastTradeID;
        /**
         * Volume of day
         */
        @SerializedName("VOLUMEDAY")
        public double volumeDay;
        /**
         * Volume to of day
         */
        @SerializedName("VOLUMEDAYTO")
        public double volumeDayTo;
        /**
         * 24 hour volume
         */
        @SerializedName("VOLUME24HOUR")
        public double volume24Hour;
        /**
         * 24 hour volume to
         */
        @SerializedName("VOLUME24HOURTO")
        public double volume24HourTo;
        /**
         * Day open
         */
        @SerializedName("OPENDAY")
        public double openDay;
        /**
         * Day high
         */
        @SerializedName("HIGHDAY")
        public double highDay;
        /**
         * Day low
         */
        @SerializedName("LOWDAY")
        public double lowDay;
        /**
         * 24 hour open
         */
        @SerializedName("OPEN24HOUR")
        public double open24Hour;
        /**
         * 24 hour high
         */
        @SerializedName("HIGH24HOUR")
        public double high24Hour;
        /**
         * 24 hour low
         */
        @SerializedName("LOW24HOUR")
        public double low24Hour;
        /**
         * Last market
         */
        @SerializedName("LASTMARKET")
        public String lastMarket;
        /**
         * 24 hour change
         */
        @SerializedName("CHANGE24HOUR")
        public double change24Hour;
        /**
         * 24 hour percent change
         */
        @SerializedName("CHANGEPCT24HOUR")
        public double changePct24Hour;
        /**
         * Day change
         */
        @SerializedName("CHANGEDAY")
        public double changeDay;
        /**
         * Day percent change
         */
        @SerializedName("CHANGEPCTDAY")
        public double changePctDay;
        /**
         * Coin supply
         */
        @SerializedName("SUPPLY")
        public double supply;
        /**
         * Coin market capitalization
         */
        @SerializedName("MKTCAP")
        public double marketCap;
        /**
         * 24 hour total volume
         */
        @SerializedName("TOTALVOLUME24H")
        public double totalVolume24Hour;
        /**
         * 24 hour total volume to
         */
        @SerializedName("TOTALVOLUME24HTO")
        public double totalVolume24HourTo;

        @Override
        public String toString() {
            return String.format("%s-%s: %f", fromSymbol, toSymbol, volume24Hour);
        }
    }

    /**
     * Represents exchange average
     */
    public class ExchangeAverage {
        /**
         * Markets used to get data
         */
        @SerializedName("MARKET")
        public String market;
        /**
         * The from symbol of the pair
         */
        @SerializedName("FROMSYMBOL")
        public String fromSymbol;
        /**
         * The to symbol of the pair
         */
        @SerializedName("TOSYMBOL")
        public String toSymbol;
        /**
         * The number of flags used
         */
        @SerializedName("FLAGS")
        public int flags;
        /**
         * The price of the from symbol
         */
        @SerializedName("PRICE")
        public double price;
        /**
         * Unix time of the last update
         */
        @SerializedName("LASTUPDATE")
        public int lastUpdate;
        /**
         * Last volume
         */
        @SerializedName("LASTVOLUME")
        public double lastVolume;
        /**
         * Last volume to
         */
        @SerializedName("LASTVOLUMETO")
        public double lastVolumeTo;
        /**
         * Last trade id
         */
        @SerializedName("LASTTRADEID")
        public String lastTradeID;
        /**
         * 24 hour volume
         */
        @SerializedName("VOLUME24HOUR")
        public double volume24Hour;
        /**
         * 24 hour volume to
         */
        @SerializedName("VOLUME24HOURTO")
        public double volume24HourTo;
        /**
         * 24 hour open
         */
        @SerializedName("OPEN24HOUR")
        public double open24Hour;
        /**
         * 24 hour high
         */
        @SerializedName("HIGH24HOUR")
        public double high24Hour;
        /**
         * 24 hour low
         */
        @SerializedName("LOW24HOUR")
        public double low24Hour;
        /**
         * Last market
         */
        @SerializedName("LASTMARKET")
        public String lastMarket;
        /**
         * 24 hour change
         */
        @SerializedName("CHANGE24HOUR")
        public double change24Hour;
        /**
         * 24 hour percent change
         */
        @SerializedName("CHANGEPCT24HOUR")
        public double changePCT24Hour;
        /**
         * Day change
         */
        @SerializedName("CHANGEDAY")
        public double changeDay;
        /**
         * Day percent change
         */
        @SerializedName("CHANGEPCTDAY")
        public double changePCTDay;
    }

    /**
     * Represents a cryptocurrency
     */
    public class Coin {
        /**
         * The symbol of the coin
         */
        @SerializedName("SYMBOL")
        public String symbol;
        /**
         * Total supply of the coin
         */
        @SerializedName("SUPPLY")
        public double supply;
        /**
         * The full name of the coin
         */
        @SerializedName("FULLNAME")
        public String fullName;
        /**
         * The name of the coin
         */
        @SerializedName("NAME")
        public String name;
        /**
         * The ID of the coin on CryptoCompare's website
         */
        @SerializedName("ID")
        public int id;
        /**
         * The 24 hour volume to
         */
        @SerializedName("VOLUME24HOURTO")
        public double volume24HourTo;

        @Override
        public String toString() {
            return String.format("%s - %f", fullName, volume24HourTo);
        }
    }

    /**
     * Represents a trading pair
     */
    public class Pair {
        /**
         * Exchange the pair is being traded on
         */
        public String exchange;
        /**
         * The from symbol in the pair
         */
        public String fromSymbol;
        /**
         * The to symbol in the pair
         */
        public String toSymbol;
        /**
         * The 24 hour volume
         */
        public double volume24h;
        /**
         * The 24 hour volume to
         */
        public double volume24hTo;

        @Override
        public String toString() {
            return String.format("%s-%s", fromSymbol, toSymbol);
        }
    }


}
