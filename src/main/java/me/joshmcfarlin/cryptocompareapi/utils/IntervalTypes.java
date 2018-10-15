package me.joshmcfarlin.cryptocompareapi.utils;

/**
 * Represents all available API call intervals
 * @author Josh McFarlin
 */
public enum IntervalTypes {
    SECOND("Second"),
    MINUTE("Minute"),
    HOUR("Hour");

    String apiName;

    IntervalTypes(String apiName) {
        this.apiName = apiName;
    }
}