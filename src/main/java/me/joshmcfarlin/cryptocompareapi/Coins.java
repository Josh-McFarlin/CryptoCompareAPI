package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about coins listed by CryptoCompare
 * @author Josh McFarlin
 */
public class Coins {
    /**
     * Gets general info for all the coins available through the CryptoCompare API
     * @return CoinList A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public CoinList getCoinList() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON("https://min-api.cryptocompare.com/data/all/coinlist", CallTypes.PRICE);

        return new Gson().fromJson(r, CoinList.class);
    }

    /**
     * Gets snapshot data for a cryptocurrency pair
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return PairSnapshot A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public PairSnapshot getPairSnapshot(String fromSym, String toSym) throws IOException, OutOfCallsException {
        String formattedUrl = String.format("https://www.cryptocompare.com/api/data/coinsnapshot/?fsym=%s&tsym=%s",
                fromSym.toUpperCase(), toSym.toUpperCase());
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        return new Gson().fromJson(r, PairSnapshot.class);
    }

    /**
     * Gets snapshot data for a single cryptocurrency
     * @param id The id representing the cryptocurrency on CryptoCompare's website
     * @return CoinSnapshot A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public CoinSnapshot getCoinSnapshot(int id) throws IOException, OutOfCallsException {
        String formattedUrl = "https://www.cryptocompare.com/api/data/coinsnapshotfullbyid/?id=" + id;
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

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
        private String response;

        /**
         * A message provided by the API
         */
        @SerializedName("Message")
        private String message;

        /**
         * All coins provided by the API
         */
        @SerializedName("Data")
        private Map<String, CoinEntry> coins;

        /**
         * {@link CoinList#response}
         */
        public String getResponse() {
            return response;
        }

        /**
         * {@link CoinList#message}
         */
        public String getMessage() {
            return message;
        }

        /**
         * {@link CoinList#coins}
         */
        public Map<String, CoinEntry> getCoins() {
            return coins;
        }

        /**
         * Represents a coin on CryptoCompare's website
         */
        public class CoinEntry {
            /**
             * The ID of the coin on CryptoCompare's website
             */
            @SerializedName("Id")
            private int id;

            /**
             * The URL for the coin on CryptoCompare's website
             */
            @SerializedName("Url")
            private String url;

            /**
             * The URL for the coin's image on CryptoCompare's website
             */
            @SerializedName("ImageUrl")
            private String imageUrl;

            /**
             * The coin's symbol
             */
            @SerializedName("Name")
            private String name;

            /**
             * The coin's symbol
             */
            @SerializedName("Symbol")
            private String symbol;

            /**
             * The coin's name
             */
            @SerializedName("CoinName")
            private String coinName;

            /**
             * The coin's full name
             */
            @SerializedName("FullName")
            private String fullName;

            /**
             * The coin's algorithm
             */
            @SerializedName("Algorithm")
            private String algorithm;

            /**
             * The type of proof used by the coin
             */
            @SerializedName("ProofType")
            private String proofType;

            /**
             * Indicates if the coin has been fully premined
             */
            @SerializedName("FullyPremined")
            private String fullyPremined;

            /**
             * Total supply of the coin
             */
            @SerializedName("TotalCoinSupply")
            private String totalCoinSupply;

            /**
             * The value of all the premined coins
             */
            @SerializedName("PreMinedValue")
            private String preMinedValue;

            /**
             * The total number of coins
             */
            @SerializedName("TotalCoinsFreeFloat")
            private String totalCoinsFreeFloat;

            /**
             * Sorting order of the coin on CryptoCompare's website
             */
            @SerializedName("SortOrder")
            private int sortOrder;

            /**
             * Indicates if the coin is sponsored on CryptoCompare's website
             */
            @SerializedName("Sponsored")
            private boolean sponsored;

            /**
             * {@link CoinEntry#id}
             */
            public int getId() {
                return id;
            }

            /**
             * {@link CoinEntry#url}
             */
            public String getUrl() {
                return url;
            }

            /**
             * {@link CoinEntry#imageUrl}
             */
            public String getImageUrl() {
                return imageUrl;
            }

            /**
             * {@link CoinEntry#name}
             */
            public String getName() {
                return name;
            }

            /**
             * {@link CoinEntry#symbol}
             */
            public String getSymbol() {
                return symbol;
            }

