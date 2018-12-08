package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents data about a repository's source
 */
public class Source {
	/**
	 * The name of the repository's source
	 */
	@SerializedName("Name")
	private String name;

	/**
	 * The url to the repository's source
	 */
	@SerializedName("Url")
	private String url;

	/**
	 * The internal id of the repository's source
	 */
	@SerializedName("InternalId")
	private int internalId;

	/**
	 * {@link Source#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link Source#url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * {@link Source#internalId}
	 */
	public int getInternalId() {
		return internalId;
	}
}
