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
 * Contains methods for requesting information about cryptocurrency mining
 * @author joshuamcfarlin
 * @version 1
 */
public class Mining {
    /**
     * Gets information about recent mining contracts
     * @return Contracts A class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Contracts getContracts() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON(new URL("https://www.cryptocompare.com/api/data/miningcontracts/"), CallTypes.OTHER);
        return new Gson().fromJson(r, Contracts.class);
    }

    /**
     * Gets information about different mining equipment
     * @return Equipment A class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Equipment getEquipment() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON(new URL("https://www.cryptocompare.com/api/data/miningequipment/"), CallTypes.OTHER);
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
        public String response;
        /**
         * Message provided by the API
         */
        @SerializedName("Message")
        public String message;
        /**
         * Mining data
         */
        @SerializedName("MiningData")
        public Map<Integer, Contract> contracts;
        /**
         * Coin data
         */
        @SerializedName("CoinData")
        public Map<String, Coin> coins;
        /**
         * Response type
         */
        @SerializedName("Type")
        public int type;

        /**
         * Represents a mining contract
         */
        public class Contract {
            /**
             * ID of the equipment
             */
            @SerializedName("Id")
            public int id;
            /**
             * Parent ID of the equipment
             */
            @SerializedName("ParentId")
            public int parentID;
            /**
             * Equipment company
             */
            @SerializedName("Company")
            public String company;
            /**
             * Url
             */
            @SerializedName("Url")
            public String url;
            /**
             * Url of the logo
             */
            @SerializedName("LogoUrl")
            public String logoURL;
            /**
             * Equipment name
             */
            @SerializedName("Name")
            public String name;
            /**
             * Represents if recommended equipment
             */
            @SerializedName("Recommended")
            public boolean recommended;
            /**
             * Represents if sponsored equipment
             */
            @SerializedName("Sponsored")
            public boolean sponsored;
            /**
             * Affiliate url
             */
            @SerializedName("AffiliateURL")
            public String affiliateURL;
            /**
             * Equipment algorithm
             */
            @SerializedName("Algorithm")
            public String algorithm;
            /**
             * Number of hashes per second the equipment can reach
             */
            @SerializedName("HashesPerSecond")
            public String hashesPerSecond;
            /**
             * Cost of the equipment
             */
            @SerializedName("Cost")
            public double cost;
            /**
             * Currency of the cost
             */
            @SerializedName("Currency")
            public String currency;
            /**
             * Cost of the fee
             */
            @SerializedName("FeeValue")
            public double feeValue;
            /**
             * Currency of the fee
             */
            @SerializedName("FeeValueCurrency")
            public String feeValueCurrency;
            /**
             * Length of the contract
             */
            @SerializedName("ContractLength")
            public String contractLength;
            /**
             * Currencies available to be mined with the equipment
             */
            @SerializedName("CurrenciesAvailable")
            public String currenciesAvailable;
            /**
             * Logos of the currencies available for mining
             */
            @SerializedName("CurrenciesAvailableLogo")
            public String currenciesAvailableLogo;
            /**
             * Currencies available to be mined with the equipment
             */
            @SerializedName("CurrenciesAvailableName")
            public String currenciesAvailableName;

            @Override
            public String toString() {
                return String.format("%s - %s", company, name);
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
        public String response;
        /**
         * Message provided by the API
         */
        @SerializedName("Message")
        public String message;
        /**
         * Mining data
         */
        @SerializedName("MiningData")
        public Map<Integer, Equip> equipment;
        /**
         * Coin data
         */
        @SerializedName("CoinData")
        public Map<String, Coin> coins;
        /**
         * Response type
         */
        @SerializedName("Type")
        public int type;

        public class Equip {
            /**
             * ID of the equipment
             */
            @SerializedName("Id")
            public int id;
            /**
             * Parent ID of the equipment
             */
            @SerializedName("ParentId")
            public int parentID;
            /**
             * Equipment company
             */
            @SerializedName("Company")
            public String company;
            /**
             * Url
             */
            @SerializedName("Url")
            public String url;
            /**
             * Url of the logo
             */
            @SerializedName("LogoUrl")
            public String logoURL;
            /**
             * Equipment name
             */
            @SerializedName("Name")
            public String name;
            /**
             * Represents if recommended equipment
             */
            @SerializedName("Recommended")
            public boolean recommended;
            /**
             * Represents if sponsored equipment
             */
            @SerializedName("Sponsored")
            public boolean sponsored;
            /**
             * Affiliate url
             */
            @SerializedName("AffiliateURL")
            public String affiliateURL;
            /**
             * Equipment algorithm
             */
            @SerializedName("Algorithm")
            public String algorithm;
            /**
             * Number of hashes per second the equipment can reach
             */
            @SerializedName("HashesPerSecond")
            public String hashesPerSecond;
            /**
             * Cost of the equipment
             */
            @SerializedName("Cost")
            public double cost;
            /**
             * Currency of the cost
             */
            @SerializedName("Currency")
            public String currency;
            /**
             * Type of the equipment
             */
            @SerializedName("EquipmentType")
            public String equipmentType;
            /**
             * Power consumption of the equipment
             */
            @SerializedName("PowerConsumption")
            public String powerConsumption;
            /**
             * Currencies available to be mined with the equipment
             */
            @SerializedName("CurrenciesAvailable")
            public String currenciesAvailable;
            /**
             * Logos of the currencies available for mining
             */
            @SerializedName("CurrenciesAvailableLogo")
            public String currenciesAvailableLogo;
            /**
             * Currencies available to be mined with the equipment
             */
            @SerializedName("CurrenciesAvailableName")
            public String currenciesAvailableName;

            @Override
            public String toString() {
                return String.format("%s - %s", company, name);
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
        public double priceUSD;
        /**
         * The symbol of the coin
         */
        @SerializedName("Symbol")
        public String symbol;
        /**
         * Difficulty adjustment of the coin
         */
        @SerializedName("DifficultyAdjustment")
        public String difficultyAdjustment;
        /**
         * Block reward reduction of the coin
         */
        @SerializedName("BlockRewardReduction")
        public String blockRewardReduction;
        /**
         * Current block number of the coin
         */
        @SerializedName("BlockNumber")
        public int blockNumber;
        /**
         * Current block time of the coin
         */
        @SerializedName("BlockTime")
        public double blockTime;
        /**
         * Net hashes per second of the coin
         */
        @SerializedName("NetHashesPerSecond")
        public double netHashesPerSecond;
        /**
         * The total number of coins mined
         */
        @SerializedName("TotalCoinsMined")
        public double totalCoinsMined;
        /**
         * Previous total coins mined
         */
        @SerializedName("PreviousTotalCoinsMined")
        public double previousTotalCoinsMined;
        /**
         * Current block reward of the coin
         */
        @SerializedName("BlockReward")
        public double blockReward;

        @Override
        public String toString() {
            return String.format("%.1E H/s", netHashesPerSecond);
        }
    }
}