            /**
             * {@link CoinEntry#coinName}
             */
            public String getCoinName() {
                return coinName;
            }

            /**
             * {@link CoinEntry#fullName}
             */
            public String getFullName() {
                return fullName;
            }

            /**
             * {@link CoinEntry#algorithm}
             */
            public String getAlgorithm() {
                return algorithm;
            }

            /**
             * {@link CoinEntry#proofType}
             */
            public String getProofType() {
                return proofType;
            }

            /**
             * {@link CoinEntry#fullyPremined}
             */
            public String getFullyPremined() {
                return fullyPremined;
            }

            /**
             * {@link CoinEntry#totalCoinSupply}
             */
            public String getTotalCoinSupply() {
                return totalCoinSupply;
            }

            /**
             * {@link CoinEntry#preMinedValue}
             */
            public String getPreMinedValue() {
                return preMinedValue;
            }

            /**
             * {@link CoinEntry#totalCoinsFreeFloat}
             */
            public String getTotalCoinsFreeFloat() {
                return totalCoinsFreeFloat;
            }

            /**
             * {@link CoinEntry#sortOrder}
             */
            public int getSortOrder() {
                return sortOrder;
            }

            /**
             * {@link CoinEntry#sponsored}
             */
            public boolean getSponsored() {
                return sponsored;
            }
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
        private String response;

        /**
         * A message provided by the API
         */
        @SerializedName("Message")
        private String message;

        /**
         * Response type
         */
        @SerializedName("Type")
        private int type;

        /**
         * Response data
         */
        @SerializedName("Data")
        private Data data;

        /**
         * {@link PairSnapshot#response}
         */
        public String getResponse() {
            return response;
        }

        /**
         * {@link PairSnapshot#message}
         */
        public String getMessage() {
            return message;
        }

        /**
         * {@link PairSnapshot#type}
         */
        public int getType() {
            return type;
        }

        /**
         * {@link PairSnapshot#data}
         */
        public Data getData() {
            return data;
        }

        /**
         * Represents data about the coin
         */
        public class Data {
            /**
             * The algorithm used by the cryptocurrency
             */
            @SerializedName("Algorithm")
            private String algorithm;

            /**
             * The type of proof used by the cryptocurrency
             */
            @SerializedName("ProofType")
            private String proofType;

            /**
             * The current block number of the cryptocurrency
             */
            @SerializedName("BlockNumber")
            private int blockNumber;

            /**
             * The current mining net hashes per second for the cryptocurrency
             */
            @SerializedName("NetHashesPerSecond")
            private double netHashesPerSecond;

            /**
             * The total number of coins mined for the cryptocurrency
             */
            @SerializedName("TotalCoinsMined")
            private double totalCoinsMined;

            /**
             * The current reward for mining a block
             */
            @SerializedName("BlockReward")
            private double blockReward;

            /**
             * Aggregated data about the cryptocurrency
             */
            @SerializedName("AggregatedData")
            private AggregatedData aggregatedData;

            /**
             * A list of Exchange objects
             */
            @SerializedName("Exchanges")
            private List<Exchange> exchanges;

            /**
             * {@link Data#algorithm}
             */
            public String getAlgorithm() {
                return algorithm;
            }

            /**
             * {@link Data#proofType}
             */
            public String getProofType() {
                return proofType;
            }

            /**
             * {@link Data#blockNumber}
             */
            public int getBlockNumber() {
                return blockNumber;
            }

            /**
             * {@link Data#netHashesPerSecond}
             */
            public double getNetHashesPerSecond() {
                return netHashesPerSecond;
            }

            /**
             * {@link Data#totalCoinsMined}
             */
            public double getTotalCoinsMined() {
                return totalCoinsMined;
            }

            /**
             * {@link Data#blockReward}
             */
            public double getBlockReward() {
                return blockReward;
            }

            /**
             * {@link Data#aggregatedData}
             */
            public AggregatedData getAggregatedData() {
                return aggregatedData;
            }

            /**
             * {@link Data#exchanges}
             */
            public List<Exchange> getExchanges() {
                return exchanges;
            }

            /**
             * Represents general data about the coin
             */
            public class AggregatedData {
                /**
                 * Type
                 */
                @SerializedName("TYPE")
                private int type;

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
                 * Day volume
                 */
                @SerializedName("VOLUMEDAY")
                private double volumeDay;

