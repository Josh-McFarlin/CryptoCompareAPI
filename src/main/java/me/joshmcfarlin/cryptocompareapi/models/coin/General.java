package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the general data available for this coin
 */
public class General {
	/**
	 * The id of the coin
	 */
	@SerializedName("Id")
	private int id;

	/**
	 * The type of document
	 */
	@SerializedName("DocumentType")
	private String documentType;

	/**
	 * The title used on the CryptoCompare website (a combination of the coin name and the symbol)
	 */
	@SerializedName("H1Text")
	private String h1Text;

	/**
	 * The text displayed in red on the website at the top, generally a big issue with the coin
	 */
	@SerializedName("DangerTop")
	private String dangerTop;

	/**
	 * The text displayed in yellow on the website at the top, generally an issue with the coin
	 */
	@SerializedName("WarningTop")
	private String warningTop;

	/**
	 * The text displayed in green on the website at the top, generally an announcement or extra info that is important
	 */
	@SerializedName("InfoTop")
	private String infoTop;

	/**
	 * The symbol of the coin
	 */
	@SerializedName("Symbol")
	private String symbol;

	/**
	 * The relative path to the coin, prefix this value with the BaseLinkUrl to get the absolute path
	 */
	@SerializedName("Url")
	private String url;

	/**
	 * The base angular URL
	 */
	@SerializedName("BaseAngularUrl")
	private String baseAngularUrl;

	/**
	 * The name of the coin
	 */
	@SerializedName("Name")
	private String name;

	/**
	 * The relative path to the logo of the coin, prefix this value with the BaseImageUrl to get the absolute path
	 */
	@SerializedName("ImageUrl")
	private String imageUrl;

	/**
	 * The description of the coin, this is returned as html
	 */
	@SerializedName("Description")
	private String description;

	/**
	 * The features of the coin, this is returned as html
	 */
	@SerializedName("Features")
	private String features;

	/**
	 * The technology of the coin, this is returned as html
	 */
	@SerializedName("Technology")
	private String technology;

	/**
	 * The maximum number of coins
	 */
	@SerializedName("TotalCoinSupply")
	private String totalCoinSupply;

	/**
	 * The algorithm of the coin
	 */
	@SerializedName("Algorithm")
	private String algorithm;

	/**
	 * The proof type of the coin
	 */
	@SerializedName("ProofType")
	private String proofType;

	/**
	 * The day the first block was mined, so the day the coin actually came into existence
	 */
	@SerializedName("StartDate")
	private String startDate;

	/**
	 * The twitter address of the coin
	 */
	@SerializedName("Twitter")
	private String twitter;

	/**
	 * The affiliate URL
	 */
	@SerializedName("AffiliateUrl")
	private String affiliateUrl;

	/**
	 * The coin official website
	 */
	@SerializedName("Website")
	private String website;

	/**
	 * The sponsor of the coin if it is being sponsored
	 */
	@SerializedName("Sponsor")
	private Sponsor sponsor;

	/**
	 * The last time our block explorer got data about this coin
	 */
	@SerializedName("LastBlockExplorerUpdateTS")
	private String lastBlockExplorerUpdateTS;

	/**
	 * The difficulty adjustment
	 */
	@SerializedName("DifficultyAdjustment")
	private String difficultyAdjustment;

	/**
	 * The value by which the block reward is reduced when there is a block reward reduction
	 */
	@SerializedName("BlockRewardReduction")
	private String blockRewardReduction;

	/**
	 * The current block number (delayed by 1 hour max)
	 */
	@SerializedName("BlockNumber")
	private String blockNumber;

	/**
	 * The estimated time it takes to mine a block
	 */
	@SerializedName("BlockTime")
	private String blockTime;

	/**
	 * The current network hashes per second (delayed by 1 hour max)
	 */
	@SerializedName("NetHashesPerSecond")
	private String netHashesPerSecond;

	/**
	 * The current total coins mined (delayed by 1 hour max)
	 */
	@SerializedName("TotalCoinsMined")
	private String totalCoinsMined;

	/**
	 * The total coins mined as of the previous block, this should be the value of the current block total coins mined - the block reward in most cases.
	 */
	@SerializedName("PreviousTotalCoinsMined")
	private String previousTotalCoinsMined;

	/**
	 * The current block reward (delayed by 1 hour max)
	 */
	@SerializedName("BlockReward")
	private String blockReward;

	/**
	 * {@link General#id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * {@link General#documentType}
	 */
	public String getDocumentType() {
		return documentType;
	}

	/**
	 * {@link General#h1Text}
	 */
	public String getH1Text() {
		return h1Text;
	}

	/**
	 * {@link General#dangerTop}
	 */
	public String getDangerTop() {
		return dangerTop;
	}

	/**
	 * {@link General#warningTop}
	 */
	public String getWarningTop() {
		return warningTop;
	}

	/**
	 * {@link General#infoTop}
	 */
	public String getInfoTop() {
		return infoTop;
	}

	/**
	 * {@link General#symbol}
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * {@link General#url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * {@link General#baseAngularUrl}
	 */
	public String getBaseAngularUrl() {
		return baseAngularUrl;
	}

	/**
	 * {@link General#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@link General#imageUrl}
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * {@link General#description}
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * {@link General#features}
	 */
	public String getFeatures() {
		return features;
	}

	/**
	 * {@link General#technology}
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * {@link General#totalCoinSupply}
	 */
	public String getTotalCoinSupply() {
		return totalCoinSupply;
	}

	/**
	 * {@link General#algorithm}
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * {@link General#proofType}
	 */
	public String getProofType() {
		return proofType;
	}

	/**
	 * {@link General#startDate}
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * {@link General#twitter}
	 */
	public String getTwitter() {
		return twitter;
	}

	/**
	 * {@link General#affiliateUrl}
	 */
	public String getAffiliateUrl() {
		return affiliateUrl;
	}

	/**
	 * {@link General#website}
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * {@link General#sponsor}
	 */
	public Sponsor getSponsor() {
		return sponsor;
	}

	/**
	 * {@link General#lastBlockExplorerUpdateTS}
	 */
	public String getLastBlockExplorerUpdateTS() {
		return lastBlockExplorerUpdateTS;
	}

	/**
	 * {@link General#difficultyAdjustment}
	 */
	public String getDifficultyAdjustment() {
		return difficultyAdjustment;
	}

	/**
	 * {@link General#blockRewardReduction}
	 */
	public String getBlockRewardReduction() {
		return blockRewardReduction;
	}

	/**
	 * {@link General#blockNumber}
	 */
	public String getBlockNumber() {
		return blockNumber;
	}

	/**
	 * {@link General#blockTime}
	 */
	public String getBlockTime() {
		return blockTime;
	}

	/**
	 * {@link General#netHashesPerSecond}
	 */
	public String getNetHashesPerSecond() {
		return netHashesPerSecond;
	}

	/**
	 * {@link General#totalCoinsMined}
	 */
	public String getTotalCoinsMined() {
		return totalCoinsMined;
	}

	/**
	 * {@link General#previousTotalCoinsMined}
	 */
	public String getPreviousTotalCoinsMined() {
		return previousTotalCoinsMined;
	}

	/**
	 * {@link General#blockReward}
	 */
	public String getBlockReward() {
		return blockReward;
	}

}