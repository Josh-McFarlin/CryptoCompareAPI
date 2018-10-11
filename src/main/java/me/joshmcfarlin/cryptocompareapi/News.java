package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.Utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.Utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Utils.OutOfCallsException;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

/**
 * Contains methods for requesting information about news listed on CryptoCompare
 * @author joshuamcfarlin
 * @version 1
 */
public class News {
    /**
     * Gets a list of news providers on the CryptoCompare website
     * @return List containing different news providers
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static List<NewsProvider> NewsProviderList() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON(new URL("https://min-api.cryptocompare.com/data/news/providers"), CallTypes.NEWS);
        Type newsListType = new TypeToken<List<NewsProvider>>() {}.getType();
        return new Gson().fromJson(r, newsListType);
    }

    /**
     * Gets a list of news stories on the CryptoCompare website
     * @return List containing different news stories
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static List<NewsStory> NewsList() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON(new URL("https://min-api.cryptocompare.com/data/news/"), CallTypes.NEWS);
        Type newsListType = new TypeToken<List<NewsStory>>() {}.getType();
        return new Gson().fromJson(r, newsListType);
    }

    /**
     * Represents a news provider on CryptoCompare's website
     */
    public class NewsProvider {
        /**
         * Key name used by CryptoCompare
         */
        public String key;
        /**
         * Name provided on CryptoCompare's website
         */
        public String name;
        /**
         * Language used by news provided
         */
        public String lang;
        /**
         * Url to image representing news provider
         */
        public String img;

        @Override
        public String toString() {
            return String.format("Key: %s, Name: %s, Lang: %s", key, name, lang);
        }
    }

    /**
     * Represents a news story on CryptoCompare's website
     */
    public class NewsStory {
        /**
         * News story ID on CryptoCompare's website
         */
        public int id;
        /**
         * Url to news story on provider's website
         */
        public String guid;
        /**
         * Unix time the story was published
         */
        @SerializedName("published_on")
        public int publishedOn;
        /**
         * Image url
         */
        @SerializedName("imageurl")
        public String imageUrl;
        /**
         * Title of the news story
         */
        public String title;
        /**
         * News story url on CryptoCompare's website
         */
        public String url;
        /**
         * Source of the news story
         */
        public String source;
        /**
         * Body of the news story
         */
        public String body;
        /**
         * Tags provided with the news story
         */
        public String tags;
        /**
         * The language the news story is written in
         */
        public String lang;
        @SerializedName("source_info")
        /**
         * The provider of the news article
         */
        public ShortNewsProvider provider;

        @Override
        public String toString() {
            return String.format("%s: %s", id, title);
        }

        public class ShortNewsProvider {
            /**
             * Name provided on CryptoCompare's website
             */
            public String name;
            /**
             * Language used by news provided
             */
            public String lang;
            /**
             * Url to image representing news provider
             */
            public String img;

            @Override
            public String toString() {
                return String.format("Name: %s, Lang: %s", name, lang);
            }
        }
    }
}
