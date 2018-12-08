package me.joshmcfarlin.cryptocompareapi.models.exchanges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a map of exchanges
 */
public class ExchangeList {
	/**
	 * A map of all exchanges
	 */
	private Map<String, Exchange> exchanges = new HashMap<>();

	/**
	 * Creates an ExchangeList from a map of exchanges
	 * @param map A map of exchanges
	 */
	public ExchangeList(Map<String, Map<String, List<String>>> map) {
		map.forEach((key, val) -> {
			Exchange e = new Exchange(val);
			this.exchanges.put(key, e);
		});
	}

	/**
	 * {@link ExchangeList#exchanges}
	 */
	public Map<String, Exchange> getExchanges() {
		return exchanges;
	}
}