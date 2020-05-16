package dev.eastar.annotationprocessingcodelab

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
@RunWith(AndroidJUnit4::class)
class SharedPreferencesHelperMoreBetterTest {
    @Test
    fun sharedPreferences() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        PPMoreBetter.CREATE(appContext)

        PPMoreBetter.setTestInt(1234)
        val testInt = PPMoreBetter.getTestInt()

//        PPMoreBetter.setTestInt("1234")
//        val testInt2 : String = PPMoreBetter.getTestInt()

        assertEquals(1234, testInt)
    }
}
