package com.example.sixthsenseapp;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class SetupUserInfoETest
{
    @Rule
    public ActivityTestRule<SetupUserInfo> activityTestRule = new ActivityTestRule<>(SetupUserInfo.class);


    @Test
    public void invalidEmail()
    {
        onView(withId(R.id.firstNameField)).perform(typeText("John"));
        onView(withId(R.id.lastNameField)).perform(typeText("Doe"));
        onView(withId(R.id.emailField)).perform(typeText("invalidEmail"));
        onView(withId(R.id.passwordField)).perform(typeText("JohnDoe123"));
        onView(withId(R.id.retypePasswordField)).perform(typeText("JohnDoe123"));
        onView(withId(R.id.phoneNumberField)).perform(typeText("12345678"),closeSoftKeyboard());
        onView(withId(R.id.nextButton)).perform(click());
        //onView(withId(R.id.emailField)).check(matches(withError(getString(getString(R.string.error_invalid_email)))));
    }


    @Test
    public void PasswordDoesNotMatch()
    {
        onView(withId(R.id.firstNameField)).perform(typeText("John"));
        onView(withId(R.id.lastNameField)).perform(typeText("Doe"));
        onView(withId(R.id.emailField)).perform(typeText("JohnDoe@gmail.com"));
        onView(withId(R.id.passwordField)).perform(typeText("JohnDoe23"));
        onView(withId(R.id.retypePasswordField)).perform(typeText("JohnDoe123"));
        onView(withId(R.id.phoneNumberField)).perform(typeText("12345678"),closeSoftKeyboard());
        onView(withId(R.id.nextButton)).perform(click());
        //onView(withId(R.id.emailField)).check(matches(withError(getString(getString(R.string.error_invalid_email)))));
    }
    @Test
    public void passwordTooShort()
    {
        onView(withId(R.id.firstNameField)).perform(typeText("John"));
        onView(withId(R.id.lastNameField)).perform(typeText("Doe"));
        onView(withId(R.id.emailField)).perform(typeText("JohnDoe@gmail.com"));
        onView(withId(R.id.passwordField)).perform(typeText("JohnDoe"));
        onView(withId(R.id.retypePasswordField)).perform(typeText("JohnDoe"));
        onView(withId(R.id.phoneNumberField)).perform(typeText("12345678"),closeSoftKeyboard());
        onView(withId(R.id.nextButton)).perform(click());
        //onView(withId(R.id.emailField)).check(matches(withError(getString(getString(R.string.error_invalid_email)))));
    }



    @Test
    public void loginFailed()
    {

    }
    @Test
    public void loginSuccessful()
    {
        onView(withId(R.id.firstNameField)).perform(typeText("John"));
        onView(withId(R.id.lastNameField)).perform(typeText("Doe"));
        onView(withId(R.id.emailField)).perform(typeText("JohnDoe@gmail.com"));
        onView(withId(R.id.passwordField)).perform(typeText("JohnDoe123"));
        onView(withId(R.id.retypePasswordField)).perform(typeText("JohnDoe123"));
        onView(withId(R.id.phoneNumberField)).perform(typeText("12345678"),closeSoftKeyboard());
        onView(withId(R.id.nextButton)).perform(click());
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
