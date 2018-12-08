package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a coin sponsor
 */
public class Sponsor {
	/**
	 * The text displayed on the website at the top
	 */
	@SerializedName("TextTop")
	private String textTop;

	/**
	 * The URL to the sponsor
	 */
	@SerializedName("Link")
	private String link;

	/**
	 * The image URL for the sponsor
	 */
	@SerializedName("ImageUrl")
	private String imageUrl;

	/**
	 * {@link Sponsor#textTop}
	 */
	public String getTextTop() {
		return textTop;
	}

	/**
	 * {@link Sponsor#link}
	 */
	public String getLink() {
		return link;
	}

	/**
	 * {@link Sponsor#imageUrl}
	 */
	public String getImageUrl() {
		return imageUrl;
	}
}