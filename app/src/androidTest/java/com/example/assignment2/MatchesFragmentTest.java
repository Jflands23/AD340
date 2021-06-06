package com.example.assignment2;


import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MatchesFragmentTest {

    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(Submission.class);


    @Test
    public void testMatchesLikeToast() throws InterruptedException {

        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open()); // Open Drawer

        onView(withText("Matches"))
                .perform(click()); // Select nav button in nav drawer

       /* Espresso.pressBack();*/
        Thread.sleep(200);
        /*onView(withId(R.id.card_view)).check(doesNotExist());*/
    }

}