package me.joshmcfarlin.cryptocompareapi.models.mining;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

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

}
