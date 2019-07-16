package com.epam.geometry.exception.file;

import com.epam.geometry.exception.DataMissingException;

public class FileNotReadException extends DataMissingException {

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
