package com.nicli.printer;

import com.nicli.domain.RangeHours;
import com.nicli.domain.Booking;
import com.nicli.domain.Calendar;
import com.nicli.domain.DayBookings;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static com.google.common.collect.ImmutableList.of;

public class StringBookingPrinterTest {

    private StringBookingPrinter stringBookingPrinter;

    @Before
    public void setUp() throws Exception {
        stringBookingPrinter = new StringBookingPrinter();
    }

    @Ignore
    @Test
    public void printACalendarResultAsString() throws Exception {
        DateTime secondFeb2014at1200 = new DateTime(2014, 02, 02, 12, 0);
        RangeHours from9to11 = new RangeHours(new LocalTime(9, 0), new LocalTime(11, 0));
        RangeHours from1530to1700 = new RangeHours(new LocalTime(15, 30), new LocalTime(17, 0));
        Booking booking1_1 = new Booking(from9to11, "EMP001");
        Booking booking1_2 = new Booking(from1530to1700, "EMP002");
        DayBookings dayBookings1 = new DayBookings(secondFeb2014at1200, of(booking1_1, booking1_2));

        DateTime thirdFeb2014at1030 = new DateTime(2014, 02, 03, 10, 30);
        RangeHours from1045to1145 = new RangeHours(new LocalTime(10, 45), new LocalTime(11, 45));
        Booking booking2_1 = new Booking(from1045to1145, "EMP003");
        DayBookings dayBookings2 = new DayBookings(thirdFeb2014at1030, of(booking2_1));

        Calendar calendar = new Calendar(of(dayBookings1, dayBookings2));

        String calendarString = stringBookingPrinter.print(calendar);

        String expectedCalendarString = "2014-02-02\n\n" + "09:00 11:00 EMP001\n\n" + "15:30 17:00 EMP002\n\n" + "2014-02-03\n\n" + "10:45 11:45 EMP003";

        Assert.assertEquals(expectedCalendarString, calendarString);
    }
}
