package com.example.sixthsenseapp;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class SetupHighBloodSugarTest
{
    @Rule
    public ActivityTestRule<SetupHighBloodSugar> activityTestRule = new ActivityTestRule<>(SetupHighBloodSugar.class);



    @Test
    public void insulinPenChosen()
    {

        onView(withId(R.id.insulinPen)).perform(click());
        onView(withId(R.id.nextButton)).perform(click());
        //onView(withId(R.id.emailField)).check(matches(withError(getString(getString(R.string.error_invalid_email)))));
    }
    @Test
    public void insulinPumpTreatmentChosen()
    {

        onView(withId(R.id.insulinPump)).perform(click());
        onView(withId(R.id.nextButton)).perform(click());

    }
    @Test
    public void otherTreatmentChosen()
    {

        onView(withId(R.id.other)).perform(click());
        onView(withId(R.id.nextButton)).perform(click());
    }
}