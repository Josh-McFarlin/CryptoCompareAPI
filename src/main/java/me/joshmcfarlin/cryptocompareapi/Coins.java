package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.Utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.Utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about coins listed by CryptoCompare
 * @author Josh McFarlin
 */
public class Coins {
    /**
     * Gets general info for all the coins available through the CryptoCompare API
     * @return CoinList a class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static CoinList getCoinList() throws IOException, OutOfCallsException, InterruptedException {
        Reader r = Connection.getJSON(URI.create("https://min-api.cryptocompare.com/data/all/coinlist"), CallTypes.PRICE);
        return new Gson().fromJson(r, CoinList.class);
    }

    /**
     * Gets snapshot data for a cryptocurrency pair
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return PairSnapshot a class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static PairSnapshot getPairSnapshot(String fromSym, String toSym) throws IOException, OutOfCallsException, NumberFormatException, InterruptedException {
        String formattedUrl = String.format("https://www.cryptocompare.com/api/data/coinsnapshot/?fsym=%s&tsym=%s",
                fromSym.toUpperCase(), toSym.toUpperCase());
        Reader r = Connection.getJSON(URI.create(formattedUrl), CallTypes.PRICE);
        return new Gson().fromJson(r, PairSnapshot.class);
    }

    public static CoinSnapshot getCoinSnapshot(int id) throws IOException, OutOfCallsException, NumberFormatException, InterruptedException {
        Reader r = Connection.getJSON(URI.create(
                "https://www.cryptocompare.com/api/data/coinsnapshotfullbyid/?id=" + id), CallTypes.PRICE);
        return new Gson().fromJson(r, CoinSnapshot.class);
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


    /**
     * Represents a snapshot about the coin
     */
    public class PairSnapshot {
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
         * Response type
         */
        @SerializedName("Type")
        public int type;

        /**
         * Response data
         */
        @SerializedName("Data")
        public Data data;

        /**
         * Represents data about the coin
         */
        public class Data {
            /**
             * The algorithm used by the cryptocurrency
             */
            @SerializedName("Algorithm")
            public String algorithm;
            /**
             * The type of proof used by the cryptocurrency
             */
            @SerializedName("ProofType")
            public String proofType;
            /**
             * The current block number of the cryptocurrency
             */
            @SerializedName("BlockNumber")
            public int blockNumber;
            /**
             * The current mining net hashes per second for the cryptocurrency
             */
            @SerializedName("NetHashesPerSecond")
            public double netHashesPerSecond;
            /**
             * The total number of coins mined for the cryptocurrency
             */
            @SerializedName("TotalCoinsMined")
            public double totalCoinsMined;
            /**
             * The current reward for mining a block
             */
            @SerializedName("BlockReward")
            public double blockReward;
            /**
             * Aggregated data about the cryptocurrency
             */
            @SerializedName("AggregatedData")
            public AggregatedData aggregatedData;
            /**
             * A list of Exchange classes
             */
            @SerializedName("Exchanges")
            public List<Exchange> exchanges;

            /**
             * Represents general data about the coin
             */
            public class AggregatedData {
                /**
                 * Type
                 */
                @SerializedName("TYPE")
                public int type;
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
                 * Day volume
                 */
                @SerializedName("VOLUMEDAY")
                public double volumeDay;
                /**
                 * Day volume to
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
            }

            /**
             * Represents exchange data
             */
            public class Exchange {
                /**
                 * Type
                 */
                @SerializedName("TYPE")
                public int type;
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
            }
        }
    }

    /**
     * Represents full snapshot data
     */
    public class CoinSnapshot {
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
         * Response type
         */
        @SerializedName("Type")
        public int type;

        /**
         * Response data
         */
        @SerializedName("Data")
        public Data data;

        /**
         * Represents the data
         */
        public class Data {
            /**
             * SEO data for the coin
             */
            @SerializedName("SEO")
            public SEO seo;
            /**
             * General data about the coin
             */
            @SerializedName("General")
            public General general;
            /**
             * ICO data about the coin
             */
            @SerializedName("Ico")
            public ICO ico;
            /**
             * A list of subscriptions used for the streamer and for figuring out what the coin pairs are
             */
            @SerializedName("Subs")
            public List<String> subs;
            /**
             * A list of aggregated prices for all pairs available
             */
            @SerializedName("StreamerDataRaw")
            public List<String> streamerDataRaw;

            /**
             * Represents SEO data
             */
            public class SEO {
                /**
                 * The page title on CryptoCompare
                 */
                @SerializedName("PageTitle")
                public String pageTitle;
                /**
                 * The page description on CryptoCompare
                 */
                @SerializedName("PageDescription")
                public String pageDescription;
                /**
                 * The base URL
                 */
                @SerializedName("BaseUrl")
                public String baseUrl;
                /**
                 * The image base url
                 */
                @SerializedName("BaseImageUrl")
                public String baseImageUrl;
                /**
                 * The remaining image URL
                 */
                @SerializedName("OgImageUrl")
                public String ogImageUrl;
                /**
                 * The image width
                 */
                @SerializedName("OgImageWidth")
                public double ogImageWidth;
                /**
                 * The image height
                 */
                @SerializedName("OgImageHeight")
                public double ogImageHeight;
            }

