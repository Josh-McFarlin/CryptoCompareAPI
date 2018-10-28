package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.models.news.NewsStory;
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
    public List<NewsProvider> newsProviderList() throws IOException, OutOfCallsException {
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
    public List<NewsStory> newsList() throws IOException, OutOfCallsException {
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
}
