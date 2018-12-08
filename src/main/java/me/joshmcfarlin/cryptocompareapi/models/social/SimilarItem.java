package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents similar items on CryptoCompare
 */
public class SimilarItem {
	/**
	 * The item's id
	 */
	@SerializedName("Id")
	private int id;

	/**
	 * The item's short name
	 */
	@SerializedName("Name")
	private String name;

	/**
	 * The item's full name
	 */
	@SerializedName("FullName")
	private String fullName;

	/**
	 * The item's image url
	 */
	@SerializedName("ImageUrl")
	private String imageUrl;

	/**
	 * The item's url
	 */
	@SerializedName("Url")
	private String url;

	/**
	 * An int representing the item's following type
	 */
	@SerializedName("FollowingType")
	private int followingType;

	/**
	 * {@link SimilarItem#id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * {@link SimilarItem#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link SimilarItem#fullName}
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * {@link SimilarItem#imageUrl}
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * {@link SimilarItem#url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * {@link SimilarItem#followingType}
	 */
	public int getFollowingType() {
		return followingType;
	}
}