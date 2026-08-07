package com.example.myapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testViewsAreDisplayed() {
        // Check if the button is displayed
        onView(withId(R.id.boton)).check(matches(isDisplayed()))
        
        // Check if the EditText is displayed
        onView(withId(R.id.nombreUsuario)).check(matches(isDisplayed()))
        
        // Check if the TextView is displayed
        onView(withId(R.id.holamundo)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigationToSecondActivity() {
        val testName = "John Doe"

        // Type text into the EditText
        onView(withId(R.id.nombreUsuario))
            .perform(typeText(testName), closeSoftKeyboard())

        // Click the button
        onView(withId(R.id.boton)).perform(click())

        // Verify that MySecondActivity was started
        intended(hasComponent(MySecondActivity::class.java.name))
    }
}
