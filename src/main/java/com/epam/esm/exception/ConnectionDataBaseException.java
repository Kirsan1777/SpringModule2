package com.epam.esm.exception;

/**
 * Class of data base exception
 */
public class ConnectionDataBaseException extends Exception {

    public ConnectionDataBaseException() {
    }

    public ConnectionDataBaseException(String message) {
        super(message);
    }

    public ConnectionDataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionDataBaseException(Throwable cause) {
        super(cause);
    }
}