package me.joshmcfarlin.cryptocompareapi.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.CryptoCompareAPIConstant;
import me.joshmcfarlin.cryptocompareapi.Exceptions.InvalidParameterException;
import me.joshmcfarlin.cryptocompareapi.models.exchanges.Exchange;
import me.joshmcfarlin.cryptocompareapi.models.exchanges.ExchangeList;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about Exchanges listed by CryptoCompare
 * @author Josh McFarlin
 */
public class Exchanges {

    /**
     * Gets all available trading pairs for each cryptocurrency on all exchanges available from the API
     * @return ExchangeList a object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public ExchangeList getAllExchanges() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/all/exchanges", CallTypes.PRICE);

        Type type = new TypeToken<Map<String, Map<String, List<String>>>>() {}.getType();
        Map<String, Map<String, List<String>>> exchangeMap = new Gson().fromJson(r, type);
        return new ExchangeList(exchangeMap);
    }

    /**
     * Finds the top exchanges for a provided pair
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSym The currency symbol to convert into [Max character length: 10]
     * @param limit The number of data points to return
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return TopExchanges a object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     * @throws InvalidParameterException when a given parameter does not meet the API guidelines
     */
    public List<Exchange> getTopExchanges(String fSym, String tSym, Integer limit, String extraParams, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fromSym is 10!");
        }

        if (tSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fromSym is 10!");
        }

        String formattedUrl = String.format(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/top/exchanges?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (limit != null) {
            formattedUrl += "&limit=" + limit;
        }

        if (extraParams != null) {
            if (extraParams.length() > CryptoCompareAPIConstant.EXTRA_PARAM_MAX_LENGTH) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<List<Exchange>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("Data"), type);
    }

    /**
     * @see Exchanges#getTopExchanges(String, String, Integer, String, Boolean)
     */
    public List<Exchange> getTopExchanges(String fSym, String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getTopExchanges(fSym, tSym, null, null, null);
    }

    /**
     * @see Exchanges#getTopExchanges(String, String, Integer, String, Boolean)
     */
    public List<Exchange> getTopExchanges(String fSym, String tSym, Integer limit) throws IOException, OutOfCallsException, InvalidParameterException {
        return getTopExchanges(fSym, tSym, limit, null, null);
    }
}
