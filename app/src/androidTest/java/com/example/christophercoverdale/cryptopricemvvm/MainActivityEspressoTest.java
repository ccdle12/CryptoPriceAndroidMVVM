package com.example.christophercoverdale.cryptopricemvvm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by christophercoverdale on 22/11/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest
{
    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class, true, true);

    @NonNull
    private MainActivity mainActivity;

    @Test
    public void testUseAppContext() throws Exception
    {
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.christophercoverdale.cryptopricemvvm", appContext.getPackageName());
    }

    @Test
    public void testFrameLayoutIsDisplayed()
    {
        onView(withId(R.id.main_fragment_container)).check(matches(isDisplayed()));
    }

    @Test
    public void testDashboardFragmentIsDisplayed()
    {
        onView(withId(R.id.exchanges_spinner)).check(matches(isDisplayed()));
    }
}