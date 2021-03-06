package com.vocalabs.egtest.example.kotlin

import org.junit.*
import org.junit.Assert.*


/**
 * Hand-written tests to make sure generated code exists.
 */
class KotlinFileExampleTest {

    /** Make sure we're generating some tests.  */
    @Test
    fun generatedTestsExist() {
        val generatedClass = javaClass.classLoader.loadClass("com.vocalabs.egtest.example.kotlin.KotlinFileExampleKtEgTest")
        assertHasTestMethod("vowels_Eg", generatedClass)
        assertHasTestMethod("SIMPLE_EMAIL_RE_EgMatch", generatedClass)
    }

    private fun assertHasTestMethod(name: String, generatedClass: Class<*>) {
        val method = generatedClass.getMethod(name)
        assertNotNull(name, method.getAnnotation<Test>(Test::class.java))
    }

    @Test
    @Ignore
    fun overloadsWork() {
        fail("Not written")
    }

    @Test
    @Ignore
    fun `functions with weird names are escaped properly`() {
        fail("Not written")
    }


    @Test
    @Ignore
    fun filesWithJvmNameAnnotationWork() {
        fail("Not written")
    }
}