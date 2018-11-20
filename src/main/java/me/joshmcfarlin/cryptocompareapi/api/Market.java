package me.joshmcfarlin.cryptocompareapi.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import me.joshmcfarlin.cryptocompareapi.CryptoCompareAPIConstant;
import me.joshmcfarlin.cryptocompareapi.Exceptions.InvalidParameterException;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;
import me.joshmcfarlin.cryptocompareapi.models.market.Coin;
import me.joshmcfarlin.cryptocompareapi.models.market.ExchangeAverage;
import me.joshmcfarlin.cryptocompareapi.models.market.Pair;
import me.joshmcfarlin.cryptocompareapi.models.market.ToSym;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for requesting information about the cryptocurrency market on multiple exchanges
 * @author Josh McFarlin
 */
public class Market {

    public static final int MULTI_PRICE_FROM_SYMBOL_LIST_MAX_LENGTH = 300;
    public static final int MULTI_PRICE_TO_SYMBOL_LIST_MAX_LENGTH = 100;

    /**
     * Gets price of an input symbol in multiple output symbols
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSyms Comma separated cryptocurrency symbols list to convert into [Max character length: 500]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return Map containing price for each to-symbol
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public Map<String, Double> getPrice(String fSym, String tSyms, Boolean tryConversion, String e, String extraParams, Boolean sign)
			throws IOException, OutOfCallsException, InvalidParameterException {

        if (fSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSyms.length() > CryptoCompareAPIConstant.SYMBOL_LONG_LIST_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of tSyms is 500!");
        }

        String formattedUrl = String.format(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/price?fsym=%s&tsyms=%s",
                fSym.toUpperCase(), tSyms.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > CryptoCompareAPIConstant.EXCHANGE_FROM_MAX_LENGTH) {
                throw new InvalidParameterException("The max character length of e is 30!");
            }
            formattedUrl += "&e=" + e;
        }

        if (extraParams != null) {
            if (extraParams.length() > CryptoCompareAPIConstant.EXTRA_PARAM_MAX_LENGTH) {
                throw new InvalidParameterException("The max character length of extraParams is 2000!");
            }
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

        Type type = new TypeToken<Map<String, Double>>() {}.getType();
        return new Gson().fromJson(r, type);
    }

    /**
     * @see Market#getPrice(String, String, Boolean, String, String, Boolean)
     */
    public Map<String, Double> getPrice(String fSym, String tSyms) throws
            IOException, OutOfCallsException, InvalidParameterException {
        return getPrice(fSym, tSyms, null, null, null, null);
    }

    /**
     * Gets price of an input symbol in multiple output symbols
     * @param fSyms Comma separated cryptocurrency symbols list [Max character length: 300]
     * @param tSyms Comma separated cryptocurrency symbols list to convert into [Max character length: 100]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return Map containing price for each to-symbol
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public Map<String, Map<String, Double>> getMultiPrice(String fSyms, String tSyms, Boolean tryConversion, String e, String extraParams, Boolean sign) throws
            IOException, OutOfCallsException, InvalidParameterException {

        if (fSyms.length() > MULTI_PRICE_FROM_SYMBOL_LIST_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fSyms is 300!");
        }

        if (tSyms.length() > MULTI_PRICE_TO_SYMBOL_LIST_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of tSyms is 100!");
        }

        String formattedUrl = String.format(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/pricemulti?fsyms=%s&tsyms=%s",
                fSyms.toUpperCase(), tSyms.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > 30) throw new InvalidParameterException("The max character length of e is 30!");
            formattedUrl += "&e=" + e;
        }

        if (extraParams != null) {
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

        Type type = new TypeToken<Map<String, Map<String, Double>>>() {}.getType();
        return new Gson().fromJson(r, type);
    }

    /**
     * @see Market#getMultiPrice(String, String, Boolean, String, String, Boolean)
     */
    public Map<String, Map<String, Double>> getMultiPrice(String fSym, String tSyms) throws
            IOException, OutOfCallsException, InvalidParameterException {
        return getMultiPrice(fSym, tSyms, null, null, null, null);
    }