            /**
             * Represents the general data available for this coin
             */
            public class General {
                /**
                 * The id of the coin
                 */
                @SerializedName("Id")
                public int id;
                /**
                 * The type of document
                 */
                @SerializedName("DocumentType")
                public String documentType;
                /**
                 * The title used on the CryptoCompare website (a combination of the coin name and the symbol)
                 */
                @SerializedName("H1Text")
                public String h1Text;
                /**
                 * The text displayed in red on the website at the top, generally a big issue with the coin
                 */
                @SerializedName("DangerTop")
                public String dangerTop;
                /**
                 * The text displayed in yellow on the website at the top, generally an issue with the coin
                 */
                @SerializedName("WarningTop")
                public String warningTop;
                /**
                 * The text displayed in green on the website at the top, generally an announcement or extra info that is important
                 */
                @SerializedName("InfoTop")
                public String infoTop;
                /**
                 * The symbol of the coin
                 */
                @SerializedName("Symbol")
                public String symbol;
                /**
                 * The relative path to the coin, prefix this value with the BaseLinkUrl to get the absolute path
                 */
                @SerializedName("Url")
                public String url;
                /**
                 * The base angular URL
                 */
                @SerializedName("BaseAngularUrl")
                public String baseAngularUrl;
                /**
                 * The name of the coin
                 */
                @SerializedName("Name")
                public String name;
                /**
                 * The relative path to the logo of the coin, prefix this value with the BaseImageUrl to get the absolute path
                 */
                @SerializedName("ImageUrl")
                public String imageUrl;
                /**
                 * The description of the coin, this is returned as html
                 */
                @SerializedName("Description")
                public String description;
                /**
                 * The features of the coin, this is returned as html
                 */
                @SerializedName("Features")
                public String features;
                /**
                 * The technology of the coin, this is returned as html
                 */
                @SerializedName("Technology")
                public String technology;
                /**
                 * The maximum number of coins
                 */
                @SerializedName("TotalCoinSupply")
                public String totalCoinSupply;
                /**
                 * The algorithm of the coin
                 */
                @SerializedName("Algorithm")
                public String algorithm;
                /**
                 * The proof type of the coin
                 */
                @SerializedName("ProofType")
                public String proofType;
                /**
                 * The day the first block was mined, so the day the coin actually came into existence
                 */
                @SerializedName("StartDate")
                public String startDate;
                /**
                 * The twitter address of the coin
                 */
                @SerializedName("Twitter")
                public String twitter;
                /**
                 * The affiliate URL
                 */
                @SerializedName("AffiliateUrl")
                public String affiliateUrl;
                /**
                 * The coin official website
                 */
                @SerializedName("Website")
                public String website;
                /**
                 * The sponsor of the coin if it is being sponsored
                 */
                @SerializedName("Sponsor")
                public Sponsor sponsor;
                /**
                 * The last time our block explorer got data about this coin
                 */
                @SerializedName("LastBlockExplorerUpdateTS")
                public String lastBlockExplorerUpdateTS;
                /**
                 * The difficulty adjustment
                 */
                @SerializedName("DifficultyAdjustment")
                public String difficultyAdjustment;
                /**
                 * The value by which the block reward is reduced when there is a block reward reduction
                 */
                @SerializedName("BlockRewardReduction")
                public String blockRewardReduction;
                /**
                 * The current block number (delayed by 1 hour max)
                 */
                @SerializedName("BlockNumber")
                public String blockNumber;
                /**
                 * The estimated time it takes to mine a block
                 */
                @SerializedName("BlockTime")
                public String blockTime;
                /**
                 * The current network hashes per second (delayed by 1 hour max)
                 */
                @SerializedName("NetHashesPerSecond")
                public String netHashesPerSecond;
                /**
                 * The current total coins mined (delayed by 1 hour max)
                 */
                @SerializedName("TotalCoinsMined")
                public String totalCoinsMined;
                /**
                 * The total coins mined as of the previous block, this should be the value of the current block total coins mined - the block reward in most cases.
                 */
                @SerializedName("PreviousTotalCoinsMined")
                public String previousTotalCoinsMined;
                /**
                 * The current block reward (delayed by 1 hour max)
                 */
                @SerializedName("BlockReward")
                public String blockReward;

                /**
                 * Represents a coin sponsor
                 */
                public class Sponsor {
                    /**
                     * The text displayed on the website at the top
                     */
                    @SerializedName("TextTop")
                    public String textTop;
                    /**
                     * The URL to the sponsor
                     */
                    @SerializedName("Link")
                    public String link;
                    /**
                     * The image URL for the sponsor
                     */
                    @SerializedName("ImageUrl")
                    public String imageUrl;
                }
            }

            /**
             * Represents ICO data
             */
            public class ICO {
                /**
                 * Status of the ICO
                 */
                @SerializedName("Status")
                public String status;
                /**
                 * Status of the whitepaper
                 */
                @SerializedName("WhitePaper")
                public String whitePaper;
            }
        }
    }
}
