package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

/**
 * Represents exchange data
 */
public class Exchange {
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
	 * {@link Exchange#type}
	 */
	public int getType() {
		return type;
	}

	/**
	 * {@link Exchange#market}
	 */
	public String getMarket() {
		return market;
	}

	/**
	 * {@link Exchange#fromSymbol}
	 */
	public String getFromSymbol() {
		return fromSymbol;
	}

	/**
	 * {@link Exchange#toSymbol}
	 */
	public String getToSymbol() {
		return toSymbol;
	}

	/**
	 * {@link Exchange#flags}
	 */
	public int getFlags() {
		return flags;
	}

	/**
	 * {@link Exchange#price}
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * {@link Exchange#lastUpdate}
	 */
	public int getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * {@link Exchange#lastVolume}
	 */
	public double getLastVolume() {
		return lastVolume;
	}

	/**
	 * {@link Exchange#lastVolumeTo}
	 */
	public double getLastVolumeTo() {
		return lastVolumeTo;
	}

	/**
	 * {@link Exchange#lastTradeID}
	 */
	public String getLastTradeID() {
		return lastTradeID;
	}

	/**
	 * {@link Exchange#volume24Hour}
	 */
	public double getVolume24Hour() {
		return volume24Hour;
	}

	/**
	 * {@link Exchange#volume24HourTo}
	 */
	public double getVolume24HourTo() {
		return volume24HourTo;
	}

	/**
	 * {@link Exchange#open24Hour}
	 */
	public double getOpen24Hour() {
		return open24Hour;
	}

	/**
	 * {@link Exchange#high24Hour}
	 */
	public double getHigh24Hour() {
		return high24Hour;
	}

	/**
	 * {@link Exchange#low24Hour}
	 */
	public double getLow24Hour() {
		return low24Hour;
	}
}