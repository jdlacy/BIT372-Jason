package com.example.unitcoverter;

import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.unitcoverter", appContext.getPackageName());
        Log.i("test0", "Test 0 Complete");
    }



    //F -> C tests

    @Test
    public void can_enter_fahrenheit() {
        onView(withId(R.id.convert_pick)).perform(click());
        onData((is(instanceOf(String.class)))).atPosition(0).perform(click());
        onView(withId(R.id.user_input)).perform(typeText("45"), closeSoftKeyboard());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.user_input)).check(matches(withText("7.222222222222222")));
        Log.i("test1a", "Test 1a Complete");
    }

    @Test
    public void should_not_enter_empty_fah() {
        onView(withId(R.id.convert_pick)).perform(click());
        onData((is(instanceOf(String.class)))).atPosition(0).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.user_input)).check(matches(withText("")));
        Log.i("test1b", "Test 1b Complete");
    }



    //lbs -> kg tests

    @Test
    public void can_enter_lbs() {
        onView(withId(R.id.convert_pick)).perform(click());
        onData((is(instanceOf(String.class)))).atPosition(1).perform(click());
        onView(withId(R.id.user_input)).perform(typeText("156"), closeSoftKeyboard());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.user_input)).check(matches(withText("70.76040972")));
        Log.i("test2a", "Test 2a Complete");
    }

    @Test
    public void should_not_enter_empty_lbs() {
        onView(withId(R.id.convert_pick)).perform(click());
        onData((is(instanceOf(String.class)))).atPosition(1).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.user_input)).check(matches(withText("")));
        Log.i("test2b", "Test 2b Complete");
    }



    //oz -> ml tests

    @Test
    public void can_enter_oz() {
        onView(withId(R.id.convert_pick)).perform(click());
        onData((is(instanceOf(String.class)))).atPosition(2).perform(click());
        onView(withId(R.id.user_input)).perform(typeText("32"), closeSoftKeyboard());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.user_input)).check(matches(withText("946.24")));
        Log.i("test3a", "Test 3a Complete");
    }

    @Test
    public void should_not_enter_empty_oz() {
        onView(withId(R.id.convert_pick)).perform(click());
        onData((is(instanceOf(String.class)))).atPosition(2).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.user_input)).check(matches(withText("")));
        Log.i("test3b", "Test 3b Complete");
    }


    //mi -> km tests
    @Test
    public void can_enter_mi() {
        onView(withId(R.id.convert_pick)).perform(click());
        onData((is(instanceOf(String.class)))).atPosition(3).perform(click());
        onView(withId(R.id.user_input)).perform(typeText("3"), closeSoftKeyboard());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.user_input)).check(matches(withText("4.82802")));
        Log.i("test4a", "Test 4a Complete");
    }

    @Test
    public void should_not_enter_empty_mi() {
        onView(withId(R.id.convert_pick)).perform(click());
        onData((is(instanceOf(String.class)))).atPosition(3).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.user_input)).check(matches(withText("")));
        Log.i("test4b", "Test 4b Complete");
    }
}
