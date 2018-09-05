package com.rahmat.app.footballclub.feature.main



import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.swipeDown
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.v7.widget.RecyclerView
import com.rahmat.app.footballclub.R.id.*

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        delay()
        onView(withId(rvFootball))
                .check(matches(isDisplayed()))
        onView(withId(rvFootball)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        onView(withId(rvFootball)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click()))

        onView(withId(awayImg)).check(matches(isDisplayed()))
        onView(withId(homeImg)).check(matches(isDisplayed()))

        pressBack()
        delay()

        onView(withId(upMatch)).perform(click())
        delay()
        onView(withId(rvFootball))
                .check(matches(isDisplayed()))

        onView(withId(rvFootball))
                .check(matches(isDisplayed()))
        onView(withId(rvFootball)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        onView(withId(rvFootball)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click()))

        onView(withId(awayImg)).check(matches(isDisplayed()))
        onView(withId(homeImg)).check(matches(isDisplayed()))

        onView(withId(favorite)).perform(click())

        pressBack()
        delay()

        onView(withId(favMatch)).perform(click())

        delay()

        onView(withId(rvFootball))
                .check(matches(isDisplayed()))

        onView(withId(rvFootball)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(rvFootball)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(awayImg)).check(matches(isDisplayed()))
        onView(withId(homeImg)).check(matches(isDisplayed()))

        onView(withId(favorite)).perform(click())

        pressBack()

        delay()

        onView(withId(swiperefresh)).perform(swipeDown())

        delay()

    }

    private fun delay(){
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
