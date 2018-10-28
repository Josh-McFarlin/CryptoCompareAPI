package me.joshmcfarlin.cryptocompareapi.models.news;

import me.joshmcfarlin.cryptocompareapi.News;

/**
 * Represents information about a news provider
 */
public class ShortNewsProvider {
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
		return String.format("Name: %s, Lang: %s", name, lang);
	}

	/**
	 * {@link News.NewsStory.ShortNewsProvider#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link News.NewsStory.ShortNewsProvider#lang}
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * {@link News.NewsStory.ShortNewsProvider#img}
	 */
	public String getImg() {
		return img;
	}
}