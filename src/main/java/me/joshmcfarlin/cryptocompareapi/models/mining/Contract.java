package me.joshmcfarlin.cryptocompareapi.models.mining;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a mining contract
 */
public class Contract {
	/**
	 * ID of the equipment
	 */
	@SerializedName("Id")
	private int id;

	/**
	 * Parent ID of the equipment
	 */
	@SerializedName("ParentId")
	private int parentID;

	/**
	 * Equipment company
	 */
	@SerializedName("Company")
	private String company;

	/**
	 * Url
	 */
	@SerializedName("Url")
	private String url;

	/**
	 * Url of the logo
	 */
	@SerializedName("LogoUrl")
	private String logoURL;

	/**
	 * Equipment name
	 */
	@SerializedName("Name")
	private String name;

	/**
	 * Represents if recommended equipment
	 */
	@SerializedName("Recommended")
	private boolean recommended;

	/**
	 * Represents if sponsored equipment
	 */
	@SerializedName("Sponsored")
	private boolean sponsored;

	/**
	 * Affiliate url
	 */
	@SerializedName("AffiliateURL")
	private String affiliateURL;

	/**
	 * Equipment algorithm
	 */
	@SerializedName("Algorithm")
	private String algorithm;

	/**
	 * Number of hashes per second the equipment can reach
	 */
	@SerializedName("HashesPerSecond")
	private String hashesPerSecond;

	/**
	 * Cost of the equipment
	 */
	@SerializedName("Cost")
	private double cost;

	/**
	 * Currency of the cost
	 */
	@SerializedName("Currency")
	private String currency;

	/**
	 * Cost of the fee
	 */
	@SerializedName("FeeValue")
	private double feeValue;

	/**
	 * Currency of the fee
	 */
	@SerializedName("FeeValueCurrency")
	private String feeValueCurrency;

	/**
	 * Length of the contract
	 */
	@SerializedName("ContractLength")
	private String contractLength;

	/**
	 * Currencies available to be mined with the equipment
	 */
	@SerializedName("CurrenciesAvailable")
	private String currenciesAvailable;

	/**
	 * Logos of the currencies available for mining
	 */
	@SerializedName("CurrenciesAvailableLogo")
	private String currenciesAvailableLogo;

	/**
	 * Currencies available to be mined with the equipment
	 */
	@SerializedName("CurrenciesAvailableName")
	private String currenciesAvailableName;

	@Override
	public String toString() {
		return String.format("%s - %s", company, name);
	}

	/**
	 * {@link Contract#id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * {@link Contract#parentID}
	 */
	public int getParentID() {
		return parentID;
	}

	/**
	 * {@link Contract#company}
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * {@link Contract#url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * {@link Contract#logoURL}
	 */
	public String getLogoURL() {
		return logoURL;
	}

	/**
	 * {@link Contract#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link Contract#recommended}
	 */
	public boolean isRecommended() {
		return recommended;
	}

	/**
	 * {@link Contract#sponsored}
	 */
	public boolean isSponsored() {
		return sponsored;
	}

	/**
	 * {@link Contract#affiliateURL}
	 */
	public String getAffiliateURL() {
		return affiliateURL;
	}

	/**
	 * {@link Contract#algorithm}
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * {@link Contract#hashesPerSecond}
	 */
	public String getHashesPerSecond() {
		return hashesPerSecond;
	}

	/**
	 * {@link Contract#cost}
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * {@link Contract#currency}
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * {@link Contract#feeValue}
	 */
	public double getFeeValue() {
		return feeValue;
	}

	/**
	 * {@link Contract#feeValueCurrency}
	 */
	public String getFeeValueCurrency() {
		return feeValueCurrency;
	}

	/**
	 * {@link Contract#contractLength}
	 */
	public String getContractLength() {
		return contractLength;
	}

	/**
	 * {@link Contract#currenciesAvailable}
	 */
	public String getCurrenciesAvailable() {
		return currenciesAvailable;
	}

	/**
	 * {@link Contract#currenciesAvailableLogo}
	 */
	public String getCurrenciesAvailableLogo() {
		return currenciesAvailableLogo;
	}

	/**
	 * {@link Contract#currenciesAvailableName}
	 */
	public String getCurrenciesAvailableName() {
		return currenciesAvailableName;
	}
}
