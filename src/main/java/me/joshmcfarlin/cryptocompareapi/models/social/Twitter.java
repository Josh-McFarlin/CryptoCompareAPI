package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents social data from Twitter
 */
public class Twitter {
	/**
	 * The number of followers on Twitter
	 */
	private int following;

	/**
	 * When the account was created
	 */
	@SerializedName("account_creation")
	private int accountCreation;

	/**
	 * The Twitter account's name
	 */
	private String name;

	/**
	 * The number of lists
	 */
	private int lists;

	/**
	 * The number of statuses
	 */
	private int statuses;

	/**
	 * The number of favourites
	 */
	private int favourites;

	/**
	 * The number of followers
	 */
	private int followers;

	/**
	 * The account's link
	 */
	private String link;

	/**
	 * The number of points
	 */
	@SerializedName("Points")
	private int points;

	/**
	 * {@link Twitter#following}
	 */
	public int getFollowing() {
		return following;
	}

	/**
	 * {@link Twitter#accountCreation}
	 */
	public int getAccountCreation() {
		return accountCreation;
	}

	/**
	 * {@link Twitter#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link Twitter#lists}
	 */
	public int getLists() {
		return lists;
	}

	/**
	 * {@link Twitter#statuses}
	 */
	public int getStatuses() {
		return statuses;
	}

	/**
	 * {@link Twitter#favourites}
	 */
	public int getFavourites() {
		return favourites;
	}

	/**
	 * {@link Twitter#followers}
	 */
	public int getFollowers() {
		return followers;
	}

	/**
	 * {@link Twitter#link}
	 */
	public String getLink() {
		return link;
	}

	/**
	 * {@link Twitter#points}
	 */
	public int getPoints() {
		return points;
	}
}