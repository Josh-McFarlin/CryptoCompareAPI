package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.models.social.SocialStats;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.util.List;

/**
 * Contains methods for requesting information about social media accounts for cryptocurrencies and exchanges
 * @author Josh McFarlin
 */
public class Social {
    /**
     * Gets social media information about a provided cryptocurrency or exchange
     * @param id The CryptoCompare ID to find information for
     * @return SocialStats a object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public SocialStats getStats(int id) throws IOException, OutOfCallsException {
        String formattedUrl = "https://www.cryptocompare.com/api/data/socialstats/?id=" + id;

        Reader r = Connection.getJSON(formattedUrl, CallTypes.OTHER);
        return new Gson().fromJson(r, SocialStats.class);
    }

}
