package com.nicli.parser;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class StringBookingParser implements BookingParser {

    private final DateTimeFormatter requestSubmissionTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss");

    @Override
    public BookingParserOutput parse(String booking) throws BookingParserException {
        // TODO implement string booking parsing to return proper Output object
        throw new UnsupportedOperationException();
    }

}
