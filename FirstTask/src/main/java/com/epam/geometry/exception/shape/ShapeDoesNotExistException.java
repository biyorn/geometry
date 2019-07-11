package com.epam.geometry.exception.shape;

public class ShapeDoesNotExistException extends Exception {

    public ShapeDoesNotExistException() {
    }

    public ShapeDoesNotExistException(String message) {
        super(message);
    }

    public ShapeDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeDoesNotExistException(Throwable cause) {
        super(cause);
    }
}
