package me.joshmcfarlin.cryptocompareapi.models.mining;

import com.google.gson.annotations.SerializedName;

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
