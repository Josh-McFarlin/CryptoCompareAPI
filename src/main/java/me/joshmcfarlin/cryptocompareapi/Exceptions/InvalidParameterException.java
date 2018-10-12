package me.joshmcfarlin.cryptocompareapi.Exceptions;

/**
 * Represents an error when a provided parameter does not meet the guidelines of the API
 * @author Josh McFarlin
 */
public class InvalidParameterException extends Exception {
    /**
     * Creates an exception to be called when a parameter is incorrect
     * @param message The error message to be displayed
     */
    public InvalidParameterException(String message) {
        super(message);
    }
}
