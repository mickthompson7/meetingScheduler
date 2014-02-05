package com.nicli.service;

import com.nicli.BaseUnitTest;
import com.nicli.domain.Meeting;
import com.nicli.domain.OfficeHours;
import com.nicli.domain.RangeHours;
import com.nicli.domain.Booking;
import com.nicli.domain.Calendar;
import com.nicli.domain.DayBookings;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static java.util.Collections.EMPTY_LIST;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class NonPersistentMeetingSchedulerServiceTest extends BaseUnitTest {

    @Mock
    private MeetingManager meetingManager;

    @InjectMocks
    private NonPersistentMeetingSchedulerService nonPersistentMeetingSchedulerService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void bookOneMeetingReturnsACalendar() throws Exception {
        String employee = "EMP001";
        DateTime meetingDate = new DateTime().plusDays(4).withHourOfDay(10);
        int numberOfHours = 2;
        Meeting meeting = new Meeting(new DateTime(), employee, meetingDate, numberOfHours);

        List<Meeting> meetingList = of(meeting);
        OfficeHours officeHours = new OfficeHours(null, null);

        DayBookings dayBookings = new DayBookings(meetingDate, of(new Booking(new RangeHours(new LocalTime(10, 0), new LocalTime(12, 0)), employee)));
        when(meetingManager.removeMeetingsOutOfOfficeHours(officeHours, meetingList)).thenReturn(meetingList);
        when(meetingManager.createDayBookings(meeting)).thenReturn(dayBookings);

        Calendar calendar = nonPersistentMeetingSchedulerService.book(officeHours, meetingList);

        // construct expected Calendar domain object
        Calendar expectedCalendar = new Calendar(of(dayBookings));

        assertEquals(expectedCalendar, calendar);
    }

    @Test
    public void meetingOutOfOfficeHoursAreNotBookedInCalendar() throws Exception {
        Meeting meeting = new Meeting(new DateTime(), "EMP001", new DateTime(), 2);

        List<Meeting> meetingList = of(meeting);
        OfficeHours officeHours = new OfficeHours(null, null);

        when(meetingManager.removeMeetingsOutOfOfficeHours(officeHours, meetingList)).thenReturn(EMPTY_LIST);

        Calendar calendar = nonPersistentMeetingSchedulerService.book(officeHours, meetingList);

        // construct expected Calendar domain object
        Calendar expectedCalendar = new Calendar(EMPTY_LIST);

        assertEquals(expectedCalendar, calendar);
    }

}


