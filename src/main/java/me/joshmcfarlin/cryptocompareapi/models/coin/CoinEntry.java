package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

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