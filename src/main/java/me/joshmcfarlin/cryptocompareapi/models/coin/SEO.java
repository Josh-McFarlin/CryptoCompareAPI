package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

/**
 * Represents SEO data
 */
public class SEO {
	/**
	 * The page title on CryptoCompare
	 */
	@SerializedName("PageTitle")
	private String pageTitle;

	/**
	 * The page description on CryptoCompare
	 */
	@SerializedName("PageDescription")
	private String pageDescription;

	/**
	 * The base URL
	 */
	@SerializedName("BaseUrl")
	private String baseUrl;

	/**
	 * The image base url
	 */
	@SerializedName("BaseImageUrl")
	private String baseImageUrl;

	/**
	 * The remaining image URL
	 */
	@SerializedName("OgImageUrl")
	private String ogImageUrl;

	/**
	 * The image width
	 */
	@SerializedName("OgImageWidth")
	private double ogImageWidth;

	/**
	 * The image height
	 */
	@SerializedName("OgImageHeight")
	private double ogImageHeight;

	/**
	 * {@link SEO#pageTitle}
	 */
	public String getPageTitle() {
		return pageTitle;
	}

	/**
	 * {@link SEO#pageDescription}
	 */
	public String getPageDescription() {
		return pageDescription;
	}

	/**
	 * {@link SEO#baseUrl}
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * {@link SEO#baseImageUrl}
	 */
	public String getBaseImageUrl() {
		return baseImageUrl;
	}

	/**
	 * {@link SEO#ogImageUrl}
	 */
	public String getOgImageUrl() {
		return ogImageUrl;
	}

	/**
	 * {@link SEO#ogImageWidth}
	 */
	public double getOgImageWidth() {
		return ogImageWidth;
	}

	/**
	 * {@link SEO#ogImageHeight}
	 */
	public double getOgImageHeight() {
		return ogImageHeight;
	}
}
