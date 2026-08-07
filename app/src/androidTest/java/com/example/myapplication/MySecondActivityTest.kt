package com.example.myapplication

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MySecondActivityTest {

    @Test
    fun testDisplayNameReceivedFromIntent() {
        val testName = "Estudiante"
        
        // Create an intent with the expected extra
        val intent = Intent(ApplicationProvider.getApplicationContext(), MySecondActivity::class.java).apply {
            putExtra("nombre_usuario", testName)
        }

        // Launch the activity with the intent
        ActivityScenario.launch<MySecondActivity>(intent).use {
            // Check if the TextView displays the correct name
            // Note: MySecondActivity.kt currently gets the extra but doesn't set it to the TextView.
            // This test will fail initially if the code is not updated to display the text.
            onView(withId(R.id.textView)).check(matches(withText(testName)))
        }
    }
}
