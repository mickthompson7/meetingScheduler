package com.nicli.service;

import com.google.common.collect.ImmutableList;
import com.nicli.BaseUnitTest;
import com.nicli.domain.*;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;

public class DefaultMeetingManagerTest extends BaseUnitTest {

    private DefaultMeetingManager defaultMeetingManager;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        defaultMeetingManager = new DefaultMeetingManager();
    }

    @Test
    public void createADayBookingsObjectFromAMeeting() throws Exception {
        DateTime meetingDate = new DateTime().withHourOfDay(9);
        String employee = "EMP001";
        int numberOfHours = 4;
        Meeting meeting = new Meeting(new DateTime(), employee, meetingDate, numberOfHours);

        DayBookings dayBookings = defaultMeetingManager.createDayBookings(meeting);

        RangeHours expectedRangeHours = new RangeHours(new LocalTime(9, 0), new LocalTime(13, 0)); // timerange of 4 hours from 9 to 13
        ImmutableList<Booking> bookingList = of(new Booking(expectedRangeHours, employee));
        DayBookings expectedDayBookings = new DayBookings(meetingDate, bookingList);

        Assert.assertEquals(expectedDayBookings, dayBookings);
    }

    @Test
    public void meetingsOutOfOfficeHoursAreRemoved() throws Exception {
        LocalTime from = new LocalTime().withHourOfDay(9);
        LocalTime to = new LocalTime().withHourOfDay(17);
        OfficeHours officeHours = new OfficeHours(from, to);

        Meeting meeting1 = new Meeting(new DateTime(), "EMP001", new DateTime().withHourOfDay(12), 3); // meeting from 12 to 15
        Meeting meeting2 = new Meeting(new DateTime(), "EMP001", new DateTime().withHourOfDay(16), 2); // meeting from 16 to 18
        ImmutableList<Meeting> meetings = ImmutableList.of(meeting1, meeting2);

        List<Meeting> meetingList = defaultMeetingManager.removeMeetingsOutOfOfficeHours(officeHours, meetings);

        List<Meeting> expectedMeetingList = ImmutableList.of(meeting1); // expect the second meeting to be removed as out of office hours

        Assert.assertEquals(expectedMeetingList, meetingList);
    }

}
