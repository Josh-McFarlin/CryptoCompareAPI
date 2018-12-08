package me.joshmcfarlin.cryptocompareapi.models.market;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the trading pair to-symbol
 */
public class ToSym {
	/**
	 * Type
	 */
	@SerializedName("TYPE")
	private String type;

	/**
	 * Shortened names of markets used for data
	 */
	@SerializedName("MARKET")
	private String market;

	/**
	 * From symbol in trading pair
	 */
	@SerializedName("FROMSYMBOL")
	private String fromSymbol;

	/**
	 * To symbol in trading pair
	 */
	@SerializedName("TOSYMBOL")
	private String toSymbol;

	/**
	 * Number of flags used
	 */
	@SerializedName("FLAGS")
	private int flags;

	/**
	 * Coin price
	 */
	@SerializedName("PRICE")
	private double price;

	/**
	 * Unix time of last update
	 */
	@SerializedName("LASTUPDATE")
	private int lastUpdate;

	/**
	 * Last volume
	 */
	@SerializedName("LASTVOLUME")
	private double lastVolume;

	/**
	 * Last volume to
	 */
	@SerializedName("LASTVOLUMETO")
	private double lastVolumeTo;

	/**
	 * Last trade ID
	 */
	@SerializedName("LASTTRADEID")
	private String lastTradeID;

	/**
	 * Volume of day
	 */
	@SerializedName("VOLUMEDAY")
	private double volumeDay;

	/**
	 * Volume to of day
	 */
	@SerializedName("VOLUMEDAYTO")
	private double volumeDayTo;

	/**
	 * 24 hour volume
	 */
	@SerializedName("VOLUME24HOUR")
	private double volume24Hour;

	/**
	 * 24 hour volume to
	 */
	@SerializedName("VOLUME24HOURTO")
	private double volume24HourTo;

	/**
	 * Day open
	 */
	@SerializedName("OPENDAY")
	private double openDay;

	/**
	 * Day high
	 */
	@SerializedName("HIGHDAY")
	private double highDay;

	/**
	 * Day low
	 */
	@SerializedName("LOWDAY")
	private double lowDay;

	/**
	 * 24 hour open
	 */
	@SerializedName("OPEN24HOUR")
	private double open24Hour;

	/**
	 * 24 hour high
	 */
	@SerializedName("HIGH24HOUR")
	private double high24Hour;

	/**
	 * 24 hour low
	 */
	@SerializedName("LOW24HOUR")
	private double low24Hour;

	/**
	 * Last market
	 */
	@SerializedName("LASTMARKET")
	private String lastMarket;

	/**
	 * 24 hour change
	 */
	@SerializedName("CHANGE24HOUR")
	private double change24Hour;

	/**
	 * 24 hour percent change
	 */
	@SerializedName("CHANGEPCT24HOUR")
	private double changePct24Hour;

	/**
	 * Day change
	 */
	@SerializedName("CHANGEDAY")
	private double changeDay;

	/**
	 * Day percent change
	 */
	@SerializedName("CHANGEPCTDAY")
	private double changePctDay;

	/**
	 * Coin supply
	 */
	@SerializedName("SUPPLY")
	private double supply;

	/**
	 * Coin market capitalization
	 */
	@SerializedName("MKTCAP")
	private double marketCap;

	/**
	 * 24 hour total volume
	 */
	@SerializedName("TOTALVOLUME24H")
	private double totalVolume24Hour;
	/**
	 * 24 hour total volume to
	 */
	@SerializedName("TOTALVOLUME24HTO")
	private double totalVolume24HourTo;

	@Override
	public String toString() {
		return String.format("%s-%s: %f", fromSymbol, toSymbol, volume24Hour);
	}

	/**
	 * {@link ToSym#type}
	 */
	public String getType() {
		return type;
	}

	/**
	 * {@link ToSym#market}
	 */
	public String getMarket() {
		return market;
	}

	/**
	 * {@link ToSym#fromSymbol}
	 */
	public String getFromSymbol() {
		return fromSymbol;
	}

	/**
	 * {@link ToSym#toSymbol}
	 */
	public String getToSymbol() {
		return toSymbol;
	}

	/**
	 * {@link ToSym#flags}
	 */
	public int getFlags() {
		return flags;
	}

	/**
	 * {@link ToSym#price}
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * {@link ToSym#lastUpdate}
	 */
	public int getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * {@link ToSym#lastVolume}
	 */
	public double getLastVolume() {
		return lastVolume;
	}

	/**
	 * {@link ToSym#lastVolumeTo}
	 */
	public double getLastVolumeTo() {
		return lastVolumeTo;
	}

	/**
	 * {@link ToSym#lastTradeID}
	 */
	public String getLastTradeID() {
		return lastTradeID;
	}

	/**
	 * {@link ToSym#volumeDay}
	 */
	public double getVolumeDay() {
		return volumeDay;
	}

	/**
	 * {@link ToSym#volumeDayTo}
	 */
	public double getVolumeDayTo() {
		return volumeDayTo;
	}

	/**
	 * {@link ToSym#volume24Hour}
	 */
	public double getVolume24Hour() {
		return volume24Hour;
	}

	/**
	 * {@link ToSym#volume24HourTo}
	 */
	public double getVolume24HourTo() {
		return volume24HourTo;
	}

	/**
	 * {@link ToSym#openDay}
	 */
	public double getOpenDay() {
		return openDay;
	}

	/**
	 * {@link ToSym#highDay}
	 */
	public double getHighDay() {
		return highDay;
	}

	/**
	 * {@link ToSym#lowDay}
	 */
	public double getLowDay() {
		return lowDay;
	}

	/**
	 * {@link ToSym#open24Hour}
	 */
	public double getOpen24Hour() {
		return open24Hour;
	}

	/**
	 * {@link ToSym#high24Hour}
	 */
	public double getHigh24Hour() {
		return high24Hour;
	}

	/**
	 * {@link ToSym#low24Hour}
	 */
	public double getLow24Hour() {
		return low24Hour;
	}

	/**
	 * {@link ToSym#lastMarket}
	 */
	public String getLastMarket() {
		return lastMarket;
	}

	/**
	 * {@link ToSym#change24Hour}
	 */
	public double getChange24Hour() {
		return change24Hour;
	}

	/**
	 * {@link ToSym#changePct24Hour}
	 */
	public double getChangePct24Hour() {
		return changePct24Hour;
	}

	/**
	 * {@link ToSym#changeDay}
	 */
	public double getChangeDay() {
		return changeDay;
	}

	/**
	 * {@link ToSym#changePctDay}
	 */
	public double getChangePctDay() {
		return changePctDay;
	}

	/**
	 * {@link ToSym#supply}
	 */
	public double getSupply() {
		return supply;
	}

	/**
	 * {@link ToSym#marketCap}
	 */
	public double getMarketCap() {
		return marketCap;
	}

	/**
	 * {@link ToSym#totalVolume24Hour}
	 */
	public double getTotalVolume24Hour() {
		return totalVolume24Hour;
	}

	/**
	 * {@link ToSym#totalVolume24HourTo}
	 */
	public double getTotalVolume24HourTo() {
		return totalVolume24HourTo;
	}
}

