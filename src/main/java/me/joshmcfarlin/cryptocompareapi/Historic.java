package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.Exceptions.InvalidParameterException;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.util.List;
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
    public static History getMinute(String fSym, String tSym, Boolean tryConversion, String e,
                                    Integer aggregate, Boolean aggregatePredictableTimePeriods,
                                    Integer limit, Integer toTs, String extraParams, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSym.length() > 10) {
            throw new InvalidParameterException("The max character length of tSym is 10!");
        }

        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/histominute?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > 30) throw new InvalidParameterException("The max character length of e is 30!");
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
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.HISTO);

        return new Gson().fromJson(r, History.class);
    }

    /**
     * @see Historic#getMinute(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public static History getMinute(String fSym, String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getMinute(fSym, tSym, null, null, null, null, null, null, null, null);
    }

    /**
     * @see Historic#getMinute(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public static History getMinute(String fSym, String tSym, Integer limit) throws IOException, OutOfCallsException, InvalidParameterException {
        return getMinute(fSym, tSym, null, null, null, null, limit, null, null, null);
    }

    /**
     * @see Historic#getMinute(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public static History getMinute(String fSym, String tSym, Integer limit, Integer toTs) throws IOException, OutOfCallsException, InvalidParameterException {
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
    public static History getHour(String fSym, String tSym, Boolean tryConversion, String e,
                                  Integer aggregate, Boolean aggregatePredictableTimePeriods,
                                  Integer limit, Integer toTs, String extraParams, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSym.length() > 10) {
            throw new InvalidParameterException("The max character length of tSym is 10!");
        }

        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/histohour?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > 30) throw new InvalidParameterException("The max character length of e is 30!");
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
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.HISTO);

        return new Gson().fromJson(r, History.class);
    }

    /**
     * @see Historic#getHour(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public static History getHour(String fSym, String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getHour(fSym, tSym, null, null, null, null, null, null, null, null);
    }

    /**
     * @see Historic#getHour(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public static History getHour(String fSym, String tSym, Integer limit) throws IOException, OutOfCallsException, InvalidParameterException {
        return getHour(fSym, tSym, null, null, null, null, limit, null, null, null);
    }

    /**
     * @see Historic#getHour(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public static History getHour(String fSym, String tSym, Integer limit, Integer toTs) throws IOException, OutOfCallsException, InvalidParameterException {
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
    public static History getDay(String fSym, String tSym, Boolean tryConversion, String e,
                                 Integer aggregate, Boolean aggregatePredictableTimePeriods,
                                 Integer limit, Integer toTs, String extraParams, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSym.length() > 10) {
            throw new InvalidParameterException("The max character length of tSym is 10!");
        }

        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/histoday?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > 30) throw new InvalidParameterException("The max character length of e is 30!");
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
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.HISTO);

        return new Gson().fromJson(r, History.class);
    }

    /**
     * @see Historic#getDay(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public static History getDay(String fSym, String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getDay(fSym, tSym, null, null, null, null, null, null, null, null);
    }

    /**
     * @see Historic#getDay(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public static History getDay(String fSym, String tSym, Integer limit) throws IOException, OutOfCallsException, InvalidParameterException {
        return getDay(fSym, tSym, null, null, null, null, limit, null, null, null);
    }

    /**
     * @see Historic#getDay(String, String, Boolean, String, Integer, Boolean, Integer, Integer, String, Boolean)
     */
    public static History getDay(String fSym, String tSym, Integer limit, Integer toTs) throws IOException, OutOfCallsException, InvalidParameterException {
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
     * @throws OutOfCallsException when no more API calls are available
     */
    public static Map getPriceAtTime(String fSym, String tSyms, Boolean tryConversion, Integer ts,
                                     String e, String extraParams, CalcType calculationType, Boolean sign) throws IOException, OutOfCallsException, InvalidParameterException {
        if (fSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSyms.length() > 30) {
            throw new InvalidParameterException("The max character length of tSyms is 30!");
        }

        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/pricehistorical?fsym=%s&tsyms=%s",
                fSym.toUpperCase(), tSyms.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (ts != null) {
            formattedUrl += "&ts=" + ts;
        }

        if (e != null) {
            if (e.length() > 30) throw new InvalidParameterException("The max character length of e is 30!");
            formattedUrl += "&e=" + e;
        }

        if (extraParams != null) {
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (calculationType != null) {
            formattedUrl += "&calculationType=" + calculationType.getText();
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.HISTO);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        return new Gson().fromJson(jsonObject.get(fSym), Map.class);
    }

    /**
     * @see Historic#getPriceAtTime(String, String, Boolean, Integer, String, String, CalcType, Boolean)
     */
    public static Map getPriceAtTime(String fSym, String tSyms, Integer ts) throws IOException, OutOfCallsException, InvalidParameterException {
        return getPriceAtTime(fSym, tSyms, null, ts, null, null, null, null);
    }

    /**
     * @see Historic#getPriceAtTime(String, String, Boolean, Integer, String, String, CalcType, Boolean)
     */
    public static Map getPriceAtTime(String fSym, String tSyms, Integer ts, String e) throws IOException, OutOfCallsException, InvalidParameterException {
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
    public static Double getDayAverage(String fSym, String tSym, Boolean tryConversion, String e, AverageType avgType,
                                       Integer UTCHourDiff, Integer toTs, String extraParams, Boolean sign) throws
            IOException, OutOfCallsException, InvalidParameterException {

        if (fSym.length() > 10) {
            throw new InvalidParameterException("The max character length of fSym is 10!");
        }

        if (tSym.length() > 30) {
            throw new InvalidParameterException("The max character length of tSyms is 10!");
        }

        String formattedUrl = String.format("https://min-api.cryptocompare.com/data/dayAvg?fsym=%s&tsym=%s",
                fSym.toUpperCase(), tSym.toUpperCase());

        if (tryConversion != null) {
            formattedUrl += "&tryConversion=" + tryConversion.toString();
        }

        if (e != null) {
            if (e.length() > 30) throw new InvalidParameterException("The max character length of e is 30!");
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
            if (extraParams.length() > 2000) throw new InvalidParameterException("The max character length of extraParams is 2000!");
            formattedUrl += "&extraParams=" + extraParams;
        }

        if (sign != null) {
            formattedUrl += "&sign=" + sign.toString();
        }

        Reader r = Connection.getJSON(formattedUrl, CallTypes.PRICE);

        JsonObject jsonObject = new Gson().fromJson(r, JsonObject.class);
        return jsonObject.get(tSym).getAsDouble();
    }

    /**
     * @see Historic#getDayAverage(String, String, Boolean, String, AverageType, Integer, Integer, String, Boolean)
     */
    public static Double getDayAverage(String fSym, String tSym) throws IOException, OutOfCallsException, InvalidParameterException {
        return getDayAverage(fSym, tSym, null, null, null, null, null, null, null);
    }

    /*
    TODO:
    * Historical Daily Exchange Volume
    * Historical Hourly Exchange Volume
     */

    /**
     * Represents Average Type used by the API
     */
    public enum AverageType {
        /**
         * A VWAP of the hourly close price
         */
        HOURVWAP("HourVWAP"),
        /**
         * The average between the 24H high and low
         */
        MIDHIGHLOW("MidHighLow"),
        /**
         * The total volume from / the total volume to (only avilable with tryConversion set to false)
         */
        VOLFVOLT("VolFVolT");

        /**
         * The text that will be passed to the API call
         */
        private String text;

        AverageType(String text) {
            this.text = text;
        }

        /**
         * {@link AverageType#text}
         */
        public String getText() {
            return text;
        }
    }

    /**
     * Represents Calculation Type used by the API
     */
    public enum CalcType {
        /**
         * A close of the day close price
         */
        CLOSE("Close"),
        /**
         * The average between the 24H high and low
         */
        MIDHIGHLOW("MidHighLow"),
        /**
         * The total volume to / the total volume from
         */
        VOLFVOLT("VolFVolT");

        /**
         * The text that will be passed to the API call
         */
        private String text;

        CalcType(String text) {
            this.text = text;
        }

        /**
         * {@link CalcType#text}
         */
        public String getText() {
            return text;
        }
    }

    /**
     * Represents historic data provided by the CryptoCompare API
     */
    public static class History {
        /**
         * Indicates request success
         */
        @SerializedName("Response")
        private String response;

        /**
         * Indicates HTML request response type
         */
        @SerializedName("Type")
        private int type;

        /**
         * Historic data returned by the API
         */
        @SerializedName("Data")
        private List<Data> data;

        /**
         * Indicates the Unix starting time of the request
         */
        @SerializedName("TimeTo")
        private int timeTo;

        /**
         * Indicates the Unix ending time of the request
         */
        @SerializedName("TimeFrom")
        private int timeFrom;

        /**
         * Indicates first value in array
         */
        @SerializedName("FirstValueInArray")
        private boolean firstValueInArray;

        /**
         * Indicates if a currency conversion was used to get the data
         */
        @SerializedName("ConversionType")
        private ConversionType conversionType;

        /**
         * Indicates if the data was aggregated
         */
        @SerializedName("Aggregated")
        private boolean aggregated;

        /**
         * {@link History#response}
         */
        public String getResponse() {
            return response;
        }

        /**
         * {@link History#type}
         */
        public int getType() {
            return type;
        }

        /**
         * {@link History#data}
         */
        public List<Data> getData() {
            return data;
        }

        /**
         * {@link History#timeTo}
         */
        public int getTimeTo() {
            return timeTo;
        }

        /**
         * {@link History#timeFrom}
         */
        public int getTimeFrom() {
            return timeFrom;
        }

        /**
         * {@link History#firstValueInArray}
         */
        public boolean isFirstValueInArray() {
            return firstValueInArray;
        }

        /**
         * {@link History#conversionType}
         */
        public ConversionType getConversionType() {
            return conversionType;
        }

        /**
         * {@link History#aggregated}
         */
        public boolean isAggregated() {
            return aggregated;
        }

        /**
         * Represents data returned by the API
         */
        public static class Data {
            /**
             * Represents Unix time
             */
            private int time;

            /**
             * Symbol close on provided date
             */
            private double close;

            /**
             * Symbol high on provided date
             */
            private double high;

            /**
             * Symbol low on provided date
             */
            private double low;

            /**
             * Symbol open on provided date
             */
            private double open;

            /**
             * Volume from the symbol on provided date
             */
            @SerializedName("volumefrom")
            private double volumeFrom;

            /**
             * Volume to the symbol on provided date
             */
            @SerializedName("volumeto")
            private double volumeTo;

            /**
             * {@link Data#time}
             */
            public int getTime() {
                return time;
            }

            /**
             * {@link Data#close}
             */
            public double getClose() {
                return close;
            }

            /**
             * {@link Data#high}
             */
            public double getHigh() {
                return high;
            }

            /**
             * {@link Data#low}
             */
            public double getLow() {
                return low;
            }

            /**
             * {@link Data#open}
             */
            public double getOpen() {
                return open;
            }

            /**
             * {@link Data#volumeFrom}
             */
            public double getVolumeFrom() {
                return volumeFrom;
            }

            /**
             * {@link Data#volumeTo}
             */
            public double getVolumeTo() {
                return volumeTo;
            }
        }

        /**
         * Represents a conversion type between cryptocurrencies or currencies
         */
        public static class ConversionType {
            /**
             * The type of currency used to make the conversion
             */
            private String type;

            /**
             * The symbol of the currency used in the conversion
             */
            private String conversionSymbol;

            /**
             * {@link ConversionType#type}
             */
            public String getType() {
                return type;
            }

            /**
             * {@link ConversionType#conversionSymbol}
             */
            public String getConversionSymbol() {
                return conversionSymbol;
            }
        }
    }
}
