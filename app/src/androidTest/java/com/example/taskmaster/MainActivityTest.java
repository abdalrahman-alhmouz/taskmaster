package com.example.taskmaster;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public  void  testOnClickMatcher(){
        onView(withId(R.id.SettingPage)).perform(click()).check(matches(isDisplayed()));
    }

//    @Test
//    public void testOne() {
//        onView(withId(R.id.textView)).check(matches(withText("My Task")));
//        onView(ViewMatchers.withId(R.id.)).perform(ViewActions.swipeLeft());
//
//    }

}
