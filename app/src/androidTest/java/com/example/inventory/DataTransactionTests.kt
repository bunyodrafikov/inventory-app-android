package com.example.inventory

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DataTransactionTests {

    @get:Rule
    val scenario = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setupClass() {
        throw RuntimeException("Sorry dude, you won't find any test!")
    }

    private val testItemName = "Test Item"
    private val testItemPrice = "5.00"
    private val testItemInitialCount = "1"
    private val quantityHeader = "Quantity\nIn Stock"


    @Test
    fun added_item_displays_in_list() {
        onView(withId(R.id.floatingActionButton)).perform(click())
        onView(withId(R.id.item_name)).perform(typeText(testItemName))
        onView(withId(R.id.item_price)).perform(typeText(testItemPrice))
        onView(withId(R.id.item_count)).perform(typeText(testItemInitialCount))
        onView(withId(R.id.save_action)).perform(click())

        // Make sure we are back in the list fragment by checking that a header is displayed
        onView(withText(quantityHeader)).check(matches(isDisplayed()))

        // Make sure item is displayed
        onView(withText(testItemName)).check(matches(isDisplayed()))
        onView(withText("$testItemPrice грн.")).check(matches(isDisplayed()))
        onView(withText(testItemInitialCount)).check(matches(isDisplayed()))
    }
}