                /**
                 * Day volume to
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
                 * {@link AggregatedData#type}
                 */
                public int getType() {
                    return type;
                }

                /**
                 * {@link AggregatedData#market}
                 */
                public String getMarket() {
                    return market;
                }

                /**
                 * {@link AggregatedData#fromSymbol}
                 */
                public String getFromSymbol() {
                    return fromSymbol;
                }

                /**
                 * {@link AggregatedData#toSymbol}
                 */
                public String getToSymbol() {
                    return toSymbol;
                }

                /**
                 * {@link AggregatedData#flags}
                 */
                public int getFlags() {
                    return flags;
                }

                /**
                 * {@link AggregatedData#price}
                 */
                public double getPrice() {
                    return price;
                }

                /**
                 * {@link AggregatedData#lastUpdate}
                 */
                public int getLastUpdate() {
                    return lastUpdate;
                }

                /**
                 * {@link AggregatedData#lastVolume}
                 */
                public double getLastVolume() {
                    return lastVolume;
                }

                /**
                 * {@link AggregatedData#lastVolumeTo}
                 */
                public double getLastVolumeTo() {
                    return lastVolumeTo;
                }

                /**
                 * {@link AggregatedData#lastTradeID}
                 */
                public String getLastTradeID() {
                    return lastTradeID;
                }

                /**
                 * {@link AggregatedData#volumeDay}
                 */
                public double getVolumeDay() {
                    return volumeDay;
                }

                /**
                 * {@link AggregatedData#volumeDayTo}
                 */
                public double getVolumeDayTo() {
                    return volumeDayTo;
                }

                /**
                 * {@link AggregatedData#volume24Hour}
                 */
                public double getVolume24Hour() {
                    return volume24Hour;
                }

                /**
                 * {@link AggregatedData#volume24HourTo}
                 */
                public double getVolume24HourTo() {
                    return volume24HourTo;
                }

                /**
                 * {@link AggregatedData#openDay}
                 */
                public double getOpenDay() {
                    return openDay;
                }

                /**
                 * {@link AggregatedData#highDay}
                 */
                public double getHighDay() {
                    return highDay;
                }

                /**
                 * {@link AggregatedData#lowDay}
                 */
                public double getLowDay() {
                    return lowDay;
                }

                /**
                 * {@link AggregatedData#open24Hour}
                 */
                public double getOpen24Hour() {
                    return open24Hour;
                }

                /**
                 * {@link AggregatedData#high24Hour}
                 */
                public double getHigh24Hour() {
                    return high24Hour;
                }

                /**
                 * {@link AggregatedData#low24Hour}
                 */
                public double getLow24Hour() {
                    return low24Hour;
                }

                /**
                 * {@link AggregatedData#lastMarket}
                 */
                public String getLastMarket() {
                    return lastMarket;
                }
            }

