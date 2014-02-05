package com.nicli.printer;

import com.nicli.domain.Calendar;

/**
 * This interface provides support for printing a Booking Calendar
 */
public interface BookingPrinter {
    /**
     * This method returns the Calendar object as a String representation
     *
     * @param calendar the Calendar object to print
     * @return a String representation of the Calendar object passed in as a parameter
     */
    String print(Calendar calendar);
}
