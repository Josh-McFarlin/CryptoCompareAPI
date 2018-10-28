package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

/**
 * Represents data returned by the API
 */
public class Data {
	/**
	 * Represents general social info
	 */
	@SerializedName("General")
	private General general;

	/**
	 * Represents social info from CryptoCompare
	 */
	@SerializedName("CryptoCompare")
	private CryptoCompare cryptoCompare;

	/**
	 * Represents social info from Twitter
	 */
	@SerializedName("Twitter")
	private Twitter twitter;

	/**
	 * Represents social info from Reddit
	 */
	@SerializedName("Reddit")
	private Reddit reddit;

	/**
	 * Represents social info from Facebook
	 */
	@SerializedName("Facebook")
	private Facebook facebook;

	/**
	 * Represents social info from the coin's code repository
	 */
	@SerializedName("CodeRepository")
	private CodeRepository codeRepository;

	/**
	 * {@link Data#general}
	 */
	public General getGeneral() {
		return general;
	}

	/**
	 * {@link Data#cryptoCompare}
	 */
	public CryptoCompare getCryptoCompare() {
		return cryptoCompare;
	}

	/**
	 * {@link Data#twitter}
	 */
	public Twitter getTwitter() {
		return twitter;
	}

	/**
	 * {@link Data#reddit}
	 */
	public Reddit getReddit() {
		return reddit;
	}

	/**
	 * {@link Data#facebook}
	 */
	public Facebook getFacebook() {
		return facebook;
	}

	/**
	 * {@link Data#codeRepository}
	 */
	public CodeRepository getCodeRepository() {
		return codeRepository;
	}

	/**
	 * Represents general info
	 */
	public class General {
		/**
		 * The coin's short name
		 */
		@SerializedName("Name")
		private String name;

		/**
		 * The coin's name
		 */
		@SerializedName("CoinName")
		private String coinName;

		/**
		 * The type
		 */
		@SerializedName("Type")
		private String type;

		/**
		 * The amount of points
		 */
		@SerializedName("Points")
		private int points;

		/**
		 * {@link General#name}
		 */
		public String getName() {
			return name;
		}

		/**
		 * {@link General#coinName}
		 */
		public String getCoinName() {
			return coinName;
		}

		/**
		 * {@link General#type}
		 */
		public String getType() {
			return type;
		}

		/**
		 * {@link General#points}
		 */
		public int getPoints() {
			return points;
		}
	}
}