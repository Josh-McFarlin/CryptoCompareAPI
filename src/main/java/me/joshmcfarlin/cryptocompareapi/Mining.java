package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.util.Map;

/**
 * Contains methods for requesting information about cryptocurrency mining
 * @author Josh McFarlin
 */
public class Mining {
    /**
     * Gets information about recent mining contracts
     * @return Contracts A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Contracts getContracts() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON("https://www.cryptocompare.com/api/data/miningcontracts/", CallTypes.OTHER);

        return new Gson().fromJson(r, Contracts.class);
    }

    /**
     * Gets information about different mining equipment
     * @return Equipment A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Equipment getEquipment() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON("https://www.cryptocompare.com/api/data/miningequipment/", CallTypes.OTHER);

        return new Gson().fromJson(r, Equipment.class);
    }

    /**
     * Represents mining contracts
     */
    public class Contracts {
        /**
         * The response provided by the API
         */
        @SerializedName("Response")
        private String response;

        /**
         * Message provided by the API
         */
        @SerializedName("Message")
        private String message;

        /**
         * Mining data
         */
        @SerializedName("MiningData")
        private Map<Integer, Contract> contracts;

        /**
         * Coin data
         */
        @SerializedName("CoinData")
        private Map<String, Coin> coins;

        /**
         * Response type
         */
        @SerializedName("Type")
        private int type;

        /**
         * {@link Contracts#response}
         */
        public String getResponse() {
            return response;
        }

        /**
         * {@link Contracts#message}
         */
        public String getMessage() {
            return message;
        }

        /**
         * {@link Contracts#contracts}
         */
        public Map<Integer, Contract> getContracts() {
            return contracts;
        }

        /**
         * {@link Contracts#coins}
         */
        public Map<String, Coin> getCoins() {
            return coins;
        }

        /**
         * {@link Contracts#type}
         */
        public int getType() {
            return type;
        }

        /**
         * Represents a mining contract
         */
        public class Contract {
            /**
             * ID of the equipment
             */
            @SerializedName("Id")
            private int id;

            /**
             * Parent ID of the equipment
             */
            @SerializedName("ParentId")
            private int parentID;

            /**
             * Equipment company
             */
            @SerializedName("Company")
            private String company;

            /**
             * Url
             */
            @SerializedName("Url")
            private String url;

            /**
             * Url of the logo
             */
            @SerializedName("LogoUrl")
            private String logoURL;

            /**
             * Equipment name
             */
            @SerializedName("Name")
            private String name;

            /**
             * Represents if recommended equipment
             */
            @SerializedName("Recommended")
            private boolean recommended;

            /**
             * Represents if sponsored equipment
             */
            @SerializedName("Sponsored")
            private boolean sponsored;

            /**
             * Affiliate url
             */
            @SerializedName("AffiliateURL")
            private String affiliateURL;

            /**
             * Equipment algorithm
             */
            @SerializedName("Algorithm")
            private String algorithm;

            /**
             * Number of hashes per second the equipment can reach
             */
            @SerializedName("HashesPerSecond")
            private String hashesPerSecond;

            /**
             * Cost of the equipment
             */
            @SerializedName("Cost")
            private double cost;

            /**
             * Currency of the cost
             */
            @SerializedName("Currency")
            private String currency;

            /**
             * Cost of the fee
             */
            @SerializedName("FeeValue")
            private double feeValue;

            /**
             * Currency of the fee
             */
            @SerializedName("FeeValueCurrency")
            private String feeValueCurrency;

            /**
             * Length of the contract
             */
            @SerializedName("ContractLength")
            private String contractLength;

            /**
             * Currencies available to be mined with the equipment
             */
            @SerializedName("CurrenciesAvailable")
            private String currenciesAvailable;

            /**
             * Logos of the currencies available for mining
             */
            @SerializedName("CurrenciesAvailableLogo")
            private String currenciesAvailableLogo;

            /**
             * Currencies available to be mined with the equipment
             */
            @SerializedName("CurrenciesAvailableName")
            private String currenciesAvailableName;

            @Override
            public String toString() {
                return String.format("%s - %s", company, name);
            }

            /**
             * {@link Contract#id}
             */
            public int getId() {
                return id;
            }

            /**
             * {@link Contract#parentID}
             */
            public int getParentID() {
                return parentID;
            }

            /**
             * {@link Contract#company}
             */
            public String getCompany() {
                return company;
            }

            /**
             * {@link Contract#url}
             */
            public String getUrl() {
                return url;
            }

            /**
             * {@link Contract#logoURL}
             */
            public String getLogoURL() {
                return logoURL;
            }

            /**
             * {@link Contract#name}
             */
            public String getName() {
                return name;
            }

            /**
             * {@link Contract#recommended}
             */
            public boolean isRecommended() {
                return recommended;
            }

