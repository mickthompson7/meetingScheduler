package com.nicli.domain;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

public class Meeting {

    private final DateTime submissionDate;
    private final String employee;
    private final DateTime meetingDate;
    private final int numberOfHours;

    public Meeting(DateTime submissionDate, String employee, DateTime meetingDate, int numberOfHours) {
        this.submissionDate = submissionDate;
        this.employee = employee;
        this.meetingDate = meetingDate;
        this.numberOfHours = numberOfHours;
    }

    public DateTime getSubmissionDate() {
        return submissionDate;
    }

    public String getEmployee() {
        return employee;
    }

    public DateTime getMeetingDate() {
        return meetingDate;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meeting that = (Meeting) o;

        return Objects.equal(this.submissionDate, that.submissionDate) &&
                Objects.equal(this.employee, that.employee) &&
                Objects.equal(this.meetingDate, that.meetingDate) &&
                Objects.equal(this.numberOfHours, that.numberOfHours);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(submissionDate, employee, meetingDate, numberOfHours);
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(submissionDate)
                .addValue(employee)
                .addValue(meetingDate)
                .addValue(numberOfHours)
                .toString();
    }
}
