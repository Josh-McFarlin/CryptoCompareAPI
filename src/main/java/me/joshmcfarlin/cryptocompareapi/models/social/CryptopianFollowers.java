package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents CryptopianFollowers
 */
public class CryptopianFollowers {
	/**
	 * The follower's id
	 */
	@SerializedName("Id")
	private int id;

	/**
	 * The follower's name
	 */
	@SerializedName("Name")
	private String name;

	/**
	 * The follower's image url
	 */
	@SerializedName("ImageUrl")
	private String imageUrl;

	/**
	 * The follower's url
	 */
	@SerializedName("Url")
	private String url;

	/**
	 * The follower's type
	 */
	@SerializedName("Type")
	private String type;

	/**
	 * {@link CryptopianFollowers#id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * {@link CryptopianFollowers#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link CryptopianFollowers#imageUrl}
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * {@link CryptopianFollowers#url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * {@link CryptopianFollowers#type}
	 */
	public String getType() {
		return type;
	}
}