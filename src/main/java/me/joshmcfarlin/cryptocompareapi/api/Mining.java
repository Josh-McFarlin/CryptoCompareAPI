package me.joshmcfarlin.cryptocompareapi.api;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.models.mining.Coin;
import me.joshmcfarlin.cryptocompareapi.models.mining.Contract;
import me.joshmcfarlin.cryptocompareapi.models.mining.Contracts;
import me.joshmcfarlin.cryptocompareapi.models.mining.Equipment;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.util.Map;

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
        Reader r = Connection.getJSON("https://www.cryptocompare.com/api/data/miningcontracts/", CallTypes.OTHER);

        return new Gson().fromJson(r, Contracts.class);
    }

    /**
     * Gets information about different mining equipment
     * @return Equipment A object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public Equipment getEquipment() throws IOException, OutOfCallsException {
        Reader r = Connection.getJSON("https://www.cryptocompare.com/api/data/miningequipment/", CallTypes.OTHER);

        return new Gson().fromJson(r, Equipment.class);
    }


}
