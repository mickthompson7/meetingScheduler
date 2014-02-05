package com.nicli.service;

import com.nicli.domain.*;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class DefaultMeetingManager implements MeetingManager {

    @Override
    public DayBookings createDayBookings(Meeting meeting) {
        List<Booking> bookingList = new ArrayList<Booking>();
        RangeHours hours = getMeetingRangeHours(meeting);
        bookingList.add(new Booking(hours, meeting.getEmployee()));
        return new DayBookings(meeting.getMeetingDate(), bookingList);
    }

    @Override
    public List<Meeting> removeMeetingsOutOfOfficeHours(OfficeHours officeHours, final List<Meeting> meetingList) {
        final List<Meeting> validMeetingList = new ArrayList<Meeting>();
        for (Meeting meeting : meetingList) {
            RangeHours rangeHours = getMeetingRangeHours(meeting);
            if (!(rangeHours.getFrom().isAfter(officeHours.getFrom()) && rangeHours.getTo().isBefore(officeHours.getTo()))) {
                continue;
            }
            validMeetingList.add(meeting);
        }
        ;
        return validMeetingList;
    }

    private RangeHours getMeetingRangeHours(Meeting meeting) {
        final DateTime meetingDate = meeting.getMeetingDate();
        return new RangeHours(meetingDate.toLocalTime(), meetingDate.plusHours(meeting.getNumberOfHours()).toLocalTime());
    }

}
