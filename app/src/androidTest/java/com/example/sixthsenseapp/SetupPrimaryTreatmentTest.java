package com.example.sixthsenseapp;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class SetupPrimaryTreatmentTest {

    @Rule
    public ActivityTestRule<SetupPrimaryTreatment> activityTestRule = new ActivityTestRule<>(SetupPrimaryTreatment.class);


    @Test
    public void tabletTreatmentChosen()
    {

        onView(withId(R.id.glucoseTablet)).perform(click());
        onView(withId(R.id.nextButton)).perform(click());
        //onView(withId(R.id.emailField)).check(matches(withError(getString(getString(R.string.error_invalid_email)))));
    }
    @Test
    public void confectionaryTreatmentChosen()
    {

        onView(withId(R.id.confectionery)).perform(click());
        onView(withId(R.id.nextButton)).perform(click());

    }
    @Test
    public void sugaryTreatmentChosen()
    {

        onView(withId(R.id.sugaryDrink)).perform(click());
        onView(withId(R.id.nextButton)).perform(click());
    }
}