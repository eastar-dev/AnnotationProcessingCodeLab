@file:Suppress("unused")

package dev.eastar.annotationprocessingcodelab

import dev.eastar.pref.annotation.Pref


@Pref
data class SharedPreferencesHelperWithAnnotation(
    val TEST_INT: Int,
    val TEST_TEXT: String
)
