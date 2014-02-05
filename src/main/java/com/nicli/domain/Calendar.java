package com.nicli.domain;

import com.google.common.base.Objects;

import java.util.List;

public class Calendar {

    private final List<DayBookings> dayBookingsList;

    public Calendar(List<DayBookings> dayBookingsList) {
        this.dayBookingsList = dayBookingsList;
    }

    public List<DayBookings> getDayBookingsList() {
        return dayBookingsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calendar that = (Calendar) o;

        return Objects.equal(this.dayBookingsList, that.dayBookingsList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dayBookingsList);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(dayBookingsList)
                .toString();
    }
}
