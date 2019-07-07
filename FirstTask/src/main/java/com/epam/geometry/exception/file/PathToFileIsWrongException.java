package com.epam.geometry.exception.file;

public class PathToFileIsWrongException extends FileWorkException {

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
