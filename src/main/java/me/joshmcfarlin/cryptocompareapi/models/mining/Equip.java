package me.joshmcfarlin.cryptocompareapi.models.mining;

import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.Mining;

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
	 * {@link Mining.Equipment.Equip#id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * {@link Mining.Equipment.Equip#parentID}
	 */
	public int getParentID() {
		return parentID;
	}

	/**
	 * {@link Mining.Equipment.Equip#company}
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * {@link Mining.Equipment.Equip#url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * {@link Mining.Equipment.Equip#logoURL}
	 */
	public String getLogoURL() {
		return logoURL;
	}

	/**
	 * {@link Mining.Equipment.Equip#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link Mining.Equipment.Equip#recommended}
	 */
	public boolean isRecommended() {
		return recommended;
	}

	/**
	 * {@link Mining.Equipment.Equip#sponsored}
	 */
	public boolean isSponsored() {
		return sponsored;
	}

	/**
	 * {@link Mining.Equipment.Equip#affiliateURL}
	 */
	public String getAffiliateURL() {
		return affiliateURL;
	}

	/**
	 * {@link Mining.Equipment.Equip#algorithm}
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * {@link Mining.Equipment.Equip#hashesPerSecond}
	 */
	public String getHashesPerSecond() {
		return hashesPerSecond;
	}

	/**
	 * {@link Mining.Equipment.Equip#cost}
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * {@link Mining.Equipment.Equip#currency}
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * {@link Mining.Equipment.Equip#equipmentType}
	 */
	public String getEquipmentType() {
		return equipmentType;
	}

	/**
	 * {@link Mining.Equipment.Equip#powerConsumption}
	 */
	public String getPowerConsumption() {
		return powerConsumption;
	}

	/**
	 * {@link Mining.Equipment.Equip#currenciesAvailable}
	 */
	public String getCurrenciesAvailable() {
		return currenciesAvailable;
	}

	/**
	 * {@link Mining.Equipment.Equip#currenciesAvailableLogo}
	 */
	public String getCurrenciesAvailableLogo() {
		return currenciesAvailableLogo;
	}

	/**
	 * {@link Mining.Equipment.Equip#currenciesAvailableName}
	 */
	public String getCurrenciesAvailableName() {
		return currenciesAvailableName;
	}
}