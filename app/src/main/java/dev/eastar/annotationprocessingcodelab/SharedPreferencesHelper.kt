@file:Suppress("unused")

package dev.eastar.annotationprocessingcodelab

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.core.content.edit

typealias PP = SharedPreferencesHelper
enum class SharedPreferencesHelper  {
    TEST_INT,
    TEST_TEXT,
    ;

    companion object {
        private lateinit var PREFERENCES: SharedPreferences

        private const val DEFAULT_STRING = ""
        private const val DEFAULT_FLOAT = -1f
        private const val DEFAULT_INT = -1
        private const val DEFAULT_LONG = -1L
        private const val DEFAULT_BOOLEAN = false

        fun CREATE(context: Context) {
            PREFERENCES = PreferenceManager.getDefaultSharedPreferences(context)
        }
        //@formatter:off
        @JvmStatic fun clear() = PREFERENCES.edit().clear().commit()
        @JvmStatic fun contain(key: String) = PREFERENCES.contains(key)
        @JvmStatic fun remove(key: String) = PREFERENCES.edit().remove(key).commit()
    }

    @JvmOverloads fun getBoolean   (DEFAULT : Boolean      = DEFAULT_BOOLEAN )                =  PREFERENCES.getBoolean  (name, DEFAULT)
    @JvmOverloads fun `is`         (DEFAULT : Boolean      = DEFAULT_BOOLEAN )                =              getBoolean  (      DEFAULT)
    @JvmOverloads fun getInt       (DEFAULT : Int          = DEFAULT_INT     )                =  PREFERENCES.getInt      (name, DEFAULT)
    @JvmOverloads fun getLong      (DEFAULT : Long         = DEFAULT_LONG    )                =  PREFERENCES.getLong     (name, DEFAULT)
    @JvmOverloads fun getFloat     (DEFAULT : Float        = DEFAULT_FLOAT   )                =  PREFERENCES.getFloat    (name, DEFAULT)
    @JvmOverloads fun getString    (DEFAULT : String?      = DEFAULT_STRING  ) : String?      =  PREFERENCES.getString   (name, DEFAULT)
    @JvmOverloads fun get          (DEFAULT : String?      = DEFAULT_STRING  ) : String?      =              getString   (      DEFAULT)
    @JvmOverloads fun getStringSet (DEFAULT : Set<String>? = null            ) : Set<String>? = PREFERENCES.getStringSet(name, DEFAULT)

    fun set(v: Boolean     ) = PREFERENCES.edit { putBoolean  (name, v) }
    fun set(v: Int         ) = PREFERENCES.edit { putInt      (name, v) }
    fun set(v: Long        ) = PREFERENCES.edit { putLong     (name, v) }
    fun set(v: Float       ) = PREFERENCES.edit { putFloat    (name, v) }
    fun set(v: String     ?) = PREFERENCES.edit { putString   (name, v) }
    fun set(v: Set<String>?) = PREFERENCES.edit { putStringSet(name, v) }
    //@formatter:on
}