package dev.eastar.pref.annotation.generator

import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedOptions
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@SupportedSourceVersion(SourceVersion.RELEASE_8) // to support Java 8
@SupportedOptions("kapt.kotlin.generated")
class AnnotationGenerator : AbstractProcessor() {
    override fun process(set: MutableSet<out TypeElement>?, roundEnvironment: RoundEnvironment?): Boolean {
        TODO("Not yet implemented")
    }
}
