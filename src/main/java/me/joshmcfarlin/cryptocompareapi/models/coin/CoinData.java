package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents data about the coin
 */
public class CoinData {
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
	 * {@link CoinData#algorithm}
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * {@link CoinData#proofType}
	 */
	public String getProofType() {
		return proofType;
	}

	/**
	 * {@link CoinData#blockNumber}
	 */
	public int getBlockNumber() {
		return blockNumber;
	}

	/**
	 * {@link CoinData#netHashesPerSecond}
	 */
	public double getNetHashesPerSecond() {
		return netHashesPerSecond;
	}

	/**
	 * {@link CoinData#totalCoinsMined}
	 */
	public double getTotalCoinsMined() {
		return totalCoinsMined;
	}

	/**
	 * {@link CoinData#blockReward}
	 */
	public double getBlockReward() {
		return blockReward;
	}

	/**
	 * {@link CoinData#aggregatedData}
	 */
	public AggregatedData getAggregatedData() {
		return aggregatedData;
	}

	/**
	 * {@link CoinData#exchanges}
	 */
	public List<Exchange> getExchanges() {
		return exchanges;
	}

}