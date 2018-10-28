package me.joshmcfarlin.cryptocompareapi.models.market;

import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.api.Market;

/**
 * Represents exchange average
 */
public class ExchangeAverage {
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
	private double changePCT24Hour;

	/**
	 * Day change
	 */
	@SerializedName("CHANGEDAY")
	private double changeDay;

	/**
	 * Day percent change
	 */
	@SerializedName("CHANGEPCTDAY")
	private double changePCTDay;

	/**
	 * {@link ExchangeAverage#market}
	 */
	public String getMarket() {
		return market;
	}

	/**
	 * {@link ExchangeAverage#fromSymbol}
	 */
	public String getFromSymbol() {
		return fromSymbol;
	}

	/**
	 * {@link ExchangeAverage#toSymbol}
	 */
	public String getToSymbol() {
		return toSymbol;
	}

	/**
	 * {@link ExchangeAverage#flags}
	 */
	public int getFlags() {
		return flags;
	}

	/**
	 * {@link ExchangeAverage#price}
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * {@link ExchangeAverage#lastUpdate}
	 */
	public int getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * {@link ExchangeAverage#lastVolume}
	 */
	public double getLastVolume() {
		return lastVolume;
	}

	/**
	 * {@link ExchangeAverage#lastVolumeTo}
	 */
	public double getLastVolumeTo() {
		return lastVolumeTo;
	}

	/**
	 * {@link ExchangeAverage#lastTradeID}
	 */
	public String getLastTradeID() {
		return lastTradeID;
	}

	/**
	 * {@link ExchangeAverage#volume24Hour}
	 */
	public double getVolume24Hour() {
		return volume24Hour;
	}

	/**
	 * {@link ExchangeAverage#volume24HourTo}
	 */
	public double getVolume24HourTo() {
		return volume24HourTo;
	}

	/**
	 * {@link ExchangeAverage#open24Hour}
	 */
	public double getOpen24Hour() {
		return open24Hour;
	}

	/**
	 * {@link ExchangeAverage#high24Hour}
	 */
	public double getHigh24Hour() {
		return high24Hour;
	}

	/**
	 * {@link ExchangeAverage#low24Hour}
	 */
	public double getLow24Hour() {
		return low24Hour;
	}

	/**
	 * {@link ExchangeAverage#lastMarket}
	 */
	public String getLastMarket() {
		return lastMarket;
	}

	/**
	 * {@link ExchangeAverage#change24Hour}
	 */
	public double getChange24Hour() {
		return change24Hour;
	}

	/**
	 * {@link ExchangeAverage#changePCT24Hour}
	 */
	public double getChangePCT24Hour() {
		return changePCT24Hour;
	}

	/**
	 * {@link ExchangeAverage#changeDay}
	 */
	public double getChangeDay() {
		return changeDay;
	}

	/**
	 * {@link ExchangeAverage#changePCTDay}
	 */
	public double getChangePCTDay() {
		return changePCTDay;
	}
}
