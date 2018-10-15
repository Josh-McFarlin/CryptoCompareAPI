package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Contains methods for requesting information about news listed on CryptoCompare
 * @author Josh McFarlin
 */
public class News {
    /**
     * Gets a list of news providers on the CryptoCompare website
     * @return List containing different news providers
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static List<NewsProvider> NewsProviderList() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON("https://min-api.cryptocompare.com/data/news/providers", CallTypes.NEWS);

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
        Reader r = Connection.getJSON("https://min-api.cryptocompare.com/data/news/", CallTypes.NEWS);

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
        private String key;

        /**
         * Name provided on CryptoCompare's website
         */
        private String name;

        /**
         * Language used by news provided
         */
        private String lang;

        /**
         * Url to image representing news provider
         */
        private String img;

        @Override
        public String toString() {
            return String.format("Key: %s, Name: %s, Lang: %s", key, name, lang);
        }

        /**
         * {@link NewsProvider#key}
         */
        public String getKey() {
            return key;
        }

        /**
         * {@link NewsProvider#name}
         */
        public String getName() {
            return name;
        }

        /**
         * {@link NewsProvider#lang}
         */
        public String getLang() {
            return lang;
        }

        /**
         * {@link NewsProvider#img}
         */
        public String getImg() {
            return img;
        }
    }

    /**
     * Represents a news story on CryptoCompare's website
     */
    public class NewsStory {
        /**
         * News story ID on CryptoCompare's website
         */
        private int id;

        /**
         * Url to news story on provider's website
         */
        private String guid;

        /**
         * Unix time the story was published
         */
        @SerializedName("published_on")
        private int publishedOn;

        /**
         * Image url
         */
        @SerializedName("imageurl")
        private String imageUrl;

        /**
         * Title of the news story
         */
        private String title;

        /**
         * News story url on CryptoCompare's website
         */
        private String url;

        /**
         * Source of the news story
         */
        private String source;

        /**
         * Body of the news story
         */
        private String body;

        /**
         * Tags provided with the news story
         */
        private String tags;

        /**
         * The language the news story is written in
         */
        private String lang;

        /**
         * The provider of the news article
         */
        @SerializedName("source_info")
        private ShortNewsProvider provider;

        @Override
        public String toString() {
            return String.format("%s: %s", id, title);
        }

        /**
         * {@link NewsStory#id}
         */
        public int getId() {
            return id;
        }

        /**
         * {@link NewsStory#guid}
         */
        public String getGuid() {
            return guid;
        }

        /**
         * {@link NewsStory#publishedOn}
         */
        public int getPublishedOn() {
            return publishedOn;
        }

        /**
         * {@link NewsStory#imageUrl}
         */
        public String getImageUrl() {
            return imageUrl;
        }

        /**
         * {@link NewsStory#title}
         */
        public String getTitle() {
            return title;
        }

        /**
         * {@link NewsStory#url}
         */
        public String getUrl() {
            return url;
        }

        /**
         * {@link NewsStory#source}
         */
        public String getSource() {
            return source;
        }

        /**
         * {@link NewsStory#body}
         */
        public String getBody() {
            return body;
        }

        /**
         * {@link NewsStory#tags}
         */
        public String getTags() {
            return tags;
        }

        /**
         * {@link NewsStory#lang}
         */
        public String getLang() {
            return lang;
        }

        /**
         * {@link NewsStory#provider}
         */
        public ShortNewsProvider getProvider() {
            return provider;
        }

        /**
         * Represents information about a news provider
         */
        public class ShortNewsProvider {
            /**
             * Name provided on CryptoCompare's website
             */
            private String name;

            /**
             * Language used by news provided
             */
            private String lang;

            /**
             * Url to image representing news provider
             */
            private String img;

            @Override
            public String toString() {
                return String.format("Name: %s, Lang: %s", name, lang);
            }

            /**
             * {@link ShortNewsProvider#name}
             */
            public String getName() {
                return name;
            }

            /**
             * {@link ShortNewsProvider#lang}
             */
            public String getLang() {
                return lang;
            }

            /**
             * {@link ShortNewsProvider#img}
             */
            public String getImg() {
                return img;
            }
        }
    }
}
