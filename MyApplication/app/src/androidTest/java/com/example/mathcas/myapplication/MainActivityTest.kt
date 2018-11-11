package com.example.mathcas.myapplication

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.view.LayoutInflater
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    var activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)


    @Test
    @Throws(Throwable::class)
    fun testRendering() {

        val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
        val inflater = LayoutInflater.from(targetContext)
        val view = inflater.inflate(R.layout.activity_main, null, false)

        val activity = activityTestRule.launchActivity(null)

        ViewHelpers.setupView(view).setExactWidthDp(300).layout()
        Screenshot.snapActivity(activity).record()
    }

    @Test
    fun okTextShouldBeGreen() {

        val activity = activityTestRule.launchActivity(null)

        Screenshot.snapActivity(activity).record()
    }

}