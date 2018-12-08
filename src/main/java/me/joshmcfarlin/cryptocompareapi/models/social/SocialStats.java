package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents social statistics provided by the CryptoCompare API
 */
public class SocialStats {
	/**
	 * Indicates request success
	 */
	@SerializedName("Response")
	private String response;

	/**
	 * Message provided in API response
	 */
	@SerializedName("Message")
	private String message;

	/**
	 * Indicates HTML request response type
	 */
	@SerializedName("Type")
	private int type;

	/**
	 * Social data returned by the API
	 */
	@SerializedName("Data")
	private Data data;

	/**
	 * {@link SocialStats#response}
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * {@link SocialStats#message}
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * {@link SocialStats#type}
	 */
	public int getType() {
		return type;
	}

	/**
	 * {@link SocialStats#data}
	 */
	public Data getData() {
		return data;
	}

}
