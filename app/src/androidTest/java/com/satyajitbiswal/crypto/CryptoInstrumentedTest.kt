package com.satyajitbiswal.crypto

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performGesture
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CryptoInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_refreshData() {

        Thread.sleep(10000)

        composeTestRule.onNodeWithTag("swipeToRefresh").performGesture {
            swipeDown()
        }
        Thread.sleep(3000)

        composeTestRule.onNodeWithTag("exchangeRatesList").assertIsDisplayed()
    }


}