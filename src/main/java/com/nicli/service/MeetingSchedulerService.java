package com.nicli.service;

import com.nicli.domain.Calendar;
import com.nicli.domain.Meeting;
import com.nicli.domain.OfficeHours;

import java.util.List;

/**
 * Service Interface for scheduling Meetings
 */
public interface MeetingSchedulerService {
    /**
     * This methods allows booking for Meetings in a specific OfficeHours time range
     *
     * @param officeHours the TimeRange that defines OfficeHours for this specific booking
     * @param meetingList a List of Meetings that the Service will book
     * @return a Calendar object representing the Bookings that went successful
     */
    Calendar book(OfficeHours officeHours, List<Meeting> meetingList);
}
