package me.joshmcfarlin.cryptocompareapi.models.historic;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents historic data provided by the CryptoCompare API
 */
public class History {
	/**
	 * Indicates request success
	 */
	@SerializedName("Response")
	private String response;

	/**
	 * Indicates HTML request response type
	 */
	@SerializedName("Type")
	private int type;

	/**
	 * Historic data returned by the API
	 */
	@SerializedName("Data")
	private List<Data> data;

	/**
	 * Indicates the Unix starting time of the request
	 */
	@SerializedName("TimeTo")
	private int timeTo;

	/**
	 * Indicates the Unix ending time of the request
	 */
	@SerializedName("TimeFrom")
	private int timeFrom;

	/**
	 * Indicates first value in array
	 */
	@SerializedName("FirstValueInArray")
	private boolean firstValueInArray;

	/**
	 * Indicates if a currency conversion was used to get the data
	 */
	@SerializedName("ConversionType")
	private ConversionType conversionType;

	/**
	 * Indicates if the data was aggregated
	 */
	@SerializedName("Aggregated")
	private boolean aggregated;

	/**
	 * {@link History#response}
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * {@link History#type}
	 */
	public int getType() {
		return type;
	}

	/**
	 * {@link History#data}
	 */
	public List<Data> getData() {
		return data;
	}

	/**
	 * {@link History#timeTo}
	 */
	public int getTimeTo() {
		return timeTo;
	}

	/**
	 * {@link History#timeFrom}
	 */
	public int getTimeFrom() {
		return timeFrom;
	}

	/**
	 * {@link History#firstValueInArray}
	 */
	public boolean isFirstValueInArray() {
		return firstValueInArray;
	}

	/**
	 * {@link History#conversionType}
	 */
	public ConversionType getConversionType() {
		return conversionType;
	}

	/**
	 * {@link History#aggregated}
	 */
	public boolean isAggregated() {
		return aggregated;
	}

}
