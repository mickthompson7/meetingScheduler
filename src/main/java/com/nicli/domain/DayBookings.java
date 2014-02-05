package com.nicli.domain;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

import java.util.List;

public class DayBookings {

    private final DateTime date;
    private final List<Booking> bookingList;

    public DayBookings(DateTime date, List<Booking> bookingList) {
        this.date = date;
        this.bookingList = bookingList;
    }

    public DateTime getDate() {
        return date;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayBookings that = (DayBookings) o;

        return Objects.equal(this.date, that.date) &&
                Objects.equal(this.bookingList, that.bookingList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, bookingList);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(date)
                .addValue(bookingList)
                .toString();
    }
}
