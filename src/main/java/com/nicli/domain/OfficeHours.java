package com.nicli.domain;

import org.joda.time.LocalTime;

public class OfficeHours extends RangeHours {

    public OfficeHours(LocalTime from, LocalTime to) {
        super(from, to);
    }

}
