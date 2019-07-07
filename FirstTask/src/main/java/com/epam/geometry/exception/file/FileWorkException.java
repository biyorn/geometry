package com.epam.geometry.exception.file;

public class FileWorkException extends Exception {

    public FileWorkException() {
    }

    public FileWorkException(String message) {
        super(message);
    }

    public FileWorkException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileWorkException(Throwable cause) {
        super(cause);
    }
}
