package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

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

}