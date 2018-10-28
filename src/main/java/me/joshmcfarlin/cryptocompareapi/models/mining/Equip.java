package me.joshmcfarlin.cryptocompareapi.models.mining;

import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.api.Mining;

/**
 * Represents data about mining equipment
 */
public class Equip {
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
	 * Type of the equipment
	 */
	@SerializedName("EquipmentType")
	private String equipmentType;

	/**
	 * Power consumption of the equipment
	 */
	@SerializedName("PowerConsumption")
	private String powerConsumption;

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
	 * {@link Equip#id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * {@link Equip#parentID}
	 */
	public int getParentID() {
		return parentID;
	}

	/**
	 * {@link Equip#company}
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * {@link Equip#url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * {@link Equip#logoURL}
	 */
	public String getLogoURL() {
		return logoURL;
	}

	/**
	 * {@link Equip#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link Equip#recommended}
	 */
	public boolean isRecommended() {
		return recommended;
	}

	/**
	 * {@link Equip#sponsored}
	 */
	public boolean isSponsored() {
		return sponsored;
	}

	/**
	 * {@link Equip#affiliateURL}
	 */
	public String getAffiliateURL() {
		return affiliateURL;
	}

	/**
	 * {@link Equip#algorithm}
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * {@link Equip#hashesPerSecond}
	 */
	public String getHashesPerSecond() {
		return hashesPerSecond;
	}

	/**
	 * {@link Equip#cost}
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * {@link Equip#currency}
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * {@link Equip#equipmentType}
	 */
	public String getEquipmentType() {
		return equipmentType;
	}

	/**
	 * {@link Equip#powerConsumption}
	 */
	public String getPowerConsumption() {
		return powerConsumption;
	}

	/**
	 * {@link Equip#currenciesAvailable}
	 */
	public String getCurrenciesAvailable() {
		return currenciesAvailable;
	}

	/**
	 * {@link Equip#currenciesAvailableLogo}
	 */
	public String getCurrenciesAvailableLogo() {
		return currenciesAvailableLogo;
	}

	/**
	 * {@link Equip#currenciesAvailableName}
	 */
	public String getCurrenciesAvailableName() {
		return currenciesAvailableName;
	}
}