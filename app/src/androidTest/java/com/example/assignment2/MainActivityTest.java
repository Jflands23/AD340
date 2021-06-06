package com.example.assignment2;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)

public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void canEnterNameAndSignUp() throws InterruptedException {
        onView(withId(R.id.name)).perform(typeText("Jeff Wicorek"));
        onView(withId(R.id.email)).perform(typeText("jeffw@gmail.com"));
        onView(withId(R.id.username)).perform(typeText("JeffW"));
        onView(withId(R.id.bio)).perform(typeText("blah"));
        onView(withId(R.id.job)).perform(typeText("Software Dev"));

        onView(withId(R.id.goToSecondActivity)).perform(scrollTo(), (click()));

        onView(allOf(withId(R.id.bio))).check(matches(withText("blah")));
        onView(allOf(withId(R.id.name))).check(matches(withText("Jeff Wicorek")));
        onView(allOf(withId(R.id.job))).check(matches(withText("Software Dev")));

    }

    @Test
    public void checkUsernameNotBlank() {
        onView(withId(R.id.name)).perform(typeText("Jeff"));
        onView(withId(R.id.email)).perform(typeText("Jeff@gmail.com"));

        onView(withId(R.id.goToSecondActivity)).perform(scrollTo(), (click()));

        onView(allOf(withId(R.id.username), hasErrorText("Cannot Be Blank!")));

    }

}
