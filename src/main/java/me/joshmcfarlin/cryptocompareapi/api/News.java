package me.joshmcfarlin.cryptocompareapi.api;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.CryptoCompareAPIConstant;
import me.joshmcfarlin.cryptocompareapi.models.news.NewsProvider;
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
        Reader r = Connection.getJSON(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/news/providers", CallTypes.NEWS);

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
        Reader r = Connection.getJSON(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/news/", CallTypes.NEWS);

        Type newsListType = new TypeToken<List<NewsStory>>() {}.getType();
        return new Gson().fromJson(r, newsListType);
    }
}
