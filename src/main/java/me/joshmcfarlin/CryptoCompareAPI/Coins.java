package me.joshmcfarlin.CryptoCompareAPI;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.CryptoCompareAPI.Utils.CallTypes;
import me.joshmcfarlin.CryptoCompareAPI.Utils.Connection;
import me.joshmcfarlin.CryptoCompareAPI.Utils.OutOfCallsException;

import java.io.*;
import java.net.URL;
import java.util.Map;

/**
 * Contains methods for requesting information about coins listed by CryptoCompare
 * @author joshuamcfarlin
 * @version 1
 */
public class Coins {
    /**
     * Gets general info for all the coins available through the CryptoCompare API
     * @return CoinList a class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static CoinList getCoinList() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON(new URL("https://min-api.cryptocompare.com/data/all/coinlist"), CallTypes.PRICE);
        return new Gson().fromJson(r, CoinList.class);
    }

    /**
     * Represents all coins provided by the CryptoCompare API
     */
    public class CoinList {
        /**
         * Indicates request success
         */
        @SerializedName("Response")
        public String response;
        /**
         * A message provided by the API
         */
        @SerializedName("Message")
        public String message;
        /**
         * All coins provided by the API
         */
        @SerializedName("Data")
        public Map<String, CoinEntry> coins;

        /**
         * Represents a coin on CryptoCompare's website
         */
        public class CoinEntry {
            /**
             * The ID of the coin on CryptoCompare's website
             */
            @SerializedName("Id")
            public int id;
            /**
             * The URL for the coin on CryptoCompare's website
             */
            @SerializedName("Url")
            public String url;
            /**
             * The URL for the coin's image on CryptoCompare's website
             */
            @SerializedName("ImageUrl")
            public String imageUrl;
            /**
             * The coin's symbol
             */
            @SerializedName("Name")
            public String name;
            /**
             * The coin's symbol
             */
            @SerializedName("Symbol")
            public String symbol;
            /**
             * The coin's name
             */
            @SerializedName("CoinName")
            public String coinName;
            /**
             * The coin's full name
             */
            @SerializedName("FullName")
            public String fullName;
            /**
             * The coin's algorithm
             */
            @SerializedName("Algorithm")
            public String algorithm;
            /**
             * The type of proof used by the coin
             */
            @SerializedName("ProofType")
            public String proofType;
            /**
             * Indicates if the coin has been fully premined
             */
            @SerializedName("FullyPremined")
            public String fullyPremined;
            /**
             * Total supply of the coin
             */
            @SerializedName("TotalCoinSupply")
            public String totalCoinSupply;
            /**
             * The value of all the premined coins
             */
            @SerializedName("PreMinedValue")
            public String preMinedValue;
            /**
             * The total number of coins
             */
            @SerializedName("TotalCoinsFreeFloat")
            public String totalCoinsFreeFloat;
            /**
             * Sorting order of the coin on CryptoCompare's website
             */
            @SerializedName("SortOrder")
            public int sortOrder;
            /**
             * Indicates if the coin is sponsored on CryptoCompare's website
             */
            @SerializedName("Sponsored")
            public boolean sponsored;
        }
    }
}
