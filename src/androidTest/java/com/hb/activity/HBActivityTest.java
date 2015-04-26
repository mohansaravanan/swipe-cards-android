package com.hb.activity;

import com.hb.R;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class HBActivityTest extends ActivityInstrumentationTestCase2<HBActivity> {

    public static final int DAYS_TO_GO = 182;
    public static final int WEATHER = 34;
    public static final int NO_OF_CARDS = 3;
    public static final String TEXT = "of";

    public HBActivityTest() {
        super(HBActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testActivityShouldHaveText() throws InterruptedException {
        onView(withId(R.id.current_page)).check(matches(withText(TEXT)));
        onView(withId(R.id.current_page)).check(matches(withText(String.valueOf(DAYS_TO_GO))));
        onView(withId(R.id.current_page)).check(matches(withText(String.valueOf(WEATHER))));
        onView(withId(R.id.current_page)).check(matches(withText(String.valueOf(NO_OF_CARDS))));
    }


}
