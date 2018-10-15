package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about the cryptocurrency market on multiple exchanges
 * @author Josh McFarlin
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
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

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
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        Type type = new TypeToken<Map<String, Map<String, Double>>>() {}.getType();
        return new Gson().fromJson(r, type);
    }

    /**
     * Gets full information about multiple input symbols to multiple output symbols
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return MultiFull A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Map<String, Map<String, toSym>> getMultiFull(String[] fromSym, String[] toSym) throws
            IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/pricemultifull?fsyms=%s&tsyms=%s",
                String.join(",", fromSym).toUpperCase(), String.join(",", toSym).toUpperCase());
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<Map<String, Map<String, toSym>>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("RAW"), type);
    }

    /**
     * Gets the current day price average for a symbol pair
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return DayAverage A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static double getDayAverage(String fromSym, String toSym) throws
            IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/dayAvg?fsym=%s&tsym=%s",
                fromSym.toUpperCase(), toSym.toUpperCase());
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        return jsonObject.get(toSym).getAsDouble();
    }

    /**
     * Gets the day average price for a symbol pair on multiple exchanges
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @param exchanges The exchanges to consider in the price average
     * @return ExchangeAverage A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static ExchangeAverage getExchangeAverage(String fromSym, String toSym, String... exchanges) throws
            IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/generateAvg?fsym=%s&tsym=%s&e=%s",
                fromSym.toUpperCase(), toSym.toUpperCase(), String.join(",", exchanges).toUpperCase());
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        return new Gson().fromJson(jsonObject.getAsJsonObject("RAW"), ExchangeAverage.class);
    }

    /**
     * Gets the top cryptocurrencies trading to the input symbol by volume
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return TopVolumes A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static List<Coin> getTopVolumes(String toSym) throws IOException, OutOfCallsException {
        String formattedUrl = "https://min-api.cryptocompare.com/data/top/volumes?tsym=" + toSym.toUpperCase();
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<List<Coin>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("Data"), type);
    }

    /**
     * Gets the top trading pairs from an input symbol by volume
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @return TopPairs A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static List<Pair> getTopPairs(String fromSym) throws IOException, OutOfCallsException {
        String formattedUrl = "https://min-api.cryptocompare.com/data/top/pairs?fsym=" + fromSym.toUpperCase();
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<List<Pair>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("Data"), type);
    }

    /**
     * Represents the trading pair to-symbol
     */
    public class toSym {
        /**
         * Type
         */
        @SerializedName("TYPE")
        private String type;

        /**
         * Shortened names of markets used for data
         */
        @SerializedName("MARKET")
        private String market;

        /**
         * From symbol in trading pair
         */
        @SerializedName("FROMSYMBOL")
        private String fromSymbol;

        /**
         * To symbol in trading pair
         */
        @SerializedName("TOSYMBOL")
        private String toSymbol;

        /**
         * Number of flags used
         */
        @SerializedName("FLAGS")
        private int flags;

        /**
         * Coin price
         */
        @SerializedName("PRICE")
        private double price;

        /**
         * Unix time of last update
         */
        @SerializedName("LASTUPDATE")
        private int lastUpdate;

        /**
         * Last volume
         */
        @SerializedName("LASTVOLUME")
        private double lastVolume;

        /**
         * Last volume to
         */
        @SerializedName("LASTVOLUMETO")
        private double lastVolumeTo;

        /**
         * Last trade ID
         */
        @SerializedName("LASTTRADEID")
        private String lastTradeID;

        /**
         * Volume of day
         */
        @SerializedName("VOLUMEDAY")
        private double volumeDay;

        /**
         * Volume to of day
         */
        @SerializedName("VOLUMEDAYTO")
        private double volumeDayTo;

        /**
         * 24 hour volume
         */
        @SerializedName("VOLUME24HOUR")
        private double volume24Hour;

        /**
         * 24 hour volume to
         */
        @SerializedName("VOLUME24HOURTO")
        private double volume24HourTo;

        /**
         * Day open
         */
        @SerializedName("OPENDAY")
        private double openDay;

        /**
         * Day high
         */
        @SerializedName("HIGHDAY")
        private double highDay;

        /**
         * Day low
         */
        @SerializedName("LOWDAY")
        private double lowDay;

        /**
         * 24 hour open
         */
        @SerializedName("OPEN24HOUR")
        private double open24Hour;

        /**
         * 24 hour high
         */
        @SerializedName("HIGH24HOUR")
        private double high24Hour;

        /**
         * 24 hour low
         */
        @SerializedName("LOW24HOUR")
        private double low24Hour;

        /**
         * Last market
         */
        @SerializedName("LASTMARKET")
        private String lastMarket;

        /**
         * 24 hour change
         */
        @SerializedName("CHANGE24HOUR")
        private double change24Hour;

        /**
         * 24 hour percent change
         */
        @SerializedName("CHANGEPCT24HOUR")
        private double changePct24Hour;

        /**
         * Day change
         */
        @SerializedName("CHANGEDAY")
        private double changeDay;

        /**
         * Day percent change
         */
        @SerializedName("CHANGEPCTDAY")
        private double changePctDay;

        /**
         * Coin supply
         */
        @SerializedName("SUPPLY")
        private double supply;

        /**
         * Coin market capitalization
         */
        @SerializedName("MKTCAP")
        private double marketCap;

        /**
         * 24 hour total volume
         */
        @SerializedName("TOTALVOLUME24H")
        private double totalVolume24Hour;
        /**
         * 24 hour total volume to
         */
        @SerializedName("TOTALVOLUME24HTO")
        private double totalVolume24HourTo;

        @Override
        public String toString() {
            return String.format("%s-%s: %f", fromSymbol, toSymbol, volume24Hour);
        }

        /**
         * {@link toSym#type}
         */
        public String getType() {
            return type;
        }

        /**
         * {@link toSym#market}
         */
        public String getMarket() {
            return market;
        }

        /**
         * {@link toSym#fromSymbol}
         */
        public String getFromSymbol() {
            return fromSymbol;
        }

        /**
         * {@link toSym#toSymbol}
         */
        public String getToSymbol() {
            return toSymbol;
        }

        /**
         * {@link toSym#flags}
         */
        public int getFlags() {
            return flags;
        }

        /**
         * {@link toSym#price}
         */
        public double getPrice() {
            return price;
        }

        /**
         * {@link toSym#lastUpdate}
         */
        public int getLastUpdate() {
            return lastUpdate;
        }

        /**
         * {@link toSym#lastVolume}
         */
        public double getLastVolume() {
            return lastVolume;
        }

        /**
         * {@link toSym#lastVolumeTo}
         */
        public double getLastVolumeTo() {
            return lastVolumeTo;
        }

        /**
         * {@link toSym#lastTradeID}
         */
        public String getLastTradeID() {
            return lastTradeID;
        }

        /**
         * {@link toSym#volumeDay}
         */
        public double getVolumeDay() {
            return volumeDay;
        }

        /**
         * {@link toSym#volumeDayTo}
         */
        public double getVolumeDayTo() {
            return volumeDayTo;
        }

        /**
         * {@link toSym#volume24Hour}
         */
        public double getVolume24Hour() {
            return volume24Hour;
        }

        /**
         * {@link toSym#volume24HourTo}
         */
        public double getVolume24HourTo() {
            return volume24HourTo;
        }

        /**
         * {@link toSym#openDay}
         */
        public double getOpenDay() {
            return openDay;
        }

        /**
         * {@link toSym#highDay}
         */
        public double getHighDay() {
            return highDay;
        }

        /**
         * {@link toSym#lowDay}
         */
        public double getLowDay() {
            return lowDay;
        }

        /**
         * {@link toSym#open24Hour}
         */
        public double getOpen24Hour() {
            return open24Hour;
        }

        /**
         * {@link toSym#high24Hour}
         */
        public double getHigh24Hour() {
            return high24Hour;
        }

        /**
         * {@link toSym#low24Hour}
         */
        public double getLow24Hour() {
            return low24Hour;
        }

        /**
         * {@link toSym#lastMarket}
         */
        public String getLastMarket() {
            return lastMarket;
        }

        /**
         * {@link toSym#change24Hour}
         */
        public double getChange24Hour() {
            return change24Hour;
        }

        /**
         * {@link toSym#changePct24Hour}
         */
        public double getChangePct24Hour() {
            return changePct24Hour;
        }

        /**
         * {@link toSym#changeDay}
         */
        public double getChangeDay() {
            return changeDay;
        }

        /**
         * {@link toSym#changePctDay}
         */
        public double getChangePctDay() {
            return changePctDay;
        }

        /**
         * {@link toSym#supply}
         */
        public double getSupply() {
            return supply;
        }

        /**
         * {@link toSym#marketCap}
         */
        public double getMarketCap() {
            return marketCap;
        }

        /**
         * {@link toSym#totalVolume24Hour}
         */
        public double getTotalVolume24Hour() {
            return totalVolume24Hour;
        }

        /**
         * {@link toSym#totalVolume24HourTo}
         */
        public double getTotalVolume24HourTo() {
            return totalVolume24HourTo;
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
        private String market;

        /**
         * The from symbol of the pair
         */
        @SerializedName("FROMSYMBOL")
        private String fromSymbol;

        /**
         * The to symbol of the pair
         */
        @SerializedName("TOSYMBOL")
        private String toSymbol;

        /**
         * The number of flags used
         */
        @SerializedName("FLAGS")
        private int flags;

        /**
         * The price of the from symbol
         */
        @SerializedName("PRICE")
        private double price;

        /**
         * Unix time of the last update
         */
        @SerializedName("LASTUPDATE")
        private int lastUpdate;

        /**
         * Last volume
         */
        @SerializedName("LASTVOLUME")
        private double lastVolume;

        /**
         * Last volume to
         */
        @SerializedName("LASTVOLUMETO")
        private double lastVolumeTo;

        /**
         * Last trade id
         */
        @SerializedName("LASTTRADEID")
        private String lastTradeID;

        /**
         * 24 hour volume
         */
        @SerializedName("VOLUME24HOUR")
        private double volume24Hour;

        /**
         * 24 hour volume to
         */
        @SerializedName("VOLUME24HOURTO")
        private double volume24HourTo;

        /**
         * 24 hour open
         */
        @SerializedName("OPEN24HOUR")
        private double open24Hour;

        /**
         * 24 hour high
         */
        @SerializedName("HIGH24HOUR")
        private double high24Hour;

        /**
         * 24 hour low
         */
        @SerializedName("LOW24HOUR")
        private double low24Hour;

        /**
         * Last market
         */
        @SerializedName("LASTMARKET")
        private String lastMarket;

        /**
         * 24 hour change
         */
        @SerializedName("CHANGE24HOUR")
        private double change24Hour;

        /**
         * 24 hour percent change
         */
        @SerializedName("CHANGEPCT24HOUR")
        private double changePCT24Hour;

        /**
         * Day change
         */
        @SerializedName("CHANGEDAY")
        private double changeDay;

        /**
         * Day percent change
         */
        @SerializedName("CHANGEPCTDAY")
        private double changePCTDay;

        /**
         * {@link ExchangeAverage#market}
         */
        public String getMarket() {
            return market;
        }

        /**
         * {@link ExchangeAverage#fromSymbol}
         */
        public String getFromSymbol() {
            return fromSymbol;
        }

        /**
         * {@link ExchangeAverage#toSymbol}
         */
        public String getToSymbol() {
            return toSymbol;
        }

        /**
         * {@link ExchangeAverage#flags}
         */
        public int getFlags() {
            return flags;
        }

        /**
         * {@link ExchangeAverage#price}
         */
        public double getPrice() {
            return price;
        }

        /**
         * {@link ExchangeAverage#lastUpdate}
         */
        public int getLastUpdate() {
            return lastUpdate;
        }

        /**
         * {@link ExchangeAverage#lastVolume}
         */
        public double getLastVolume() {
            return lastVolume;
        }

        /**
         * {@link ExchangeAverage#lastVolumeTo}
         */
        public double getLastVolumeTo() {
            return lastVolumeTo;
        }

        /**
         * {@link ExchangeAverage#lastTradeID}
         */
        public String getLastTradeID() {
            return lastTradeID;
        }

        /**
         * {@link ExchangeAverage#volume24Hour}
         */
        public double getVolume24Hour() {
            return volume24Hour;
        }

        /**
         * {@link ExchangeAverage#volume24HourTo}
         */
        public double getVolume24HourTo() {
            return volume24HourTo;
        }

        /**
         * {@link ExchangeAverage#open24Hour}
         */
        public double getOpen24Hour() {
            return open24Hour;
        }

        /**
         * {@link ExchangeAverage#high24Hour}
         */
        public double getHigh24Hour() {
            return high24Hour;
        }

        /**
         * {@link ExchangeAverage#low24Hour}
         */
        public double getLow24Hour() {
            return low24Hour;
        }

        /**
         * {@link ExchangeAverage#lastMarket}
         */
        public String getLastMarket() {
            return lastMarket;
        }

        /**
         * {@link ExchangeAverage#change24Hour}
         */
        public double getChange24Hour() {
            return change24Hour;
        }

        /**
         * {@link ExchangeAverage#changePCT24Hour}
         */
        public double getChangePCT24Hour() {
            return changePCT24Hour;
        }

        /**
         * {@link ExchangeAverage#changeDay}
         */
        public double getChangeDay() {
            return changeDay;
        }

        /**
         * {@link ExchangeAverage#changePCTDay}
         */
        public double getChangePCTDay() {
            return changePCTDay;
        }
    }

    /**
     * Represents a cryptocurrency
     */
    public class Coin {
        /**
         * The symbol of the coin
         */
        @SerializedName("SYMBOL")
        private String symbol;

        /**
         * Total supply of the coin
         */
        @SerializedName("SUPPLY")
        private double supply;

        /**
         * The full name of the coin
         */
        @SerializedName("FULLNAME")
        private String fullName;

        /**
         * The name of the coin
         */
        @SerializedName("NAME")
        private String name;

        /**
         * The ID of the coin on CryptoCompare's website
         */
        @SerializedName("ID")
        private int id;

        /**
         * The 24 hour volume to
         */
        @SerializedName("VOLUME24HOURTO")
        private double volume24HourTo;

        @Override
        public String toString() {
            return String.format("%s - %f", fullName, volume24HourTo);
        }

        /**
         * {@link Coin#symbol}
         */
        public String getSymbol() {
            return symbol;
        }

        /**
         * {@link Coin#supply}
         */
        public double getSupply() {
            return supply;
        }

        /**
         * {@link Coin#fullName}
         */
        public String getFullName() {
            return fullName;
        }

        /**
         * {@link Coin#name}
         */
        public String getName() {
            return name;
        }

        /**
         * {@link Coin#id}
         */
        public int getId() {
            return id;
        }

        /**
         * {@link Coin#volume24HourTo}
         */
        public double getVolume24HourTo() {
            return volume24HourTo;
        }
    }

    /**
     * Represents a trading pair
     */
    public class Pair {
        /**
         * Exchange the pair is being traded on
         */
        private String exchange;

        /**
         * The from symbol in the pair
         */
        private String fromSymbol;

        /**
         * The to symbol in the pair
         */
        private String toSymbol;

        /**
         * The 24 hour volume
         */
        private double volume24h;

        /**
         * The 24 hour volume to
         */
        private double volume24hTo;

        @Override
        public String toString() {
            return String.format("%s-%s", fromSymbol, toSymbol);
        }

        /**
         * {@link Pair#exchange}
         */
        public String getExchange() {
            return exchange;
        }

        /**
         * {@link Pair#fromSymbol}
         */
        public String getFromSymbol() {
            return fromSymbol;
        }

        /**
         * {@link Pair#toSymbol}
         */
        public String getToSymbol() {
            return toSymbol;
        }

        /**
         * {@link Pair#volume24h}
         */
        public double getVolume24h() {
            return volume24h;
        }

        /**
         * {@link Pair#volume24hTo}
         */
        public double getVolume24hTo() {
            return volume24hTo;
        }
    }
}
