package me.joshmcfarlin.cryptocompareapi.models.coin;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents full snapshot data
 */
public class CoinSnapshot {
	/**
	 * Indicates request success
	 */
	@SerializedName("Response")
	private String response;

	/**
	 * A message provided by the API
	 */
	@SerializedName("Message")
	private String message;

	/**
	 * Response type
	 */
	@SerializedName("Type")
	private int type;

	/**
	 * Response data
	 */
	@SerializedName("Data")
	private Data data;

	/**
	 * {@link CoinSnapshot#response}
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * {@link CoinSnapshot#message}
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * {@link CoinSnapshot#type}
	 */
	public int getType() {
		return type;
	}

	/**
	 * {@link CoinSnapshot#data}
	 */
	public Data getData() {
		return data;
	}

	/**
	 * Represents the data
	 */
	public class Data {
		/**
		 * SEO data for the coin
		 */
		@SerializedName("SEO")
		private SEO seo;

		/**
		 * General data about the coin
		 */
		@SerializedName("General")
		private General general;

		/**
		 * ICO data about the coin
		 */
		@SerializedName("Ico")
		private ICO ico;

		/**
		 * A list of subscriptions used for the streamer and for figuring out what the coin pairs are
		 */
		@SerializedName("Subs")
		private List<String> subs;

		/**
		 * A list of aggregated prices for all pairs available
		 */
		@SerializedName("StreamerDataRaw")
		private List<String> streamerDataRaw;

		/**
		 * {@link Data#seo}
		 */
		public SEO getSeo() {
			return seo;
		}

		/**
		 * {@link Data#general}
		 */
		public General getGeneral() {
			return general;
		}

		/**
		 * {@link Data#ico}
		 */
		public ICO getIco() {
			return ico;
		}

		/**
		 * {@link Data#subs}
		 */
		public List<String> getSubs() {
			return subs;
		}

		/**
		 * {@link Data#streamerDataRaw}
		 */
		public List<String> getStreamerDataRaw() {
			return streamerDataRaw;
		}

	}
}
