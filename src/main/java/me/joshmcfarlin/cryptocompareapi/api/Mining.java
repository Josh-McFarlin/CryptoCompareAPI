package me.joshmcfarlin.cryptocompareapi.api;

import com.google.gson.Gson;
import me.joshmcfarlin.cryptocompareapi.CryptoCompareAPIConstant;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;
import me.joshmcfarlin.cryptocompareapi.models.mining.Contracts;
import me.joshmcfarlin.cryptocompareapi.models.mining.Equipment;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;

import java.io.IOException;
import java.io.Reader;

/**
 * Contains methods for requesting information about cryptocurrency mining
 * @author Josh McFarlin
 */
public class Mining {


	/**
     * Gets information about recent mining contracts
     * @return Contracts A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public Contracts getContracts() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSONWithLimitVerif(CryptoCompareAPIConstant.CRYPTO_API_URL + "/miningcontracts/");

        return new Gson().fromJson(r, Contracts.class);
    }

    /**
     * Gets information about different mining equipment
     * @return Equipment A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public Equipment getEquipment() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSONWithLimitVerif(CryptoCompareAPIConstant.CRYPTO_API_URL + "/miningequipment/");

        return new Gson().fromJson(r, Equipment.class);
    }


}
