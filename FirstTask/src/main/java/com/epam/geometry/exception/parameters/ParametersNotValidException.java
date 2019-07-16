package com.epam.geometry.exception.parameters;

import com.epam.geometry.exception.DataMissingException;

public class ParametersNotValidException extends DataMissingException {

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
