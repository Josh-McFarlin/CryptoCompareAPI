package me.joshmcfarlin.cryptocompareapi.models.historic;

/**
 * Represents Calculation Type used by the API
 */
public enum CalcType {
	/**
	 * A close of the day close price
	 */
	CLOSE("Close"),
	/**
	 * The average between the 24H high and low
	 */
	MIDHIGHLOW("MidHighLow"),
	/**
	 * The total volume to / the total volume from
	 */
	VOLFVOLT("VolFVolT");

	/**
	 * The text that will be passed to the API call
	 */
	private String text;

	CalcType(String text) {
		this.text = text;
	}

	/**
	 * {@link CalcType#text}
	 */
	public String getText() {
		return text;
	}
}