package me.joshmcfarlin.cryptocompareapi.Exceptions;

/**
 * Represents an error when no more API calls remain
 * @author Josh McFarlin
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
