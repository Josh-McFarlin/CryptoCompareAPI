package me.joshmcfarlin.cryptocompareapi.models.historic;

/**
 * Represents a conversion type between cryptocurrencies or currencies
 */
public class ConversionType {
	/**
	 * The type of currency used to make the conversion
	 */
	private String type;

	/**
	 * The symbol of the currency used in the conversion
	 */
	private String conversionSymbol;

	/**
	 * {@link ConversionType#type}
	 */
	public String getType() {
		return type;
	}

	/**
	 * {@link ConversionType#conversionSymbol}
	 */
	public String getConversionSymbol() {
		return conversionSymbol;
	}
}