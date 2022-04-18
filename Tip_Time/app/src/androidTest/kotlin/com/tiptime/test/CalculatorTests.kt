package com.tiptime.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import net.nathan.tiptime.MainActivity
import net.nathan.tiptime.R
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches


@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    // we must run the activity before getting it
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip(){
        val first_input = onView(withId(R.id.first_input_edit))
        // put 50.0 on the input text
        first_input.perform(typeText("50.0"))
       // hide keyboard :  first_input.perform(ViewAction.closeSoftKeyboard())

        // let calculate the tip with test
        val calculate = onView(withId(R.id.calculate))
        calculate.perform(click())

        onView(withId(R.id.amount)).check(matches(withText(containsString("10"))))
    }
}