package me.joshmcfarlin.cryptocompareapi.models.historic;

import com.google.gson.annotations.SerializedName;

/**
 * Represents data returned by the API
 */
public class Data {
	/**
	 * Represents Unix time
	 */
	private int time;

	/**
	 * Symbol close on provided date
	 */
	private double close;

	/**
	 * Symbol high on provided date
	 */
	private double high;

	/**
	 * Symbol low on provided date
	 */
	private double low;

	/**
	 * Symbol open on provided date
	 */
	private double open;

	/**
	 * Volume from the symbol on provided date
	 */
	@SerializedName("volumefrom")
	private double volumeFrom;

	/**
	 * Volume to the symbol on provided date
	 */
	@SerializedName("volumeto")
	private double volumeTo;

	/**
	 * {@link Data#time}
	 */
	public int getTime() {
		return time;
	}

	/**
	 * {@link Data#close}
	 */
	public double getClose() {
		return close;
	}

	/**
	 * {@link Data#high}
	 */
	public double getHigh() {
		return high;
	}

	/**
	 * {@link Data#low}
	 */
	public double getLow() {
		return low;
	}

	/**
	 * {@link Data#open}
	 */
	public double getOpen() {
		return open;
	}

	/**
	 * {@link Data#volumeFrom}
	 */
	public double getVolumeFrom() {
		return volumeFrom;
	}

	/**
	 * {@link Data#volumeTo}
	 */
	public double getVolumeTo() {
		return volumeTo;
	}
}