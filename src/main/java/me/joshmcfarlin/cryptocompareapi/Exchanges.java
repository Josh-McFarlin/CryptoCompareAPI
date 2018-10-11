package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.Utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.Utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Utils.OutOfCallsException;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about Exchanges listed by CryptoCompare
 * @author joshuamcfarlin
 * @version 1
 */
public class Exchanges {
    /**
     * Gets all available trading pairs for each cryptocurrency on all exchanges available from the API
     * @return ExchangeList a class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static ExchangeList getAllExchanges() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON(new URL("https://min-api.cryptocompare.com/data/all/exchanges"), CallTypes.PRICE);
        Type type = new TypeToken<Map<String, Map<String, List<String>>>>() {}.getType();
        Map<String, Map<String, List<String>>> exchangeMap = new Gson().fromJson(r, type);
        return new ExchangeList(exchangeMap);
    }

    /**
     * Finds the top exchanges for a provided pair
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return TopExchanges a class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static List<Exchange> getTopExchanges(String fromSym, String toSym) throws IOException, OutOfCallsException {
        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/top/exchanges?fsym=%s&tsym=%s",
                fromSym.toUpperCase(), toSym.toUpperCase());
        Reader r = Connection.getJSON(new URL(formattedUrl), CallTypes.PRICE);

        JsonObject jobject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<List<Exchange>>() {}.getType();
        return new Gson().fromJson(jobject.get("Data"), type);
    }

    /**
     * Represents a cryptocurrency exchange
     */
    class Exchange {
        /**
         * The name of the exchange
         */
        public String exchange;
        /**
         * The symbol being traded from
         */
        public String fromSymbol;
        /**
         * The symbol being traded to
         */
        public String toSymbol;
        /**
         * 24 hour volume of the trading pair
         */
        public double volume24h;
        /**
         * 24 hour volume of the trading pair to
         */
        public double volume24hTo;
    }

    /**
     * Represents a map of exchanges
     */
    public static class ExchangeList {
        /**
         * A map of all exchanges
         */
        public Map<String, Exchange> exchanges = new HashMap<>();

        /**
         * Creates an ExchangeList from a map of exchanges
         * @param map A map of exchanges
         */
        public ExchangeList(Map<String, Map<String, List<String>>> map) {
            map.forEach((key, val) -> {
                Exchange e = new Exchange(val);
                this.exchanges.put(key, e);
            });
        }

        /**
         * Represents a cryptocurrency exchange
         */
        public class Exchange {
            /**
             * A map of coins listed by the exchange
             */
            public Map<String, Coin> coins = new HashMap<>();

            /**
             * Creates an exchange from a list of coins
             * @param coins A List of coins traded on the exchange
             */
            public Exchange(Map<String, List<String>> coins) {
                coins.forEach((coin, pair) -> {
                    if (pair != null && !pair.isEmpty()) {
                        Coin c = new Coin(pair);
                        this.coins.put(coin, c);
                    }
                });
            }
        }

        /**
         * Represents a cryptocurrency
         */
        public class Coin {
            /**
             * A list of trading pairs
             */
            public List<String> tradingPairs;

            /**
             * Creates a coin from a list of trading pairs
             * @param tradingPairs
             */
            public Coin(List<String> tradingPairs) {
                if (tradingPairs != null && !tradingPairs.isEmpty()) {
                    this.tradingPairs = tradingPairs;
                }
            }
        }
    }
}
