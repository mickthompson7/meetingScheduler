package com.nicli.parser;

/**
 * This interface contains parsing functionality of Booking information
 */
public interface BookingParser {
    /**
     * Parse the booking information passed in as a String and returns the information as an new {@link BookingParserOutput}
     *
     * @param booking string containing the meeting booking information
     * @return a BookingParserOutput object mapping the parsed booking information
     * @throws BookingParserException in case of an error during the parsing
     */
    BookingParserOutput parse(String booking) throws BookingParserException;
}
