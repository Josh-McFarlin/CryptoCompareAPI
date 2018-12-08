package me.joshmcfarlin.cryptocompareapi.models.historic;

/**
 * Represents Average Type used by the API
 */
public enum AverageType {
	/**
	 * A VWAP of the hourly close price
	 */
	HOURVWAP("HourVWAP"),
	/**
	 * The average between the 24H high and low
	 */
	MIDHIGHLOW("MidHighLow"),
	/**
	 * The total volume from / the total volume to (only avilable with tryConversion set to false)
	 */
	VOLFVOLT("VolFVolT");

	/**
	 * The text that will be passed to the API call
	 */
	private String text;

	AverageType(String text) {
		this.text = text;
	}

	/**
	 * {@link AverageType#text}
	 */
	public String getText() {
		return text;
	}
}