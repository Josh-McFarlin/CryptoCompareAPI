package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents data about a repository's parent
 */
public class Parent {
	/**
	 * The name of the repository's parent
	 */
	@SerializedName("Name")
	private String name;

	/**
	 * The url to the repository's parent
	 */
	@SerializedName("Url")
	private String url;

	/**
	 * The internal id of the repository's parent
	 */
	@SerializedName("InternalId")
	private int internalId;

	/**
	 * {@link Parent#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link Parent#url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * {@link Parent#internalId}
	 */
	public int getInternalId() {
		return internalId;
	}
}