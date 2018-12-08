package me.joshmcfarlin.cryptocompareapi.models.exchanges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a cryptocurrency exchange
 */
public class Exchange {
	/**
	 * A map of coins listed by the exchange
	 */
	private Map<String, Coin> coins = new HashMap<>();

	/**
	 * Creates an exchange from a list of coins
	 * @param coins A List of coins traded on the exchange
	 */
	Exchange(Map<String, List<String>> coins) {
		coins.forEach((coin, pair) -> {
			if (pair != null && !pair.isEmpty()) {
				Coin c = new Coin(pair);
				this.coins.put(coin, c);
			}
		});
	}

	/**
	 * {@link Exchange#coins}
	 */
	public Map<String, Coin> getCoins() {
		return coins;
	}
}
