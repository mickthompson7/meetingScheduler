package com.nicli.parser;

import com.nicli.domain.Meeting;
import com.nicli.domain.OfficeHours;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;

public class StringBookingParserTest {

    private StringBookingParser stringBookingParser;

    @Before
    public void setUp() throws Exception {
        stringBookingParser = new StringBookingParser();
    }

    @Ignore
    @Test
    public void parseBookingStringIntoDomainObjects() throws Exception {
        final String BR = "\n\n";
        final String OFFICE_HOURS = "0900 1730";
        final String BOOKING_1 = "2011-03-17 10:17:06 EMP001" + BR + "2011-03-21 09:00 2";
        final String BOOKING_2 = "2011-03-16 12:34:56 EMP002" + BR + "2011-03-21 09:45 2";
        String bookingString = OFFICE_HOURS + BR + BOOKING_1 + BR + BOOKING_2;

        BookingParserOutput bookingParserOutput = stringBookingParser.parse(bookingString);
        OfficeHours officeHours = bookingParserOutput.getOfficeHours();
        List<Meeting> meetingList = bookingParserOutput.getMeetingList();

        // expected parsing result
        OfficeHours expectedOfficeHours = new OfficeHours(new LocalTime(9, 0), new LocalTime(17, 30));
        Meeting meeting1 = new Meeting(new DateTime(2011, 3, 17, 10, 17, 06), "EMP001", new DateTime(2011, 03, 21, 9, 0), 2);
        Meeting meeting2 = new Meeting(new DateTime(2011, 3, 16, 12, 34, 56), "EMP002", new DateTime(2011, 03, 21, 9, 45), 2);
        List<Meeting> expectedMeetingList = of(meeting1, meeting2);

        // assertions
        Assert.assertEquals(expectedOfficeHours, officeHours);
        Assert.assertEquals(expectedMeetingList, meetingList);
    }

    @Ignore
    @Test
    public void badBookingStringAsInputThrowsParsingRuntimeException() throws Exception {
        // TODO
    }
}
