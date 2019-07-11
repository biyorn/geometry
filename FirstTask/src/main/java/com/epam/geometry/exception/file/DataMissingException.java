package com.epam.geometry.exception.file;

public class DataMissingException extends Exception {

    public DataMissingException() {
    }

    public DataMissingException(String message) {
        super(message);
    }

    public DataMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataMissingException(Throwable cause) {
        super(cause);
    }
}
