package me.joshmcfarlin.cryptocompareapi.models.news;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a news story on CryptoCompare's website
 */
public class NewsStory {
	/**
	 * News story ID on CryptoCompare's website
	 */
	private int id;

	/**
	 * Url to news story on provider's website
	 */
	private String guid;

	/**
	 * Unix time the story was published
	 */
	@SerializedName("published_on")
	private int publishedOn;

	/**
	 * Image url
	 */
	@SerializedName("imageurl")
	private String imageUrl;

	/**
	 * Title of the news story
	 */
	private String title;

	/**
	 * News story url on CryptoCompare's website
	 */
	private String url;

	/**
	 * Source of the news story
	 */
	private String source;

	/**
	 * Body of the news story
	 */
	private String body;

	/**
	 * Tags provided with the news story
	 */
	private String tags;

	/**
	 * The language the news story is written in
	 */
	private String lang;

	/**
	 * The provider of the news article
	 */
	@SerializedName("source_info")
	private ShortNewsProvider provider;

	@Override
	public String toString() {
		return String.format("%s: %s", id, title);
	}

	/**
	 * {@link NewsStory#id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * {@link NewsStory#guid}
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * {@link NewsStory#publishedOn}
	 */
	public int getPublishedOn() {
		return publishedOn;
	}

	/**
	 * {@link NewsStory#imageUrl}
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * {@link NewsStory#title}
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * {@link NewsStory#url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * {@link NewsStory#source}
	 */
	public String getSource() {
		return source;
	}

	/**
	 * {@link NewsStory#body}
	 */
	public String getBody() {
		return body;
	}

	/**
	 * {@link NewsStory#tags}
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * {@link NewsStory#lang}
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * {@link NewsStory#provider}
	 */
	public ShortNewsProvider getProvider() {
		return provider;
	}

}
