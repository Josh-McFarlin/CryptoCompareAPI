package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents PageViewsSplit
 */
public class PageViewsSplit {
	/**
	 * The int representing overview
	 */
	@SerializedName("Overview")
	private int overview;

	/**
	 * The int representing markets
	 */
	@SerializedName("Markets")
	private int markets;

	/**
	 * The int representing analysis
	 */
	@SerializedName("Analysis")
	private int analysis;

	/**
	 * The int representing charts
	 */
	@SerializedName("Charts")
	private int charts;

	/**
	 * The int representing trades
	 */
	@SerializedName("Trades")
	private int trades;

	/**
	 * The int representing the orderbook
	 */
	@SerializedName("Orderbook")
	private int orderbook;

	/**
	 * The int representing the form
	 */
	@SerializedName("Forum")
	private int forum;

	/**
	 * The int representing the influence
	 */
	@SerializedName("Influence")
	private int influence;

	/**
	 * {@link PageViewsSplit#overview}
	 */
	public int getOverview() {
		return overview;
	}

	/**
	 * {@link PageViewsSplit#markets}
	 */
	public int getMarkets() {
		return markets;
	}

	/**
	 * {@link PageViewsSplit#analysis}
	 */
	public int getAnalysis() {
		return analysis;
	}

	/**
	 * {@link PageViewsSplit#charts}
	 */
	public int getCharts() {
		return charts;
	}

	/**
	 * {@link PageViewsSplit#trades}
	 */
	public int getTrades() {
		return trades;
	}

	/**
	 * {@link PageViewsSplit#orderbook}
	 */
	public int getOrderbook() {
		return orderbook;
	}

	/**
	 * {@link PageViewsSplit#forum}
	 */
	public int getForum() {
		return forum;
	}

	/**
	 * {@link PageViewsSplit#influence}
	 */
	public int getInfluence() {
		return influence;
	}
}
