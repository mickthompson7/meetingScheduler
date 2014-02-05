package com.nicli.service;

import com.nicli.domain.Calendar;
import com.nicli.domain.DayBookings;
import com.nicli.domain.Meeting;
import com.nicli.domain.OfficeHours;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class NonPersistentMeetingSchedulerService implements MeetingSchedulerService {

    @Resource
    private MeetingManager meetingManager;

    @Override
    public Calendar book(OfficeHours officeHours, List<Meeting> meetingList) {

        meetingList = meetingManager.removeMeetingsOutOfOfficeHours(officeHours, meetingList);

        List<DayBookings> dayBookingsList = new ArrayList<DayBookings>();
        for (Meeting meeting : meetingList) {
            dayBookingsList.add(meetingManager.createDayBookings(meeting));
        }

        return new Calendar(dayBookingsList);
    }

}
