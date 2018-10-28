package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents social info from CryptoCompare
 */
public class CryptoCompare {
	/**
	 * Represents similar items
	 */
	@SerializedName("SimilarItems")
	private List<SimilarItem> similarItems;

	/**
	 * Represents CryptopianFollowers
	 */
	@SerializedName("CryptopianFollowers")
	private List<CryptopianFollowers> cryptopianFollowers;

	/**
	 * The number of points on CryptoCompare
	 */
	@SerializedName("Points")
	private int points;

	/**
	 * The number of followers on CryptoCompare
	 */
	@SerializedName("Followers")
	private int followers;

	/**
	 * The number of posts on CryptoCompare
	 */
	@SerializedName("Posts")
	private int posts;

	/**
	 * The number of comments on CryptoCompare
	 */
	@SerializedName("Comments")
	private int comments;

	/**
	 * Represents page views on CryptoCompare
	 */
	@SerializedName("PageViewsSplit")
	private PageViewsSplit pageViewsSplit;

	/**
	 * The number of page views CryptoCompare
	 */
	@SerializedName("PageViews")
	private int pageViews;

	/**
	 * {@link CryptoCompare#similarItems}
	 */
	public List<SimilarItem> getSimilarItems() {
		return similarItems;
	}

	/**
	 * {@link CryptoCompare#cryptopianFollowers}
	 */
	public List<CryptopianFollowers> getCryptopianFollowers() {
		return cryptopianFollowers;
	}

	/**
	 * {@link CryptoCompare#points}
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * {@link CryptoCompare#followers}
	 */
	public int getFollowers() {
		return followers;
	}

	/**
	 * {@link CryptoCompare#posts}
	 */
	public int getPosts() {
		return posts;
	}

	/**
	 * {@link CryptoCompare#comments}
	 */
	public int getComments() {
		return comments;
	}

	/**
	 * {@link CryptoCompare#pageViewsSplit}
	 */
	public PageViewsSplit getPageViewsSplit() {
		return pageViewsSplit;
	}

	/**
	 * {@link CryptoCompare#pageViews}
	 */
	public int getPageViews() {
		return pageViews;
	}

}
