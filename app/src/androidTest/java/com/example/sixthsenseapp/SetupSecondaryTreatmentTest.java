package com.example.sixthsenseapp;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class SetupSecondaryTreatmentTest
{
    @Rule
    public ActivityTestRule<SetupSecondaryTreatment> activityTestRule = new ActivityTestRule<>(SetupSecondaryTreatment.class);


    @Test
    public void tabletTreatmentChosen()
    {

        onView(withId(R.id.glucoseTablet)).perform(click());
        onView(withId(R.id.nextButton)).perform(click());
        //onView(withId(R.id.emailField)).check(matches(withError(getString(getString(R.string.error_invalid_email)))));
    }
    @Test
    public void glucoseGelTreatmentChosen()
    {

        onView(withId(R.id.glucoseGel)).perform(click());
        onView(withId(R.id.nextButton)).perform(click());

    }
    @Test
    public void sugaryTreatmentChosen()
    {

        onView(withId(R.id.sugaryDrink)).perform(click());
        onView(withId(R.id.nextButton)).perform(click());
    }
}