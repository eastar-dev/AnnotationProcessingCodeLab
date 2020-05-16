package dev.eastar.annotationprocessingcodelab

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

typealias PPS = SharedPreferencesHelperWithAnnotationGenerated

@RunWith(AndroidJUnit4::class)
class SharedPreferencesGeneratedTest {
    @Test
    fun sharedPreferences() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        PPS.preferences = PreferenceManager.getDefaultSharedPreferences(appContext)

        PPS.testInt = 1234
        val testInt = PPS.getTestInt()

        //PP.setTestInt("1234")
        //val testInt2 : String = PP.getTestInt()

        assertEquals(1234, testInt)
    }
}
