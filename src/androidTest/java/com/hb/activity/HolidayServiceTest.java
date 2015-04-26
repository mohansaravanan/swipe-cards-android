package com.hb.activity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.hb.model.Holiday;
import com.hb.service.HolidayService;


@LargeTest
public class HolidayServiceTest extends ActivityInstrumentationTestCase2<HBActivity> {


    public static final String SLIDE_1 = "slide_1";
    public static final String SLIDE_2 = "slide_2";
    public static final String SLIDE_3 = "slide_3";
    public static final int DAYS_TO_GO = 182;
    public static final int WEATHER = 34;
    public static final int NO_OF_CARDS = 3;

    public HolidayServiceTest() {
        super(HBActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testShouldGetHolidayDetails() {

        //when
        HolidayService holidayService = new HolidayService();
        Holiday holidayDetails = holidayService.getHolidayDetails(getActivity());

        //then
        assertEquals(new Integer(DAYS_TO_GO), holidayDetails.getDaysToGo());
        assertEquals(new Integer(WEATHER), holidayDetails.getWeather());
        assertEquals(NO_OF_CARDS, holidayDetails.getCards().size());
        assertEquals(SLIDE_1, holidayDetails.getCards().get(0));
        assertEquals(SLIDE_2, holidayDetails.getCards().get(1));
        assertEquals(SLIDE_3, holidayDetails.getCards().get(2));
    }

}
