package com.example.helloapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void sayHello_noName() {
        onView(withId(R.id.editTextName)).perform(clearText());
        onView(withId(R.id.buttonSayHello)).perform(click());
        onView(withId(R.id.textViewGreeting)).check(matches(withText("Please enter a name")));
    }

    @Test
    public void sayHello_validName() {
        String name = "John";
        onView(withId(R.id.editTextName)).perform(typeText(name));
        onView(withId(R.id.buttonSayHello)).perform(click());
        onView(withId(R.id.textViewGreeting)).check(matches(withText("Hello, " + name + "!")));
    }
}
