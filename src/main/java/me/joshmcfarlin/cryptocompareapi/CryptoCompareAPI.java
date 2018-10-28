package me.joshmcfarlin.cryptocompareapi;

import me.joshmcfarlin.cryptocompareapi.api.*;

/**
 * The class's default class to access all the methods
 */
public class CryptoCompareAPI {
    public Coins coins;
    public Exchanges exchanges;
    public Historic historic;
    public Market market;
    public Mining mining;
    public News news;
    public Social social;

    private String extraParams;
    private Boolean sign;

    /**
     * Sets extraParams and sign to null
     * @see #CryptoCompareAPI(String, Boolean)
     */
    public CryptoCompareAPI() {
        this(null, null);
    }

    /**
     * Only instantiates the object with extraParams, sign is set to null
     * @see #CryptoCompareAPI(String, Boolean)
     */
    public CryptoCompareAPI(String extraParams) {
        this(extraParams, null);
    }

    /**
     * Only instantiates the object with sign, extraParams is set to null
     * @see #CryptoCompareAPI(String, Boolean)
     */
    public CryptoCompareAPI(Boolean sign) {
        this(null, sign);
    }

    /**
     * Creates an object to access all the API methods
     * @param extraParams The name of your application (we recommend you send it) [Max character length: 2000]
     * @param sign If set to true, the server will sign the requests (by default we don't sign them), this is useful for usage in smart contracts
     */
    public CryptoCompareAPI(String extraParams, Boolean sign) {
        this.extraParams = extraParams;
        this.sign = sign;

        coins = new Coins();
        exchanges = new Exchanges();
        historic = new Historic();
        market = new Market();
        mining = new Mining();
        news = new News();
        social = new Social();
    }

    /**
     * {@link CryptoCompareAPI#extraParams}
     */
    public String getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(String extraParams) {
        this.extraParams = extraParams;
    }

    /**
     * {@link CryptoCompareAPI#sign}
     */
    public Boolean getSign() {
        return sign;
    }

    public void setSign(Boolean sign) {
        this.sign = sign;
    }
}
