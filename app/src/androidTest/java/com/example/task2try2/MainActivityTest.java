package com.example.task2try2;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testCharacterCounting() {
        onView(withId(R.id.edUserInput))
                .perform(ViewActions.typeText("Hello"), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.spCountingOptions)).perform(ViewActions.click());
        onView(withText("Chars")).perform(ViewActions.click());

        onView(withId(R.id.btnCount)).perform(ViewActions.click());

        onView(withId(R.id.tvResult)).check(matches(withText("5")));
    }

    @Test
    public void testWordCounting() {
        onView(withId(R.id.edUserInput))
                .perform(ViewActions.typeText("Hello world!"), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.spCountingOptions)).perform(ViewActions.click());
        onView(withText("Words")).perform(ViewActions.click());

        onView(withId(R.id.btnCount)).perform(ViewActions.click());

        onView(withId(R.id.tvResult)).check(matches(withText("2")));
    }

    @Test
    public void testSpinnerSelection() {
        onView(withId(R.id.edUserInput))
                .perform(ViewActions.typeText("Android testing"), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.spCountingOptions)).perform(ViewActions.click());
        onView(withText("Chars")).perform(ViewActions.click());

        onView(withId(R.id.btnCount)).perform(ViewActions.click());

        onView(withId(R.id.tvResult)).check(matches(withText("15")));
        onView(withId(R.id.spCountingOptions)).perform(ViewActions.click());
        onView(withText("Words")).perform(ViewActions.click());

        onView(withId(R.id.btnCount)).perform(ViewActions.click());

        onView(withId(R.id.tvResult)).check(matches(withText("2")));
    }
}
