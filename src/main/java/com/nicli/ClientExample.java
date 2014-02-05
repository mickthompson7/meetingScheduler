package com.nicli;

import com.nicli.domain.Calendar;
import com.nicli.parser.BookingParser;
import com.nicli.parser.BookingParserOutput;
import com.nicli.printer.BookingPrinter;
import com.nicli.service.MeetingSchedulerService;

import javax.annotation.Resource;

/**
 * Test code comments
 * <p/>
 * I started mapping the Meeting Scheduler requirements to some domain Objects that could somehow fit into the scope (domain package).
 * In this way I could virtually work in parallel at 3 part of the app.
 * <p/>
 * 1. I was able to concentrate at the work around the MeetingSchedulerService (service package) just by using domain Objects and without taking care of Parsing and other String operations.
 * <p/>
 * 2. I could start defining the requirements (with a unit test) for the Parser mechanism in order to translate a string to the Domain model (parser package)
 * <p/>
 * 3. At the same time I was able to write a first test for a future implementation of the Calendar Printer (printer package) that translates the domain model back to something similar to the test requirements
 *
 * This ClientExample its just meant to show how the components are supposed to interact together in the future implementation ...
 */
public class ClientExample {

    @Resource
    private BookingParser bookingParser;
    @Resource
    private MeetingSchedulerService meetingSchedulerService;
    @Resource
    private BookingPrinter bookingPrinter;

    // just as a dummy example to see how the components are playing together
    public void bookMeetings(String bookMeetingsString) {
        BookingParserOutput bookingInfo = bookingParser.parse(bookMeetingsString);
        Calendar calendar = meetingSchedulerService.book(bookingInfo.getOfficeHours(), bookingInfo.getMeetingList());
        System.out.println(bookingPrinter.print(calendar));
    }

}
