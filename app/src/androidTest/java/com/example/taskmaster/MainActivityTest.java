package com.example.taskmaster;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public  void  testOnClickMatcher(){
        onView(withId(R.id.myTaskTitle)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void testOne() {
        onView(withId(R.id.settingsButtonHome)).check(matches(withText("Setting")));
        onView(ViewMatchers.withId(R.id.taskRecycler)).perform(ViewActions.swipeDown());

        onView(withId(R.id.taskRecycler)).perform(ViewActions.swipeDown()).check(ViewAssertions.matches(isDisplayed()));

    }
    @Test
    public void testOnClick() {
        onView(withId(R.id.settingsButtonHome)).perform(click());
//        check if the main activity contain a button with an specific id
    }

    @Test
    public  void  testTow() {

        onView(withId(R.id.taskRecycler)).perform(click());
        onView(withText("My Task")).check(matches(isDisplayed()));

    }

    @Test
    public void EditingUserName() {

        onView(withId(R.id.settingsButtonHome)).perform(click());
        onView(withId(R.id.editTextTextPersonName3)).perform(typeText("abd"));
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.myTaskTitle)).check(matches(withText("abd")));

    }
    @Test
    public void testForChangeUserName() {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String result= preferences.getString("userName","user");
        onView(withText(result.trim())).check(matches(isDisplayed()));
    }


}