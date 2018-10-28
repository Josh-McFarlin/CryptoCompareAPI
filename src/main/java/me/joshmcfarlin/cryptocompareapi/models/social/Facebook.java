package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents social data from Facebook
 */
public class Facebook {
	/**
	 * The number of likes on Facebook
	 */
	private int likes;

	/**
	 * The link to the Facebook page
	 */
	private String link;

	/**
	 * If the Facebook page is closed
	 */
	@SerializedName("is_closed")
	private boolean isClosed;

	/**
	 * The number of people talking about the item
	 */
	@SerializedName("talking_about")
	private int talkingAbout;

	/**
	 * The name of the Facebook page
	 */
	private String name;

	/**
	 * The number of points
	 */
	@SerializedName("Points")
	private int points;

	/**
	 * {@link Facebook#likes}
	 */
	public int getLikes() {
		return likes;
	}

	/**
	 * {@link Facebook#link}
	 */
	public String getLink() {
		return link;
	}

	/**
	 * {@link Facebook#isClosed}
	 */
	public boolean isClosed() {
		return isClosed;
	}

	/**
	 * {@link Facebook#talkingAbout}
	 */
	public int getTalkingAbout() {
		return talkingAbout;
	}

	/**
	 * {@link Facebook#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link Facebook#points}
	 */
	public int getPoints() {
		return points;
	}
}
