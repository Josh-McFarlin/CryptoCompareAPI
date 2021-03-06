package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.Exceptions.InvalidParameterException;
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
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSyms Comma separated cryptocurrency symbols list to convert into [Max character length: 500]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return Map containing price for each to-symbol
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public Map<String, Double> getPrice(String fSym, String tSyms, Boolean tryConversion, String e, String extraParams, Boolean sign) throws
            IOException, OutOfCallsException, InvalidParameterException {

        if (fSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSyms.length() > 500) {
            throw new InvalidParameterException("The max character length of tSyms is 500!");
        }

        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/price?fsym=%s&tsyms=%s",
                fSym.toUpperCase(), tSyms.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > 30) throw new InvalidParameterException("The max character length of e is 30!");
            formattedUrl += "&e=" + e;
        }

        if (extraParams != null) {
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        Type type = new TypeToken<Map<String, Double>>() {}.getType();
        return new Gson().fromJson(r, type);
    }

    /**
     * @see Market#getPrice(String, String, Boolean, String, String, Boolean)
     */
    public Map<String, Double> getPrice(String fSym, String tSyms) throws
            IOException, OutOfCallsException, InvalidParameterException {
        return getPrice(fSym, tSyms, null, null, null, null);
    }

    /**
     * Gets price of an input symbol in multiple output symbols
     * @param fSyms Comma separated cryptocurrency symbols list [Max character length: 300]
     * @param tSyms Comma separated cryptocurrency symbols list to convert into [Max character length: 100]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return Map containing price for each to-symbol
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public Map<String, Map<String, Double>> getMultiPrice(String fSyms, String tSyms, Boolean tryConversion, String e, String extraParams, Boolean sign) throws
            IOException, OutOfCallsException, InvalidParameterException {

        if (fSyms.length() > 300) {
            throw new InvalidParameterException("The max character length of fSyms is 300!");
        }

        if (tSyms.length() > 100) {
            throw new InvalidParameterException("The max character length of tSyms is 100!");
        }

        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/pricemulti?fsyms=%s&tsyms=%s",
                fSyms.toUpperCase(), tSyms.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > 30) throw new InvalidParameterException("The max character length of e is 30!");
            formattedUrl += "&e=" + e;
        }

        if (extraParams != null) {
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        Type type = new TypeToken<Map<String, Map<String, Double>>>() {}.getType();
        return new Gson().fromJson(r, type);
    }

    /**
     * @see Market#getMultiPrice(String, String, Boolean, String, String, Boolean)
     */
    public Map<String, Map<String, Double>> getMultiPrice(String fSym, String tSyms) throws
            IOException, OutOfCallsException, InvalidParameterException {
        return getMultiPrice(fSym, tSyms, null, null, null, null);
    }

    /**
     * Gets full information about multiple input symbols to multiple output symbols
     * @param fSyms Comma separated cryptocurrency symbols list [Max character length: 300]
     * @param tSyms Comma separated cryptocurrency symbols list to convert into [Max character length: 100]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return Map containing price for each to-symbol
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public Map<String, Map<String, toSym>> getMultiFull(String fSyms, String tSyms, Boolean tryConversion, String e, String extraParams, Boolean sign) throws
            IOException, OutOfCallsException, InvalidParameterException {

        if (fSyms.length() > 300) {
            throw new InvalidParameterException("The max character length of fSyms is 300!");
        }

        if (tSyms.length() > 100) {
            throw new InvalidParameterException("The max character length of tSyms is 100!");
        }

        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/pricemultifull?fsyms=%s&tsyms=%s",
                fSyms.toUpperCase(), tSyms.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > 30) throw new InvalidParameterException("The max character length of e is 30!");
            formattedUrl += "&e=" + e;
        }

        if (extraParams != null) {
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<Map<String, Map<String, toSym>>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("RAW"), type);
    }

    /**
     * @see Market#getMultiFull(String, String, Boolean, String, String, Boolean)
     */
    public Map<String, Map<String, toSym>> getMultiFull(String fSym, String tSyms) throws
            IOException, OutOfCallsException, InvalidParameterException {
        return getMultiFull(fSym, tSyms, null, null, null, null);
    }

    /**
     * Gets the day average price for a symbol pair on multiple exchanges
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSym The currency symbol to convert into [Max character length: 10]
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 150]
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return ExchangeAverage A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public ExchangeAverage getExchangeAverage(String fSym, String tSym, String e, String extraParams, Boolean sign) throws
            IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fSyms is 10!");
        }

        if (tSym.length() > 10) {
            throw new InvalidParameterException("The max character length of tSym is 10!");
        }

        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/generateAvg?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (e != null) {
            if (e.length() > 150) throw new InvalidParameterException("The max character length of e is 150!");
            formattedUrl += "&e=" + e;
        }

        if (extraParams != null) {
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        return new Gson().fromJson(jsonObject.getAsJsonObject("RAW"), ExchangeAverage.class);
    }

    /**
     * @see Market#getExchangeAverage(String, String, String, String, Boolean)
     */
    public ExchangeAverage getExchangeAverage(String fSym, String tSym, String e) throws
            IOException, OutOfCallsException, InvalidParameterException {
        return getExchangeAverage(fSym, tSym, e, null, null);
    }

    /**
     * @see Market#getExchangeAverage(String, String, String, String, Boolean)
     */
    public ExchangeAverage getExchangeAverage(String fSym, String tSym) throws
            IOException, OutOfCallsException, InvalidParameterException {
        return getExchangeAverage(fSym, tSym, "CCCAGG", null, null);
    }

    /**
     * Gets the top cryptocurrencies trading to the input symbol by volume
     * @param tSym The currency symbol to convert into [Max character length: 10]
     * @param limit The number of data points to return
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return TopVolumes A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public List<Coin> getTopVolumes(String tSym, Integer limit, String extraParams, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (tSym.length() > 10) {
            throw new InvalidParameterException("The max character length of tSym is 10!");
        }

        String formattedUrl = "https://min-api.cryptocompare.com/data/top/volumes?tsym=" + tSym.toUpperCase();

        if (limit != null) {
            formattedUrl += "&limit=" + limit;
        }

        if (extraParams != null) {
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<List<Coin>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("Data"), type);
    }

    /**
     * @see Market#getTopVolumes(String, Integer, String, Boolean)
     */
    public List<Coin> getTopVolumes(String tSym, Integer limit) throws IOException, OutOfCallsException, InvalidParameterException {
        return getTopVolumes(tSym, limit, null, null);
    }

    /**
     * @see Market#getTopVolumes(String, Integer, String, Boolean)
     */
    public List<Coin> getTopVolumes(String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getTopVolumes(tSym, null, null, null);
    }

    /**
     * Gets the top trading pairs from an input symbol by volume
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param limit The number of data points to return
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return List A List of pair objects
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public List<Pair> getTopPairs(String fSym, Integer limit, String extraParams, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        String formattedUrl = "https://min-api.cryptocompare.com/data/top/pairs?fsym=" + fSym.toUpperCase();

        if (limit != null) {
            formattedUrl += "&limit=" + limit;
        }

        if (extraParams != null) {
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<List<Pair>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("Data"), type);
    }

    /**
     * @see Market#getTopPairs(String, Integer, String, Boolean)
     */
    public List<Pair> getTopPairs(String fSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getTopPairs(fSym, null, null, null);
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
