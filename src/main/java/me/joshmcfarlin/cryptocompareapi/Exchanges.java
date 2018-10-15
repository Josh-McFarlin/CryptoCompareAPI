package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.Exceptions.InvalidParameterException;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about Exchanges listed by CryptoCompare
 * @author Josh McFarlin
 */
public class Exchanges {
    /**
     * Gets all available trading pairs for each cryptocurrency on all exchanges available from the API
     * @return ExchangeList a object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    ExchangeList getAllExchanges() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON("https://min-api.cryptocompare.com/data/all/exchanges", CallTypes.PRICE);

        Type type = new TypeToken<Map<String, Map<String, List<String>>>>() {}.getType();
        Map<String, Map<String, List<String>>> exchangeMap = new Gson().fromJson(r, type);
        return new ExchangeList(exchangeMap);
    }

    /**
     * Finds the top exchanges for a provided pair
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSym The currency symbol to convert into [Max character length: 10]
     * @param limit The number of data points to return
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return TopExchanges a object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     * @throws InvalidParameterException when a given parameter does not meet the API guidelines
     */
    List<Exchange> getTopExchanges(String fSym, String tSym, Integer limit, String extraParams, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fromSym is 10!");
        }

        if (tSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fromSym is 10!");
        }

        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/top/exchanges?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

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
        Type type = new TypeToken<List<Exchange>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("Data"), type);
    }

    /**
     * @see Exchanges#getTopExchanges(String, String, Integer, String, Boolean)
     */
    List<Exchange> getTopExchanges(String fSym, String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getTopExchanges(fSym, tSym, null, null, null);
    }

    /**
     * @see Exchanges#getTopExchanges(String, String, Integer, String, Boolean)
     */
    List<Exchange> getTopExchanges(String fSym, String tSym, Integer limit) throws IOException, OutOfCallsException, InvalidParameterException {
        return getTopExchanges(fSym, tSym, limit, null, null);
    }

    /**
     * Represents a cryptocurrency exchange
     */
    public class Exchange {
        /**
         * The name of the exchange
         */
        private String exchange;

        /**
         * The symbol being traded from
         */
        private String fromSymbol;

        /**
         * The symbol being traded to
         */
        private String toSymbol;

        /**
         * 24 hour volume of the trading pair
         */
        private double volume24h;

        /**
         * 24 hour volume of the trading pair to
         */
        private double volume24hTo;

        /**
         * {@link Exchange#exchange}
         */
        public String getExchange() {
            return exchange;
        }

        /**
         * {@link Exchange#fromSymbol}
         */
        public String getFromSymbol() {
            return fromSymbol;
        }

        /**
         * {@link Exchange#toSymbol}
         */
        public String getToSymbol() {
            return toSymbol;
        }

        /**
         * {@link Exchange#volume24h}
         */
        public double getVolume24h() {
            return volume24h;
        }

        /**
         * {@link Exchange#volume24hTo}
         */
        public double getVolume24hTo() {
            return volume24hTo;
        }
    }

    /**
     * Represents a map of exchanges
     */
    public class ExchangeList {
        /**
         * A map of all exchanges
         */
        private Map<String, Exchange> exchanges = new HashMap<>();

        /**
         * Creates an ExchangeList from a map of exchanges
         * @param map A map of exchanges
         */
        ExchangeList(Map<String, Map<String, List<String>>> map) {
            map.forEach((key, val) -> {
                Exchange e = new Exchange(val);
                this.exchanges.put(key, e);
            });
        }

        /**
         * {@link ExchangeList#exchanges}
         */
        public Map<String, Exchange> getExchanges() {
            return exchanges;
        }

        /**
         * Represents a cryptocurrency exchange
         */
        public class Exchange {
            /**
             * A map of coins listed by the exchange
             */
            private Map<String, Coin> coins = new HashMap<>();

            /**
             * Creates an exchange from a list of coins
             * @param coins A List of coins traded on the exchange
             */
            Exchange(Map<String, List<String>> coins) {
                coins.forEach((coin, pair) -> {
                    if (pair != null && !pair.isEmpty()) {
                        Coin c = new Coin(pair);
                        this.coins.put(coin, c);
                    }
                });
            }

            /**
             * {@link Exchange#coins}
             */
            public Map<String, Coin> getCoins() {
                return coins;
            }
        }

        /**
         * Represents a cryptocurrency
         */
        public class Coin {
            /**
             * A list of trading pairs
             */
            private List<String> tradingPairs;

            /**
             * Creates a coin from a list of trading pairs
             * @param tradingPairs The trading pairs to set
             */
            Coin(List<String> tradingPairs) {
                if (tradingPairs != null && !tradingPairs.isEmpty()) {
                    this.tradingPairs = tradingPairs;
                }
            }

            /**
             * {@link Coin#tradingPairs}
             */
            public List<String> getTradingPairs() {
                return tradingPairs;
            }
        }
    }
}
