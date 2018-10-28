package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents social data from Reddit
 */
public class Reddit {
	/**
	 * The number of posts per hour on Reddit
	 */
	@SerializedName("posts_per_hour")
	private double postsPerHour;

	/**
	 * The number of comments per hour on Reddit
	 */
	@SerializedName("comments_per_hour")
	private double commentsPerHour;

	/**
	 * The number of posts per day on Reddit
	 */
	@SerializedName("posts_per_day")
	private double postsPerDay;

	/**
	 * The number of comments per day on Reddit
	 */
	@SerializedName("comments_per_day")
	private double commentsPerDay;

	/**
	 * The name of the subreddit
	 */
	private String name;

	/**
	 * The link to the subreddit
	 */
	private String link;

	/**
	 * The number of active users on the subreddit
	 */
	@SerializedName("active_users")
	private int activeUsers;

	/**
	 * When the subreddit was created
	 */
	@SerializedName("community_creation")
	private int communityCreation;

	/**
	 * The number of users subscribed to the subreddit
	 */
	private int subscribers;

	/**
	 * The number of points
	 */
	@SerializedName("Points")
	private int points;

	/**
	 * {@link Reddit#postsPerHour}
	 */
	public double getPostsPerHour() {
		return postsPerHour;
	}

	/**
	 * {@link Reddit#commentsPerHour}
	 */
	public double getCommentsPerHour() {
		return commentsPerHour;
	}

	/**
	 * {@link Reddit#postsPerDay}
	 */
	public double getPostsPerDay() {
		return postsPerDay;
	}

	/**
	 * {@link Reddit#commentsPerDay}
	 */
	public double getCommentsPerDay() {
		return commentsPerDay;
	}

	/**
	 * {@link Reddit#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link Reddit#link}
	 */
	public String getLink() {
		return link;
	}

	/**
	 * {@link Reddit#activeUsers}
	 */
	public int getActiveUsers() {
		return activeUsers;
	}

	/**
	 * {@link Reddit#communityCreation}
	 */
	public int getCommunityCreation() {
		return communityCreation;
	}

	/**
	 * {@link Reddit#subscribers}
	 */
	public int getSubscribers() {
		return subscribers;
	}

	/**
	 * {@link Reddit#points}
	 */
	public int getPoints() {
		return points;
	}
}
