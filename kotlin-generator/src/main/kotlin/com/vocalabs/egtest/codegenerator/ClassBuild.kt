package com.vocalabs.egtest.codegenerator

import kotlin.reflect.KType

 class ClassBuild(var name: String, var properties: List<KType>): AbstractCodeBuilding(), ClassBuilder {
     var annotations: String = ""
     var classSignature: String = ""
     var listofFunctions: List<FunctionBuild> = listOf()
     var classBody: String= ""

     fun addClass(){
        classSignature = "class $name("
        val iter = properties.iterator()
        var index = 1
        for (t in iter){
            val nextType = iter.next()
            classSignature = "$classSignature(field$index : $nextType"
            if (index != properties.lastIndex){
                classSignature += ", "
            }
            index++
        }
         classSignature += ")"
     }
     fun f(): Unit{
         return Unit
     }

     override fun addFunction(name: String, arguments: List<KType>, returnType: KType): FunctionBuilder {

         val function = FunctionBuild(name, arguments, ::f.returnType)
         function.addSignature()
         listofFunctions += function
         return function
     }

     override fun addAnnotation(annotationName: String, annotationBody: String?) {
         annotations += " @$annotationName $annotationBody \n"
     }

     fun build(): String {
         val functionStr: String = listofFunctions.joinToString("\n\t") { it.build() }
         classBody += functionStr
         return "$classSignature {\n$classBody\n}\n"
     }
 }
