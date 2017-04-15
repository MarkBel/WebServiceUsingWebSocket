package com.epam.exception;

/**
 * Created by Mark on 15.04.2017.
 */
public class BookCommandException extends RuntimeException {

    public BookCommandException() {
        super();
    }

    public BookCommandException(String message) {
        super(message);
    }

    public BookCommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