            /**
             * Represents exchange data
             */
            public class Exchange {
                /**
                 * Type
                 */
                @SerializedName("TYPE")
                private int type;

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
                 * {@link Exchange#type}
                 */
                public int getType() {
                    return type;
                }

                /**
                 * {@link Exchange#market}
                 */
                public String getMarket() {
                    return market;
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
                 * {@link Exchange#flags}
                 */
                public int getFlags() {
                    return flags;
                }

                /**
                 * {@link Exchange#price}
                 */
                public double getPrice() {
                    return price;
                }

                /**
                 * {@link Exchange#lastUpdate}
                 */
                public int getLastUpdate() {
                    return lastUpdate;
                }

                /**
                 * {@link Exchange#lastVolume}
                 */
                public double getLastVolume() {
                    return lastVolume;
                }

                /**
                 * {@link Exchange#lastVolumeTo}
                 */
                public double getLastVolumeTo() {
                    return lastVolumeTo;
                }

                /**
                 * {@link Exchange#lastTradeID}
                 */
                public String getLastTradeID() {
                    return lastTradeID;
                }

                /**
                 * {@link Exchange#volume24Hour}
                 */
                public double getVolume24Hour() {
                    return volume24Hour;
                }

                /**
                 * {@link Exchange#volume24HourTo}
                 */
                public double getVolume24HourTo() {
                    return volume24HourTo;
                }

                /**
                 * {@link Exchange#open24Hour}
                 */
                public double getOpen24Hour() {
                    return open24Hour;
                }

                /**
                 * {@link Exchange#high24Hour}
                 */
                public double getHigh24Hour() {
                    return high24Hour;
                }

                /**
                 * {@link Exchange#low24Hour}
                 */
                public double getLow24Hour() {
                    return low24Hour;
                }
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
        private String response;

        /**
         * A message provided by the API
         */
        @SerializedName("Message")
        private String message;

        /**
         * Response type
         */
        @SerializedName("Type")
        private int type;

        /**
         * Response data
         */
        @SerializedName("Data")
        private Data data;

        /**
         * {@link CoinSnapshot#response}
         */
        public String getResponse() {
            return response;
        }

        /**
         * {@link CoinSnapshot#message}
         */
        public String getMessage() {
            return message;
        }

        /**
         * {@link CoinSnapshot#type}
         */
        public int getType() {
            return type;
        }

        /**
         * {@link CoinSnapshot#data}
         */
        public Data getData() {
            return data;
        }

        /**
         * Represents the data
         */
        public class Data {
            /**
             * SEO data for the coin
             */
            @SerializedName("SEO")
            private SEO seo;

            /**
             * General data about the coin
             */
            @SerializedName("General")
            private General general;

            /**
             * ICO data about the coin
             */
            @SerializedName("Ico")
            private ICO ico;

            /**
             * A list of subscriptions used for the streamer and for figuring out what the coin pairs are
             */
            @SerializedName("Subs")
            private List<String> subs;

            /**
             * A list of aggregated prices for all pairs available
             */
            @SerializedName("StreamerDataRaw")
            private List<String> streamerDataRaw;

            /**
             * {@link Data#seo}
             */
            public SEO getSeo() {
                return seo;
            }

            /**
             * {@link Data#general}
             */
            public General getGeneral() {
                return general;
            }

            /**
             * {@link Data#ico}
             */
            public ICO getIco() {
                return ico;
            }

            /**
             * {@link Data#subs}
             */
            public List<String> getSubs() {
                return subs;
            }

            /**
             * {@link Data#streamerDataRaw}
             */
            public List<String> getStreamerDataRaw() {
                return streamerDataRaw;
            }

            /**
             * Represents SEO data
             */
            public class SEO {
                /**
                 * The page title on CryptoCompare
                 */
                @SerializedName("PageTitle")
                private String pageTitle;

                /**
                 * The page description on CryptoCompare
                 */
                @SerializedName("PageDescription")
                private String pageDescription;

                /**
                 * The base URL
                 */
                @SerializedName("BaseUrl")
                private String baseUrl;

                /**
                 * The image base url
                 */
                @SerializedName("BaseImageUrl")
                private String baseImageUrl;

                /**
                 * The remaining image URL
                 */
                @SerializedName("OgImageUrl")
                private String ogImageUrl;

                /**
                 * The image width
                 */
                @SerializedName("OgImageWidth")
                private double ogImageWidth;

                /**
                 * The image height
                 */
                @SerializedName("OgImageHeight")
                private double ogImageHeight;

                /**
                 * {@link SEO#pageTitle}
                 */
                public String getPageTitle() {
                    return pageTitle;
                }

                /**
                 * {@link SEO#pageDescription}
                 */
                public String getPageDescription() {
                    return pageDescription;
                }

                /**
                 * {@link SEO#baseUrl}
                 */
                public String getBaseUrl() {
                    return baseUrl;
                }

                /**
                 * {@link SEO#baseImageUrl}
                 */
                public String getBaseImageUrl() {
                    return baseImageUrl;
                }

                /**
                 * {@link SEO#ogImageUrl}
                 */
                public String getOgImageUrl() {
                    return ogImageUrl;
                }

                /**
                 * {@link SEO#ogImageWidth}
                 */
                public double getOgImageWidth() {
                    return ogImageWidth;
                }

                /**
                 * {@link SEO#ogImageHeight}
                 */
                public double getOgImageHeight() {
                    return ogImageHeight;
                }
            }

            /**
             * Represents the general data available for this coin
             */
            public class General {
                /**
                 * The id of the coin
                 */
                @SerializedName("Id")
                private int id;

                /**
                 * The type of document
                 */
                @SerializedName("DocumentType")
                private String documentType;

                /**
                 * The title used on the CryptoCompare website (a combination of the coin name and the symbol)
                 */
                @SerializedName("H1Text")
                private String h1Text;

                /**
                 * The text displayed in red on the website at the top, generally a big issue with the coin
                 */
                @SerializedName("DangerTop")
                private String dangerTop;

                /**
                 * The text displayed in yellow on the website at the top, generally an issue with the coin
                 */
                @SerializedName("WarningTop")
                private String warningTop;

                /**
                 * The text displayed in green on the website at the top, generally an announcement or extra info that is important
                 */
                @SerializedName("InfoTop")
                private String infoTop;

                /**
                 * The symbol of the coin
                 */
                @SerializedName("Symbol")
                private String symbol;

                /**
                 * The relative path to the coin, prefix this value with the BaseLinkUrl to get the absolute path
                 */
                @SerializedName("Url")
                private String url;

                /**
                 * The base angular URL
                 */
                @SerializedName("BaseAngularUrl")
                private String baseAngularUrl;

                /**
                 * The name of the coin
                 */
                @SerializedName("Name")
                private String name;

                /**
                 * The relative path to the logo of the coin, prefix this value with the BaseImageUrl to get the absolute path
                 */
                @SerializedName("ImageUrl")
                private String imageUrl;

                /**
                 * The description of the coin, this is returned as html
                 */
                @SerializedName("Description")
                private String description;

                /**
                 * The features of the coin, this is returned as html
                 */
                @SerializedName("Features")
                private String features;

                /**
                 * The technology of the coin, this is returned as html
                 */
                @SerializedName("Technology")
                private String technology;

                /**
                 * The maximum number of coins
                 */
                @SerializedName("TotalCoinSupply")
                private String totalCoinSupply;

                /**
                 * The algorithm of the coin
                 */
                @SerializedName("Algorithm")
                private String algorithm;

                /**
                 * The proof type of the coin
                 */
                @SerializedName("ProofType")
                private String proofType;

                /**
                 * The day the first block was mined, so the day the coin actually came into existence
                 */
                @SerializedName("StartDate")
                private String startDate;

                /**
                 * The twitter address of the coin
                 */
                @SerializedName("Twitter")
                private String twitter;

                /**
                 * The affiliate URL
                 */
                @SerializedName("AffiliateUrl")
                private String affiliateUrl;

                /**
                 * The coin official website
                 */
                @SerializedName("Website")
                private String website;

                /**
                 * The sponsor of the coin if it is being sponsored
                 */
                @SerializedName("Sponsor")
                private Sponsor sponsor;

                /**
                 * The last time our block explorer got data about this coin
                 */
                @SerializedName("LastBlockExplorerUpdateTS")
                private String lastBlockExplorerUpdateTS;

                /**
                 * The difficulty adjustment
                 */
                @SerializedName("DifficultyAdjustment")
                private String difficultyAdjustment;

                /**
                 * The value by which the block reward is reduced when there is a block reward reduction
                 */
                @SerializedName("BlockRewardReduction")
                private String blockRewardReduction;

                /**
                 * The current block number (delayed by 1 hour max)
                 */
                @SerializedName("BlockNumber")
                private String blockNumber;

                /**
                 * The estimated time it takes to mine a block
                 */
                @SerializedName("BlockTime")
                private String blockTime;

                /**
                 * The current network hashes per second (delayed by 1 hour max)
                 */
                @SerializedName("NetHashesPerSecond")
                private String netHashesPerSecond;

                /**
                 * The current total coins mined (delayed by 1 hour max)
                 */
                @SerializedName("TotalCoinsMined")
                private String totalCoinsMined;

                /**
                 * The total coins mined as of the previous block, this should be the value of the current block total coins mined - the block reward in most cases.
                 */
                @SerializedName("PreviousTotalCoinsMined")
                private String previousTotalCoinsMined;

                /**
                 * The current block reward (delayed by 1 hour max)
                 */
                @SerializedName("BlockReward")
                private String blockReward;

                /**
                 * {@link General#id}
                 */
                public int getId() {
                    return id;
                }

                /**
                 * {@link General#documentType}
                 */
                public String getDocumentType() {
                    return documentType;
                }

                /**
                 * {@link General#h1Text}
                 */
                public String getH1Text() {
                    return h1Text;
                }

                /**
                 * {@link General#dangerTop}
                 */
                public String getDangerTop() {
                    return dangerTop;
                }

                /**
                 * {@link General#warningTop}
                 */
                public String getWarningTop() {
                    return warningTop;
                }

                /**
                 * {@link General#infoTop}
                 */
                public String getInfoTop() {
                    return infoTop;
                }

                /**
                 * {@link General#symbol}
                 */
                public String getSymbol() {
                    return symbol;
                }

                /**
                 * {@link General#url}
                 */
                public String getUrl() {
                    return url;
                }

                /**
                 * {@link General#baseAngularUrl}
                 */
                public String getBaseAngularUrl() {
                    return baseAngularUrl;
                }

                /**
                 * {@link General#name}
                 */
                public String getName() {
                    return name;
                }

                /**
                 * {@link General#imageUrl}
                 */
                public String getImageUrl() {
                    return imageUrl;
                }

                /**
                 * {@link General#description}
                 */
                public String getDescription() {
                    return description;
                }

                /**
                 * {@link General#features}
                 */
                public String getFeatures() {
                    return features;
                }

                /**
                 * {@link General#technology}
                 */
                public String getTechnology() {
                    return technology;
                }

                /**
                 * {@link General#totalCoinSupply}
                 */
                public String getTotalCoinSupply() {
                    return totalCoinSupply;
                }

                /**
                 * {@link General#algorithm}
                 */
                public String getAlgorithm() {
                    return algorithm;
                }

                /**
                 * {@link General#proofType}
                 */
                public String getProofType() {
                    return proofType;
                }

                /**
                 * {@link General#startDate}
                 */
                public String getStartDate() {
                    return startDate;
                }

                /**
                 * {@link General#twitter}
                 */
                public String getTwitter() {
                    return twitter;
                }

                /**
                 * {@link General#affiliateUrl}
                 */
                public String getAffiliateUrl() {
                    return affiliateUrl;
                }

                /**
                 * {@link General#website}
                 */
                public String getWebsite() {
                    return website;
                }

                /**
                 * {@link General#sponsor}
                 */
                public Sponsor getSponsor() {
                    return sponsor;
                }

                /**
                 * {@link General#lastBlockExplorerUpdateTS}
                 */
                public String getLastBlockExplorerUpdateTS() {
                    return lastBlockExplorerUpdateTS;
                }

                /**
                 * {@link General#difficultyAdjustment}
                 */
                public String getDifficultyAdjustment() {
                    return difficultyAdjustment;
                }

                /**
                 * {@link General#blockRewardReduction}
                 */
                public String getBlockRewardReduction() {
                    return blockRewardReduction;
                }

                /**
                 * {@link General#blockNumber}
                 */
                public String getBlockNumber() {
                    return blockNumber;
                }

                /**
                 * {@link General#blockTime}
                 */
                public String getBlockTime() {
                    return blockTime;
                }

                /**
                 * {@link General#netHashesPerSecond}
                 */
                public String getNetHashesPerSecond() {
                    return netHashesPerSecond;
                }

                /**
                 * {@link General#totalCoinsMined}
                 */
                public String getTotalCoinsMined() {
                    return totalCoinsMined;
                }

                /**
                 * {@link General#previousTotalCoinsMined}
                 */
                public String getPreviousTotalCoinsMined() {
                    return previousTotalCoinsMined;
                }

                /**
                 * {@link General#blockReward}
                 */
                public String getBlockReward() {
                    return blockReward;
                }

                /**
                 * Represents a coin sponsor
                 */
                public class Sponsor {
                    /**
                     * The text displayed on the website at the top
                     */
                    @SerializedName("TextTop")
                    private String textTop;

                    /**
                     * The URL to the sponsor
                     */
                    @SerializedName("Link")
                    private String link;

                    /**
                     * The image URL for the sponsor
                     */
                    @SerializedName("ImageUrl")
                    private String imageUrl;

                    /**
                     * {@link Sponsor#textTop}
                     */
                    public String getTextTop() {
                        return textTop;
                    }

                    /**
                     * {@link Sponsor#link}
                     */
                    public String getLink() {
                        return link;
                    }

                    /**
                     * {@link Sponsor#imageUrl}
                     */
                    public String getImageUrl() {
                        return imageUrl;
                    }
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
                private String status;
                /**
                 * Status of the white-paper
                 */
                @SerializedName("WhitePaper")
                private String whitePaper;

                /**
                 * {@link ICO#status}
                 */
                public String getStatus() {
                    return status;
                }

                /**
                 * {@link ICO#whitePaper}
                 */
                public String getWhitePaper() {
                    return whitePaper;
                }
            }
        }
    }
}
