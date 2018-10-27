package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
	private CoinData coinData;

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
	 * {@link PairSnapshot#coinData}
	 */
	public CoinData getData() {
		return coinData;
	}

}

