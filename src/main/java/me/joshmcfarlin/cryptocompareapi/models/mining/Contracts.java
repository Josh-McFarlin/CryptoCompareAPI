package me.joshmcfarlin.cryptocompareapi.models.mining;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

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
}