    /**
     * Gets full information about multiple input symbols to multiple output symbols
     * @param fSyms Comma separated cryptocurrency symbols list [Max character length: 300]
     * @param tSyms Comma separated cryptocurrency symbols list to convert into [Max character length: 100]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return Map containing price for each to-symbol
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public Map<String, Map<String, ToSym>> getMultiFull(String fSyms, String tSyms, Boolean tryConversion, String e, String extraParams, Boolean sign) throws
            IOException, OutOfCallsException, InvalidParameterException {

        if (fSyms.length() > MULTI_PRICE_FROM_SYMBOL_LIST_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fSyms is 300!");
        }

        if (tSyms.length() > MULTI_PRICE_TO_SYMBOL_LIST_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of tSyms is 100!");
        }

        String formattedUrl = String.format(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/pricemultifull?fsyms=%s&tsyms=%s",
                fSyms.toUpperCase(), tSyms.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > CryptoCompareAPIConstant.EXCHANGE_FROM_MAX_LENGTH) {
                throw new InvalidParameterException("The max character length of e is 30!");
            }
            formattedUrl += "&e=" + e;
        }

        if (extraParams != null) {
            if (extraParams.length() > CryptoCompareAPIConstant.EXTRA_PARAM_MAX_LENGTH) {
                throw new InvalidParameterException("The max character length of extraParams is 2000!");
            }
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<Map<String, Map<String, ToSym>>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("RAW"), type);
    }

    /**
     * @see Market#getMultiFull(String, String, Boolean, String, String, Boolean)
     */
    public Map<String, Map<String, ToSym>> getMultiFull(String fSym, String tSyms) throws
            IOException, OutOfCallsException, InvalidParameterException {
        return getMultiFull(fSym, tSyms, null, null, null, null);
    }

    /**
     * Gets the day average price for a symbol pair on multiple exchanges
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSym The currency symbol to convert into [Max character length: 10]
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 150]
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return ExchangeAverage A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public ExchangeAverage getExchangeAverage(String fSym, String tSym, String e, String extraParams, Boolean sign) throws
            IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fSyms is 10!");
        }

        if (tSym.length() > 10) {
            throw new InvalidParameterException("The max character length of tSym is 10!");
        }

        String formattedUrl = String.format(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/generateAvg?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (e != null) {
            if (e.length() > 150) {
                throw new InvalidParameterException("The max character length of e is 150!");
            }
            formattedUrl += "&e=" + e;
        }

        if (extraParams != null) {
            if (extraParams.length() > 2000) {
                throw new InvalidParameterException("The max character length of extraParams is 2000!");
            }
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        return new Gson().fromJson(jsonObject.getAsJsonObject("RAW"), ExchangeAverage.class);
    }

    /**
     * @see Market#getExchangeAverage(String, String, String, String, Boolean)
     */
    public ExchangeAverage getExchangeAverage(String fSym, String tSym, String e) throws
            IOException, OutOfCallsException, InvalidParameterException {
        return getExchangeAverage(fSym, tSym, e, null, null);
    }

    /**
     * @see Market#getExchangeAverage(String, String, String, String, Boolean)
     */
    public ExchangeAverage getExchangeAverage(String fSym, String tSym) throws
            IOException, OutOfCallsException, InvalidParameterException {
        return getExchangeAverage(fSym, tSym, "CCCAGG", null, null);
    }

    /**
     * Gets the top cryptocurrencies trading to the input symbol by volume
     * @param tSym The currency symbol to convert into [Max character length: 10]
     * @param limit The number of data points to return
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return TopVolumes A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public List<Coin> getTopVolumes(String tSym, Integer limit, String extraParams, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (tSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of tSym is 10!");
        }

        String formattedUrl = CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/top/volumes?tsym=" + tSym.toUpperCase();

        if (limit != null) {
            formattedUrl += "&limit=" + limit;
        }

        if (extraParams != null) {
            if (extraParams.length() > CryptoCompareAPIConstant.EXTRA_PARAM_MAX_LENGTH) {
                throw new InvalidParameterException("The max character length of extraParams is 2000!");
            }
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<List<Coin>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("Data"), type);
    }

    /**
     * @see Market#getTopVolumes(String, Integer, String, Boolean)
     */
    public List<Coin> getTopVolumes(String tSym, Integer limit) throws IOException, OutOfCallsException, InvalidParameterException {
        return getTopVolumes(tSym, limit, null, null);
    }

    /**
     * @see Market#getTopVolumes(String, Integer, String, Boolean)
     */
    public List<Coin> getTopVolumes(String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getTopVolumes(tSym, null, null, null);
    }

    /**
     * Gets the top trading pairs from an input symbol by volume
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param limit The number of data points to return
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return List A List of pair objects
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public List<Pair> getTopPairs(String fSym, Integer limit, String extraParams, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        String formattedUrl = CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/top/pairs?fsym=" + fSym.toUpperCase();

        if (limit != null) {
            formattedUrl += "&limit=" + limit;
        }

        if (extraParams != null) {
            if (extraParams.length() > CryptoCompareAPIConstant.EXTRA_PARAM_MAX_LENGTH) {
                throw new InvalidParameterException("The max character length of extraParams is 2000!");
            }
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        Type type = new TypeToken<List<Pair>>() {}.getType();
        return new Gson().fromJson(jsonObject.get("Data"), type);
    }

    /**
     * @see Market#getTopPairs(String, Integer, String, Boolean)
     */
    public List<Pair> getTopPairs(String fSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getTopPairs(fSym, null, null, null);
    }

}
