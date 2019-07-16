package com.epam.geometry.exception.file;

import com.epam.geometry.exception.DataMissingException;

public class PathToFileIsWrongException extends DataMissingException {

    public PathToFileIsWrongException() {
    }

    public PathToFileIsWrongException(String message) {
        super(message);
    }

    public PathToFileIsWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public PathToFileIsWrongException(Throwable cause) {
        super(cause);
    }
}
