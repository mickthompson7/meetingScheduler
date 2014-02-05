package com.nicli.service;

import com.nicli.domain.DayBookings;
import com.nicli.domain.Meeting;
import com.nicli.domain.OfficeHours;

import java.util.List;

/**
 * Interface that helps manage Meeting related tasks
 */
public interface MeetingManager {

    /**
     * Creates DayBookings from a Meeting Object
     *
     * @param meeting the Meeting object used for Booking creation
     * @return a DayBooking Object representing a Meeting
     */
    DayBookings createDayBookings(Meeting meeting);

    /**
     * Based on a List of Meetings passed in as a parameter this method removes those meetings that are out of office hours.
     *
     * @param officeHours the OfficeHours in which the meetings has to be in
     * @param meetingList the MeetingList that needs to be filtered based on OfficeHours constraint
     * @return a new List without the removed Meetings out of Office Hours
     */
    List<Meeting> removeMeetingsOutOfOfficeHours(OfficeHours officeHours, List<Meeting> meetingList);

}