            /**
             * {@link Contract#sponsored}
             */
            public boolean isSponsored() {
                return sponsored;
            }

            /**
             * {@link Contract#affiliateURL}
             */
            public String getAffiliateURL() {
                return affiliateURL;
            }

            /**
             * {@link Contract#algorithm}
             */
            public String getAlgorithm() {
                return algorithm;
            }

            /**
             * {@link Contract#hashesPerSecond}
             */
            public String getHashesPerSecond() {
                return hashesPerSecond;
            }

            /**
             * {@link Contract#cost}
             */
            public double getCost() {
                return cost;
            }

            /**
             * {@link Contract#currency}
             */
            public String getCurrency() {
                return currency;
            }

            /**
             * {@link Contract#feeValue}
             */
            public double getFeeValue() {
                return feeValue;
            }

            /**
             * {@link Contract#feeValueCurrency}
             */
            public String getFeeValueCurrency() {
                return feeValueCurrency;
            }

            /**
             * {@link Contract#contractLength}
             */
            public String getContractLength() {
                return contractLength;
            }

            /**
             * {@link Contract#currenciesAvailable}
             */
            public String getCurrenciesAvailable() {
                return currenciesAvailable;
            }

            /**
             * {@link Contract#currenciesAvailableLogo}
             */
            public String getCurrenciesAvailableLogo() {
                return currenciesAvailableLogo;
            }

            /**
             * {@link Contract#currenciesAvailableName}
             */
            public String getCurrenciesAvailableName() {
                return currenciesAvailableName;
            }
        }
    }

    /**
     * Represents mining equipment
     */
    public class Equipment {
        /**
         * The response provided by the API
         */
        @SerializedName("Response")
        private String response;

        /**
         * Message provided by the API
         */
        @SerializedName("Message")
        private String message;

        /**
         * Mining data
         */
        @SerializedName("MiningData")
        private Map<Integer, Equip> equipment;

        /**
         * Coin data
         */
        @SerializedName("CoinData")
        private Map<String, Coin> coins;

        /**
         * Response type
         */
        @SerializedName("Type")
        private int type;

        /**
         * {@link Equipment#response}
         */
        public String getResponse() {
            return response;
        }

        /**
         * {@link Equipment#message}
         */
        public String getMessage() {
            return message;
        }

        /**
         * {@link Equipment#equipment}
         */
        public Map<Integer, Equip> getEquipment() {
            return equipment;
        }

        /**
         * {@link Equipment#coins}
         */
        public Map<String, Coin> getCoins() {
            return coins;
        }

        /**
         * {@link Equipment#type}
         */
        public int getType() {
            return type;
        }

        /**
         * Represents data about mining equipment
         */
        public class Equip {
            /**
             * ID of the equipment
             */
            @SerializedName("Id")
            private int id;

            /**
             * Parent ID of the equipment
             */
            @SerializedName("ParentId")
            private int parentID;

            /**
             * Equipment company
             */
            @SerializedName("Company")
            private String company;

            /**
             * Url
             */
            @SerializedName("Url")
            private String url;

            /**
             * Url of the logo
             */
            @SerializedName("LogoUrl")
            private String logoURL;

            /**
             * Equipment name
             */
            @SerializedName("Name")
            private String name;

            /**
             * Represents if recommended equipment
             */
            @SerializedName("Recommended")
            private boolean recommended;

            /**
             * Represents if sponsored equipment
             */
            @SerializedName("Sponsored")
            private boolean sponsored;

            /**
             * Affiliate url
             */
            @SerializedName("AffiliateURL")
            private String affiliateURL;

            /**
             * Equipment algorithm
             */
            @SerializedName("Algorithm")
            private String algorithm;

            /**
             * Number of hashes per second the equipment can reach
             */
            @SerializedName("HashesPerSecond")
            private String hashesPerSecond;

            /**
             * Cost of the equipment
             */
            @SerializedName("Cost")
            private double cost;

            /**
             * Currency of the cost
             */
            @SerializedName("Currency")
            private String currency;

            /**
             * Type of the equipment
             */
            @SerializedName("EquipmentType")
            private String equipmentType;

            /**
             * Power consumption of the equipment
             */
            @SerializedName("PowerConsumption")
            private String powerConsumption;

            /**
             * Currencies available to be mined with the equipment
             */
            @SerializedName("CurrenciesAvailable")
            private String currenciesAvailable;

            /**
             * Logos of the currencies available for mining
             */
            @SerializedName("CurrenciesAvailableLogo")
            private String currenciesAvailableLogo;

            /**
             * Currencies available to be mined with the equipment
             */
            @SerializedName("CurrenciesAvailableName")
            private String currenciesAvailableName;

            @Override
            public String toString() {
                return String.format("%s - %s", company, name);
            }

            /**
             * {@link Equip#id}
             */
            public int getId() {
                return id;
            }

