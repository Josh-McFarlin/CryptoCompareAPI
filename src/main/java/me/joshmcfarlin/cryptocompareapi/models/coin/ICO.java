package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

/**
 * Represents ICO data
 */
public class ICO {
	/**
	 * Status of the ICO
	 */
	@SerializedName("Status")
	private String status;
	/**
	 * Status of the white-paper
	 */
	@SerializedName("WhitePaper")
	private String whitePaper;

	/**
	 * {@link ICO#status}
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * {@link ICO#whitePaper}
	 */
	public String getWhitePaper() {
		return whitePaper;
	}
}