package me.joshmcfarlin.cryptocompareapi.Utils;

/**
 * Represents an error when no more API calls remain
 * @author joshuamcfarlin
 * @version 1
 */
public class OutOfCallsException extends Exception {
    /**
     * Creates an exception to be called when no more API remain
     * @param message The error message to be displayed
     */
    public OutOfCallsException(String message) {
        super(message);
    }
}
