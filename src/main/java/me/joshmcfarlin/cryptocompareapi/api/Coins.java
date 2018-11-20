package me.joshmcfarlin.cryptocompareapi.api;

import com.google.gson.Gson;
import me.joshmcfarlin.cryptocompareapi.CryptoCompareAPIConstant;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;
import me.joshmcfarlin.cryptocompareapi.models.coin.CoinList;
import me.joshmcfarlin.cryptocompareapi.models.coin.CoinSnapshot;
import me.joshmcfarlin.cryptocompareapi.models.coin.PairSnapshot;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;

import java.io.IOException;
import java.io.Reader;

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
        Reader r = Connection.getJSONWithLimitVerif(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/all/coinlist");

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
        String formattedUrl = String.format(CryptoCompareAPIConstant.CRYPTO_API_URL + "/coinsnapshot/?fsym=%s&tsym=%s",
                fromSym.toUpperCase(), toSym.toUpperCase());
        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

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
        String formattedUrl = CryptoCompareAPIConstant.CRYPTO_API_URL + "/coinsnapshotfullbyid/?id=" + id;
        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

        return new Gson().fromJson(r, CoinSnapshot.class);
    }
}
