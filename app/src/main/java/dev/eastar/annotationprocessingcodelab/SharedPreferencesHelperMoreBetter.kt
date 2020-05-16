@file:Suppress("unused")

package dev.eastar.annotationprocessingcodelab

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.core.content.edit

typealias PPMoreBetter = SharedPreferencesHelperMoreBetter.Companion

class SharedPreferencesHelperMoreBetter {
    companion object {
        val TEST_INT = "TEST_INT"
        val TEST_TEXT = "TEST_TEXT"

        private lateinit var PREFERENCES: SharedPreferences
        @JvmStatic
        fun CREATE(context: Context) {
            PREFERENCES = PreferenceManager.getDefaultSharedPreferences(context)
        }

        @JvmStatic
        fun setTestInt(value: Int) {
            PREFERENCES.edit { putInt(TEST_INT, value) }
        }

        @JvmStatic
        fun getTestInt(): Int {
            return PREFERENCES.getInt(TEST_INT, -1)
        }

        @JvmStatic
        fun setTestText(value: String) {
            PREFERENCES.edit { putString(TEST_TEXT, value) }
        }

        @JvmStatic
        fun getTestText(): String? {
            return PREFERENCES.getString(TEST_TEXT, "")
        }
    }
}
