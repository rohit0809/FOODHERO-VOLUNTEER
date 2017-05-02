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
public class Donor_details_test {

    @Rule
    public ActivityTestRule<Donor_details> mActivityRule = new ActivityTestRule(Donor_details.class);

    @Test
    public void detailstesting() {
        onView(withText("Item")).check(matches(isDisplayed()));
    }
}
