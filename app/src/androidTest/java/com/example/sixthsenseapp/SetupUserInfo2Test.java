package com.example.sixthsenseapp;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class SetupUserInfo2Test {
    /*private EditText dateOfBirthField;
    private EditText gpNameField;
    private EditText gpNumberField;
    private EditText emergencyNameField;
    private EditText emergencyNumberField;
    private TextView errorMessage;
    private CheckBox addCaregiver;
    private static String dateOfBirth = "";
    private static String gpName = "";
    private static String gpNumber = "";
    private static String emergencyName = "";
    private static String emergencyNumber = "";*/
    @Rule
    public ActivityTestRule<SetupUserInfo2> activityTestRule = new ActivityTestRule<>(SetupUserInfo2.class);


    @Test
    public void invalidDateofBirth()
    {

    }
    /*@Test
    public void Caregiver()
    {

    }*/

    /*@Test
    public void PhoneNumberBoundries()
    {

    }*/

    @Test
    public void loginFailed()
    {

    }
    @Test
    public void loginSuccessful()
    {
        onView(withId(R.id.dateOfBirthField)).perform(typeText(""));
        onView(withId(R.id.gpNameField)).perform(typeText("Dr Smith"));
        onView(withId(R.id.gpNumberField)).perform(typeText("12345678"));
        onView(withId(R.id.emergencyNameField)).perform(typeText("Sarah Jane"));
        onView(withId(R.id.emergencyNumberField)).perform(typeText("12345678"));
        //onView(withId(R.id.addCaregiver)).perform(),closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());
        //onView(withId(R.id.emailField)).check(matches(withError(getString(getString(R.string.error_invalid_email)))));
    }
}

/*private String getString(@StringRes int resourceId) {
        return activityTestRule.getActivity().getString(resourceId);
    }

    private static Matcher<View> withError(final String expected) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                if (item instanceof EditText) {
                    return ((EditText)item).getError().toString().equals(expected);
                }
                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Not found error message" + expected + ", find it!");
            }
        };
    }*/
