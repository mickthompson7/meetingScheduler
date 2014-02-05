package com.nicli.parser;

public class BookingParserException extends RuntimeException {

    public BookingParserException() {
        super();
    }

    public BookingParserException(String message) {
        super(message);
    }

    public BookingParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingParserException(Throwable cause) {
        super(cause);
    }

}
