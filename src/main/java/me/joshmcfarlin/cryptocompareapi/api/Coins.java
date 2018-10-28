package me.joshmcfarlin.cryptocompareapi.api;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.models.coin.*;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about coins listed by CryptoCompare
 * @author Josh McFarlin
 */
public class Coins {
    /**
     * Gets general info for all the coins available through the CryptoCompare API
     * @return CoinList A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public CoinList getCoinList() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON("https://min-api.cryptocompare.com/data/all/coinlist", CallTypes.PRICE);

        return new Gson().fromJson(r, CoinList.class);
    }

    /**
     * Gets snapshot data for a cryptocurrency pair
     * @param fromSym The symbol (cryptocurrency or currency) to convert from
     * @param toSym The symbol (cryptocurrency or currency) to convert to
     * @return PairSnapshot A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public PairSnapshot getPairSnapshot(String fromSym, String toSym) throws IOException, OutOfCallsException {
        String formattedUrl = String.format("https://www.cryptocompare.com/api/data/coinsnapshot/?fsym=%s&tsym=%s",
                fromSym.toUpperCase(), toSym.toUpperCase());
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        return new Gson().fromJson(r, PairSnapshot.class);
    }

    /**
     * Gets snapshot data for a single cryptocurrency
     * @param id The id representing the cryptocurrency on CryptoCompare's website
     * @return CoinSnapshot A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public CoinSnapshot getCoinSnapshot(int id) throws IOException, OutOfCallsException {
        String formattedUrl = "https://www.cryptocompare.com/api/data/coinsnapshotfullbyid/?id=" + id;
        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        return new Gson().fromJson(r, CoinSnapshot.class);
    }
}
