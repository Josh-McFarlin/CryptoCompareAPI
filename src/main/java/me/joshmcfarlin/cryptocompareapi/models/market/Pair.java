package me.joshmcfarlin.cryptocompareapi.models.market;

/**
 * Represents a trading pair
 */
public class Pair {
	/**
	 * Exchange the pair is being traded on
	 */
	private String exchange;

	/**
	 * The from symbol in the pair
	 */
	private String fromSymbol;

	/**
	 * The to symbol in the pair
	 */
	private String toSymbol;

	/**
	 * The 24 hour volume
	 */
	private double volume24h;

	/**
	 * The 24 hour volume to
	 */
	private double volume24hTo;

	@Override
	public String toString() {
		return String.format("%s-%s", fromSymbol, toSymbol);
	}

	/**
	 * {@link Pair#exchange}
	 */
	public String getExchange() {
		return exchange;
	}

	/**
	 * {@link Pair#fromSymbol}
	 */
	public String getFromSymbol() {
		return fromSymbol;
	}

	/**
	 * {@link Pair#toSymbol}
	 */
	public String getToSymbol() {
		return toSymbol;
	}

	/**
	 * {@link Pair#volume24h}
	 */
	public double getVolume24h() {
		return volume24h;
	}

	/**
	 * {@link Pair#volume24hTo}
	 */
	public double getVolume24hTo() {
		return volume24hTo;
	}
}
