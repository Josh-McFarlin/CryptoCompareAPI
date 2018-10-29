package me.joshmcfarlin.cryptocompareapi.models.news;

/**
 * Represents a news provider on CryptoCompare's website
 */
public class NewsProvider {
	/**
	 * Key name used by CryptoCompare
	 */
	private String key;

	/**
	 * Name provided on CryptoCompare's website
	 */
	private String name;

	/**
	 * Language used by news provided
	 */
	private String lang;

	/**
	 * Url to image representing news provider
	 */
	private String img;

	@Override
	public String toString() {
		return String.format("Key: %s, Name: %s, Lang: %s", key, name, lang);
	}

	/**
	 * {@link NewsProvider#key}
	 */
	public String getKey() {
		return key;
	}

	/**
	 * {@link NewsProvider#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link NewsProvider#lang}
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * {@link NewsProvider#img}
	 */
	public String getImg() {
		return img;
	}
}
