package com.epam.geometry.exception.file;

public class FileNotReadException extends FileWorkException {

    public FileNotReadException() {
    }

    public FileNotReadException(String message) {
        super(message);
    }

    public FileNotReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotReadException(Throwable cause) {
        super(cause);
    }
}
