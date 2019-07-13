package com.epam.geometry.exception.parameters;

public class ParametersNotValidException extends Exception {

    public ParametersNotValidException() {
    }

    public ParametersNotValidException(String message) {
        super(message);
    }

    public ParametersNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParametersNotValidException(Throwable cause) {
        super(cause);
    }
}
