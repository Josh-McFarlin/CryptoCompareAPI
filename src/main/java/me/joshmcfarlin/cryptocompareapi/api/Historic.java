package me.joshmcfarlin.cryptocompareapi.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import me.joshmcfarlin.cryptocompareapi.CryptoCompareAPIConstant;
import me.joshmcfarlin.cryptocompareapi.Exceptions.InvalidParameterException;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;
import me.joshmcfarlin.cryptocompareapi.models.historic.AverageType;
import me.joshmcfarlin.cryptocompareapi.models.historic.CalcType;
import me.joshmcfarlin.cryptocompareapi.models.historic.History;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

/**
 * Contains methods for requesting information about historic cryptocurrency prices
 * @author Josh McFarlin
 */
public class Historic {

    /**
     * Get market data for a symbol pair by minute up to to the provided limit
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSym The currency symbol to convert into [Max character length: 10]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param aggregate Time period to aggregate the data over (for daily it's days, for hourly it's hours and for minute histo it's minutes)
     * @param aggregatePredictableTimePeriods True by default, only used when the aggregate param is also in use. If false it will aggregate based on the current time.
     * @param limit The number of data points to return
     * @param toTs Last unix timestamp to return data for
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return History A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public History getMinute(String fSym, String tSym, Boolean tryConversion, String e,
                                    Integer aggregate, Boolean aggregatePredictableTimePeriods,
                                    Integer limit, Integer toTs, String extraParams, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of tSym is 10!");
        }

        String formattedUrl = String.format(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/histominute?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > CryptoCompareAPIConstant.EXCHANGE_FROM_MAX_LENGTH){
                throw new InvalidParameterException("The max character length of e is 30!");
            }
            formattedUrl += "&e=" + e;
        }

        if (aggregate != null) {
            formattedUrl += "&aggregate=" + aggregate;

            if (aggregatePredictableTimePeriods != null) {
                formattedUrl += "&aggregatePredictableTimePeriods=" + aggregatePredictableTimePeriods.toString();
            }
        }

        if (limit != null) {
            formattedUrl += "&limit=" + limit;
        }

        if (toTs != null) {
            formattedUrl += "&toTs=" + toTs;
        }

        if (extraParams != null) {
            if (extraParams.length() > CryptoCompareAPIConstant.EXTRA_PARAM_MAX_LENGTH){
                throw new InvalidParameterException("The max character length of extraParams is 2000!");
            }
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

        return new Gson().fromJson(r, History.class);
    }

    /**
     * @see Historic#getMinute(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public History getMinute(String fSym, String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getMinute(fSym, tSym, null, null, null, null, null, null, null, null);
    }

    /**
     * @see Historic#getMinute(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public History getMinute(String fSym, String tSym, Integer limit) throws IOException, OutOfCallsException, InvalidParameterException {
        return getMinute(fSym, tSym, null, null, null, null, limit, null, null, null);
    }

    /**
     * @see Historic#getMinute(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public History getMinute(String fSym, String tSym, Integer limit, Integer toTs) throws IOException, OutOfCallsException, InvalidParameterException {
        return getMinute(fSym, tSym, null, null, null, null, limit, toTs, null, null);
    }

    /**
     * Gets market data for a symbol pair by hour up to to the provided limit
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSym The currency symbol to convert into [Max character length: 10]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param aggregate Time period to aggregate the data over (for daily it's days, for hourly it's hours and for minute histo it's minutes)
     * @param aggregatePredictableTimePeriods True by default, only used when the aggregate param is also in use. If false it will aggregate based on the current time.
     * @param limit The number of data points to return
     * @param toTs Last unix timestamp to return data for
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return History A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public History getHour(String fSym, String tSym, Boolean tryConversion, String e,
                                  Integer aggregate, Boolean aggregatePredictableTimePeriods,
                                  Integer limit, Integer toTs, String extraParams, Boolean sign)
			throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of tSym is 10!");
        }

        String formattedUrl = String.format(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/histohour?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > CryptoCompareAPIConstant.EXCHANGE_FROM_MAX_LENGTH){
                throw new InvalidParameterException("The max character length of e is 30!");
            }
            formattedUrl += "&e=" + e;
        }

        if (aggregate != null) {
            formattedUrl += "&aggregate=" + aggregate;

            if (aggregatePredictableTimePeriods != null) {
                formattedUrl += "&aggregatePredictableTimePeriods=" + aggregatePredictableTimePeriods.toString();
            }
        }

        if (limit != null) {
            formattedUrl += "&limit=" + limit;
        }

        if (toTs != null) {
            formattedUrl += "&toTs=" + toTs;
        }

        if (extraParams != null) {
            if (extraParams.length() > CryptoCompareAPIConstant.EXTRA_PARAM_MAX_LENGTH){
                throw new InvalidParameterException("The max character length of extraParams is 2000!");
            }
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

        return new Gson().fromJson(r, History.class);
    }

    /**
     * @see Historic#getHour(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public History getHour(String fSym, String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getHour(fSym, tSym, null, null, null, null, null, null, null, null);
    }

    /**
     * @see Historic#getHour(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public History getHour(String fSym, String tSym, Integer limit) throws IOException, OutOfCallsException, InvalidParameterException {
        return getHour(fSym, tSym, null, null, null, null, limit, null, null, null);
    }

    /**
     * @see Historic#getHour(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public History getHour(String fSym, String tSym, Integer limit, Integer toTs) throws IOException, OutOfCallsException, InvalidParameterException {
        return getHour(fSym, tSym, null, null, null, null, limit, toTs, null, null);
    }

    /**
     * Gets market data for a symbol pair by day up to to the provided limit
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSym The currency symbol to convert into [Max character length: 10]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param aggregate Time period to aggregate the data over (for daily it's days, for hourly it's hours and for minute histo it's minutes)
     * @param aggregatePredictableTimePeriods True by default, only used when the aggregate param is also in use. If false it will aggregate based on the current time.
     * @param limit The number of data points to return
     * @param toTs Last unix timestamp to return data for
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return History A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public History getDay(String fSym, String tSym, Boolean tryConversion, String e,
                                 Integer aggregate, Boolean aggregatePredictableTimePeriods,
                                 Integer limit, Integer toTs, String extraParams, Boolean sign)
			throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of tSym is 10!");
        }

        String formattedUrl = String.format(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/histoday?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > CryptoCompareAPIConstant.EXCHANGE_FROM_MAX_LENGTH){
                throw new InvalidParameterException("The max character length of e is 30!");
            }
            formattedUrl += "&e=" + e;
        }

        if (aggregate != null) {
            formattedUrl += "&aggregate=" + aggregate;

            if (aggregatePredictableTimePeriods != null) {
                formattedUrl += "&aggregatePredictableTimePeriods=" + aggregatePredictableTimePeriods.toString();
            }
        }

        if (limit != null) {
            formattedUrl += "&limit=" + limit;
        }

        if (toTs != null) {
            formattedUrl += "&toTs=" + toTs;
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

        return new Gson().fromJson(r, History.class);
    }

    /**
     * @see Historic#getDay(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public History getDay(String fSym, String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getDay(fSym, tSym, null, null, null, null, null, null, null, null);
    }

    /**
     * @see Historic#getDay(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public History getDay(String fSym, String tSym, Integer limit) throws IOException, OutOfCallsException, InvalidParameterException {
        return getDay(fSym, tSym, null, null, null, null, limit, null, null, null);
    }

    /**
     * @see Historic#getDay(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public History getDay(String fSym, String tSym, Integer limit, Integer toTs) throws IOException, OutOfCallsException, InvalidParameterException {
        return getDay(fSym, tSym, null, null, null, null, limit, toTs, null, null);
    }

    /**
     * Gets the price of a symbol pair at an input Unix time
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSyms Comma separated cryptocurrency symbols list to convert into [Max character length: 30]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param ts The unix timestamp of interest
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param calculationType Type of average to calculate (Close - a Close of the day close price, MidHighLow - the average between the 24 H high and low, VolFVolT - the total volume to / the total volume from)
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return Map containing information about price at input time
     * @throws IOException when a connection cannot be made
     */
    public Map getPriceAtTime(String fSym, String tSyms, Boolean tryConversion, Integer ts,
							  String e, String extraParams, CalcType calculationType, Boolean sign)
            throws IOException, InvalidParameterException, OutOfCallsException {
        if (fSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSyms.length() > CryptoCompareAPIConstant.SYMBOL_LIST_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of tSyms is 30!");
        }

        String formattedUrl = String.format(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/pricehistorical?fsym=%s&tsyms=%s",
                fSym.toUpperCase(), tSyms.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (ts != null) {
            formattedUrl += "&ts=" + ts;
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

        if (calculationType != null) {
            formattedUrl += "&calculationType=" + calculationType.getText();
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSONWithLimitVerif(formattedUrl);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        return new Gson().fromJson(jsonObject.get(fSym), Map.class);
    }

    /**
     * @see Historic#getPriceAtTime(String, String, Boolean, Integer, String, String, CalcType, Boolean)
     */
    public Map getPriceAtTime(String fSym, String tSyms, Integer ts) throws IOException, OutOfCallsException, InvalidParameterException {
        return getPriceAtTime(fSym, tSyms, null, ts, null, null, null, null);
    }

    /**
     * @see Historic#getPriceAtTime(String, String, Boolean, Integer, String, String, CalcType, Boolean)
     */
    public Map getPriceAtTime(String fSym, String tSyms, Integer ts, String e) throws IOException, OutOfCallsException, InvalidParameterException {
        return getPriceAtTime(fSym, tSyms, null, ts, e, null, null, null);
    }

    /**
     * Gets the current day price average for a symbol pair
     * @param fSym The cryptocurrency symbol of interest [Max character length: 10]
     * @param tSym The currency symbol to convert into [Max character length: 10]
     * @param tryConversion If set to false, it will try to get only direct trading values
     * @param e The exchange to obtain data from (our aggregated average - CCCAGG - by default) [Max character length: 30]
     * @param avgType Type of average to calculate (HourVWAP - a HourVWAP of hourly price, MidHighLow - the average between the 24 H high and low, VolFVolT - the total volume to / the total volume from)
     * @param UTCHourDiff By default it does UTC, if you want a different time zone just pass the hour difference. For PST you would pass -8 for example.
     * @param toTs Last unix timestamp to return data for
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     * @return Double A number containing the day average
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public Double getDayAverage(String fSym, String tSym, Boolean tryConversion, String e, AverageType avgType,
                                       Integer UTCHourDiff, Integer toTs, String extraParams, Boolean sign) throws
            IOException, OutOfCallsException, InvalidParameterException {

        if (fSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSym.length() > CryptoCompareAPIConstant.SYMBOL_MAX_LENGTH) {
            throw new InvalidParameterException("The max character length of tSyms is 10!");
        }

        String formattedUrl = String.format(CryptoCompareAPIConstant.MINI_CRYPTO_API_URL + "/dayAvg?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > CryptoCompareAPIConstant.AVERAGE_TYPE_MAX_LENGTH) {
                throw new InvalidParameterException("The max character length of e is 30!");
            }
            formattedUrl += "&e=" + e;
        }

        if (avgType != null) {
            formattedUrl += "&avgType=" + avgType.getText();
        }

        if (UTCHourDiff != null) {
            formattedUrl += "&UTCHourDiff=" + UTCHourDiff;
        }

        if (toTs != null) {
            formattedUrl += "&toTs=" + toTs;
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
        return jsonObject.get(tSym).getAsDouble();
    }

    /**
     * @see Historic#getDayAverage(String, String, Boolean, String, AverageType, Integer, Integer, String, Boolean)
     */
    public Double getDayAverage(String fSym, String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getDayAverage(fSym, tSym, null, null, null, null, null, null, null);
    }

    /*
    TODO:
    * Historical Daily Exchange Volume
    * Historical Hourly Exchange Volume
     */
}
