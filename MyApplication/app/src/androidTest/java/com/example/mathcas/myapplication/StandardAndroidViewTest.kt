package com.example.mathcas.myapplication

import android.os.Bundle
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.runner.AndroidJUnitRunner
import android.support.test.runner.screenshot.ScreenCapture
import android.view.LayoutInflater
import com.facebook.litho.config.ComponentsConfiguration
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ScreenshotRunner
import com.facebook.testing.screenshot.ViewHelpers
import com.facebook.testing.screenshot.layouthierarchy.LayoutHierarchyDumper
import com.facebook.testing.screenshot.layouthierarchy.litho.LithoAttributePlugin
import com.facebook.testing.screenshot.layouthierarchy.litho.LithoHierarchyPlugin
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StandardAndroidViewTest : AndroidJUnitRunner() {

    companion object {
        init {
            ComponentsConfiguration.isDebugModeEnabled = true
            LayoutHierarchyDumper.addGlobalHierarchyPlugin(LithoHierarchyPlugin.getInstance())
            LayoutHierarchyDumper.addGlobalAttributePlugin(LithoAttributePlugin.getInstance())
        }
    }

    override fun onCreate(arguments: Bundle?) {
        ScreenshotRunner.onCreate(this, arguments)
        super.onCreate(arguments)

    }


    @Test
    fun okTextShouldBeGreen() {

        val activity = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false).launchActivity(null)

        Screenshot.snapActivity(activity).record()
    }

    override fun onDestroy() {
        ScreenshotRunner.onDestroy()
        super.onDestroy()
    }
}