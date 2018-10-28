package me.joshmcfarlin.cryptocompareapi.models.exchanges;

import java.util.List;

/**
 * Represents a cryptocurrency
 */
public class Coin {
	/**
	 * A list of trading pairs
	 */
	private List<String> tradingPairs;

	/**
	 * Creates a coin from a list of trading pairs
	 * @param tradingPairs The trading pairs to set
	 */
	Coin(List<String> tradingPairs) {
		if (tradingPairs != null && !tradingPairs.isEmpty()) {
			this.tradingPairs = tradingPairs;
		}
	}

	/**
	 * {@link Coin#tradingPairs}
	 */
	public List<String> getTradingPairs() {
		return tradingPairs;
	}
}