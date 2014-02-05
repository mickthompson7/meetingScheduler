package com.nicli;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.mockito.MockitoAnnotations;

public class BaseUnitTest {

    public static final long tenthJan2014 = new DateTime(2014, 1, 10, 0, 0, 0, 0).getMillis();

    public void setUp() throws Exception {
        // initialize Mocks
        MockitoAnnotations.initMocks(this);
        // fix test time at 10th Jan 2014
        DateTimeUtils.setCurrentMillisFixed(tenthJan2014);
    }

}