            /**
             * {@link Equip#parentID}
             */
            public int getParentID() {
                return parentID;
            }

            /**
             * {@link Equip#company}
             */
            public String getCompany() {
                return company;
            }

            /**
             * {@link Equip#url}
             */
            public String getUrl() {
                return url;
            }

            /**
             * {@link Equip#logoURL}
             */
            public String getLogoURL() {
                return logoURL;
            }

            /**
             * {@link Equip#name}
             */
            public String getName() {
                return name;
            }

            /**
             * {@link Equip#recommended}
             */
            public boolean isRecommended() {
                return recommended;
            }

            /**
             * {@link Equip#sponsored}
             */
            public boolean isSponsored() {
                return sponsored;
            }

            /**
             * {@link Equip#affiliateURL}
             */
            public String getAffiliateURL() {
                return affiliateURL;
            }

            /**
             * {@link Equip#algorithm}
             */
            public String getAlgorithm() {
                return algorithm;
            }

            /**
             * {@link Equip#hashesPerSecond}
             */
            public String getHashesPerSecond() {
                return hashesPerSecond;
            }

            /**
             * {@link Equip#cost}
             */
            public double getCost() {
                return cost;
            }

            /**
             * {@link Equip#currency}
             */
            public String getCurrency() {
                return currency;
            }

            /**
             * {@link Equip#equipmentType}
             */
            public String getEquipmentType() {
                return equipmentType;
            }

            /**
             * {@link Equip#powerConsumption}
             */
            public String getPowerConsumption() {
                return powerConsumption;
            }

            /**
             * {@link Equip#currenciesAvailable}
             */
            public String getCurrenciesAvailable() {
                return currenciesAvailable;
            }

            /**
             * {@link Equip#currenciesAvailableLogo}
             */
            public String getCurrenciesAvailableLogo() {
                return currenciesAvailableLogo;
            }

            /**
             * {@link Equip#currenciesAvailableName}
             */
            public String getCurrenciesAvailableName() {
                return currenciesAvailableName;
            }
        }
    }

    /**
     * Represents a cryptocurrency
     */
    public class Coin {
        /**
         * The price of the coin in USD
         */
        @SerializedName("PriceUSD")
        private double priceUSD;

        /**
         * The symbol of the coin
         */
        @SerializedName("Symbol")
        private String symbol;

        /**
         * Difficulty adjustment of the coin
         */
        @SerializedName("DifficultyAdjustment")
        private String difficultyAdjustment;

        /**
         * Block reward reduction of the coin
         */
        @SerializedName("BlockRewardReduction")
        private String blockRewardReduction;

        /**
         * Current block number of the coin
         */
        @SerializedName("BlockNumber")
        private int blockNumber;

        /**
         * Current block time of the coin
         */
        @SerializedName("BlockTime")
        private double blockTime;

        /**
         * Net hashes per second of the coin
         */
        @SerializedName("NetHashesPerSecond")
        private double netHashesPerSecond;

        /**
         * The total number of coins mined
         */
        @SerializedName("TotalCoinsMined")
        private double totalCoinsMined;

        /**
         * Previous total coins mined
         */
        @SerializedName("PreviousTotalCoinsMined")
        private double previousTotalCoinsMined;

        /**
         * Current block reward of the coin
         */
        @SerializedName("BlockReward")
        private double blockReward;

        @Override
        public String toString() {
            return String.format("%.1E H/s", netHashesPerSecond);
        }

        /**
         * {@link Coin#priceUSD}
         */
        public double getPriceUSD() {
            return priceUSD;
        }

        /**
         * {@link Coin#symbol}
         */
        public String getSymbol() {
            return symbol;
        }

        /**
         * {@link Coin#difficultyAdjustment}
         */
        public String getDifficultyAdjustment() {
            return difficultyAdjustment;
        }

        /**
         * {@link Coin#blockRewardReduction}
         */
        public String getBlockRewardReduction() {
            return blockRewardReduction;
        }

        /**
         * {@link Coin#blockNumber}
         */
        public int getBlockNumber() {
            return blockNumber;
        }

        /**
         * {@link Coin#blockTime}
         */
        public double getBlockTime() {
            return blockTime;
        }

        /**
         * {@link Coin#netHashesPerSecond}
         */
        public double getNetHashesPerSecond() {
            return netHashesPerSecond;
        }

        /**
         * {@link Coin#totalCoinsMined}
         */
        public double getTotalCoinsMined() {
            return totalCoinsMined;
        }

        /**
         * {@link Coin#previousTotalCoinsMined}
         */
        public double getPreviousTotalCoinsMined() {
            return previousTotalCoinsMined;
        }

        /**
         * {@link Coin#blockReward}
         */
        public double getBlockReward() {
            return blockReward;
        }
    }
}
