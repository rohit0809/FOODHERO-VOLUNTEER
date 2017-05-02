package com.foodhero.volunteer.volunteer;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by shahr on 5/2/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest

public class Wait_for_Req_Test {

    @Rule
    public ActivityTestRule<Wait_for_request> mActivityRule = new ActivityTestRule(Wait_for_request.class);

    @Test
    public void Iswaiting() {
        onView(withText("FOODHERO")).check(matches(isDisplayed()));
    }
}
