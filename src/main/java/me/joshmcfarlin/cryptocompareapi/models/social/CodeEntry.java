package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents data about a code repository
 */
public class CodeEntry {
	/**
	 * When the repository was created
	 */
	@SerializedName("created_at")
	private int createdAt;

	/**
	 * The number of open issues on the repository
	 */
	@SerializedName("open_total_issues")
	private int openTotalIssues;

	/**
	 * The repository's parent
	 */
	@SerializedName("Parent")
	private Parent parent;

	/**
	 * The size of the repository
	 */
	private int size;

	/**
	 * The total number of closed issues on the repository
	 */
	@SerializedName("closed_total_issues")
	private int closedTotalIssues;

	/**
	 * The number of stars on the repository
	 */
	private int stars;

	/**
	 * When the code repository was last updated
	 */
	@SerializedName("last_update")
	private int lastUpdate;

	/**
	 * The number of forks of the repository
	 */
	private int forks;

	/**
	 * The url to the repository
	 */
	private String url;

	/**
	 * The number of closed issues on the repository
	 */
	@SerializedName("closed_issues")
	private int closedIssues;

	/**
	 * The number of closed pull issues on the repository
	 */
	@SerializedName("closed_pull_issues")
	private int closedPullIssues;

	/**
	 * If the code repository is a fork of another repository
	 */
	private boolean fork;

	/**
	 * When the repository was last pushed code
	 */
	@SerializedName("last_push")
	private int lastPush;

	/**
	 * Represents the source
	 */
	private Source source;

	/**
	 * The number of open pull issues on the repository
	 */
	@SerializedName("open_pull_issues")
	private int openPullIssues;

	/**
	 * The language of the repository
	 */
	private String language;

	/**
	 * The number of subscribers to the repository
	 */
	private int subscribers;

	/**
	 * The number of open issues on the repository
	 */
	@SerializedName("open_issues")
	private int openIssues;

	/**
	 * {@link CodeEntry#createdAt}
	 */
	public int getCreatedAt() {
		return createdAt;
	}

	/**
	 * {@link CodeEntry#openTotalIssues}
	 */
	public int getOpenTotalIssues() {
		return openTotalIssues;
	}

	/**
	 * {@link CodeEntry#parent}
	 */
	public Parent getParent() {
		return parent;
	}

	/**
	 * {@link CodeEntry#size}
	 */
	public int getSize() {
		return size;
	}

	/**
	 * {@link CodeEntry#closedTotalIssues}
	 */
	public int getClosedTotalIssues() {
		return closedTotalIssues;
	}

	/**
	 * {@link CodeEntry#stars}
	 */
	public int getStars() {
		return stars;
	}

	/**
	 * {@link CodeEntry#lastUpdate}
	 */
	public int getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * {@link CodeEntry#forks}
	 */
	public int getForks() {
		return forks;
	}

	/**
	 * {@link CodeEntry#url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * {@link CodeEntry#closedIssues}
	 */
	public int getClosedIssues() {
		return closedIssues;
	}

	/**
	 * {@link CodeEntry#closedPullIssues}
	 */
	public int getClosedPullIssues() {
		return closedPullIssues;
	}

	/**
	 * {@link CodeEntry#fork}
	 */
	public boolean isFork() {
		return fork;
	}

	/**
	 * {@link CodeEntry#lastPush}
	 */
	public int getLastPush() {
		return lastPush;
	}

	/**
	 * {@link CodeEntry#source}
	 */
	public Source getSource() {
		return source;
	}

	/**
	 * {@link CodeEntry#openPullIssues}
	 */
	public int getOpenPullIssues() {
		return openPullIssues;
	}

	/**
	 * {@link CodeEntry#language}
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * {@link CodeEntry#subscribers}
	 */
	public int getSubscribers() {
		return subscribers;
	}

	/**
	 * {@link CodeEntry#openIssues}
	 */
	public int getOpenIssues() {
		return openIssues;
	}

}