package dev.eastar.pref.annotation.generator

import dev.eastar.pref.annotation.Pref
import dev.eastar.pref.annotation.util.Log
import java.io.File
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@SupportedSourceVersion(SourceVersion.RELEASE_8) // to support Java 8
@SupportedOptions("kapt.kotlin.generated")
public class AnnotationGenerator : AbstractProcessor() {
    private lateinit var kaptKotlinGeneratedDir: String

    override fun init(processingEnvironment: ProcessingEnvironment?) {
        super.init(processingEnvironment)
        Log.processingEnvironment = processingEnv
        kaptKotlinGeneratedDir = processingEnv.options["kapt.kotlin.generated"]!!
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latest()
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(Pref::class.java.name)
    }

    //https://github.com/square/kotlinpoet
    override fun process(set: MutableSet<out TypeElement>?, roundEnvironment: RoundEnvironment?): Boolean {
        roundEnvironment
            ?.getElementsAnnotatedWith(Pref::class.java)
            ?.forEach {
                val packageName = it.enclosingElement.toString()
                val className = "GeneratedAnnotationGenerator"

                val file = File("$kaptKotlinGeneratedDir/${packageName.replace('.', '/')}", "HelloAnnotationsProcessGenerated.kt")
                file.parentFile.mkdirs()
                val fileContent = """

        package $packageName
        class HelloAnnotationsProcessGenerated {
             fun hello() = "Hello annotations process"
        }
    """.trimIndent()
                file.writeText(fileContent)
            }
        return true
    }
}
