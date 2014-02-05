package com.nicli.parser;

import com.nicli.domain.Meeting;
import com.nicli.domain.OfficeHours;

import java.util.List;

public class BookingParserOutput {

    private final OfficeHours officeHours;
    private final List<Meeting> meetingList;

    public BookingParserOutput(OfficeHours officeHours, List<Meeting> meetingList) {
        this.officeHours = officeHours;
        this.meetingList = meetingList;
    }

    public OfficeHours getOfficeHours() {
        return officeHours;
    }

    public List<Meeting> getMeetingList() {
        return meetingList;
    }

}
