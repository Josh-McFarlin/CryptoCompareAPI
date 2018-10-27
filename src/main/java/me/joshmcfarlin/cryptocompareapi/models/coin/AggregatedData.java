package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

/**
 * Represents general data about the coin
 */
public class AggregatedData {
	/**
	 * Type
	 */
	@SerializedName("TYPE")
	private int type;

	/**
	 * Markets used to get data
	 */
	@SerializedName("MARKET")
	private String market;

	/**
	 * The from symbol of the pair
	 */
	@SerializedName("FROMSYMBOL")
	private String fromSymbol;

	/**
	 * The to symbol of the pair
	 */
	@SerializedName("TOSYMBOL")
	private String toSymbol;

	/**
	 * The number of flags used
	 */
	@SerializedName("FLAGS")
	private int flags;

	/**
	 * The price of the from symbol
	 */
	@SerializedName("PRICE")
	private double price;

	/**
	 * Unix time of the last update
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
	 * Last trade id
	 */
	@SerializedName("LASTTRADEID")
	private String lastTradeID;

	/**
	 * Day volume
	 */
	@SerializedName("VOLUMEDAY")
	private double volumeDay;

	/**
	 * Day volume to
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
	 * {@link AggregatedData#type}
	 */
	public int getType() {
		return type;
	}

	/**
	 * {@link AggregatedData#market}
	 */
	public String getMarket() {
		return market;
	}

	/**
	 * {@link AggregatedData#fromSymbol}
	 */
	public String getFromSymbol() {
		return fromSymbol;
	}

	/**
	 * {@link AggregatedData#toSymbol}
	 */
	public String getToSymbol() {
		return toSymbol;
	}

	/**
	 * {@link AggregatedData#flags}
	 */
	public int getFlags() {
		return flags;
	}

	/**
	 * {@link AggregatedData#price}
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * {@link AggregatedData#lastUpdate}
	 */
	public int getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * {@link AggregatedData#lastVolume}
	 */
	public double getLastVolume() {
		return lastVolume;
	}

	/**
	 * {@link AggregatedData#lastVolumeTo}
	 */
	public double getLastVolumeTo() {
		return lastVolumeTo;
	}

	/**
	 * {@link AggregatedData#lastTradeID}
	 */
	public String getLastTradeID() {
		return lastTradeID;
	}

	/**
	 * {@link AggregatedData#volumeDay}
	 */
	public double getVolumeDay() {
		return volumeDay;
	}

	/**
	 * {@link AggregatedData#volumeDayTo}
	 */
	public double getVolumeDayTo() {
		return volumeDayTo;
	}

	/**
	 * {@link AggregatedData#volume24Hour}
	 */
	public double getVolume24Hour() {
		return volume24Hour;
	}

	/**
	 * {@link AggregatedData#volume24HourTo}
	 */
	public double getVolume24HourTo() {
		return volume24HourTo;
	}

	/**
	 * {@link AggregatedData#openDay}
	 */
	public double getOpenDay() {
		return openDay;
	}

	/**
	 * {@link AggregatedData#highDay}
	 */
	public double getHighDay() {
		return highDay;
	}

	/**
	 * {@link AggregatedData#lowDay}
	 */
	public double getLowDay() {
		return lowDay;
	}

	/**
	 * {@link AggregatedData#open24Hour}
	 */
	public double getOpen24Hour() {
		return open24Hour;
	}

	/**
	 * {@link AggregatedData#high24Hour}
	 */
	public double getHigh24Hour() {
		return high24Hour;
	}

	/**
	 * {@link AggregatedData#low24Hour}
	 */
	public double getLow24Hour() {
		return low24Hour;
	}

	/**
	 * {@link AggregatedData#lastMarket}
	 */
	public String getLastMarket() {
		return lastMarket;
	}
}

