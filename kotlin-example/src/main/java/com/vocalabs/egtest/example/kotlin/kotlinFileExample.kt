package com.vocalabs.egtest.example.kotlin

import com.vocalabs.egtest.annotation.Eg
import com.vocalabs.egtest.annotation.EgMatch
import com.vocalabs.egtest.annotation.EgNoMatch

@EgMatch("dleppik@vocalabs.com")
@EgMatch("dleppik@vocalabs.example.com")
@EgNoMatch("dleppik")
@EgNoMatch("dleppik@vocalabs@example.com")
@EgNoMatch("David Leppik <dleppik@vocalabs.com>")
val SIMPLE_EMAIL_RE = """^[\w+.\-=&|/?!#$*]+@[\w.\-]+\.[\w]+$""".toRegex()

@EgMatch("dleppik@vocalabs.com")
fun matchesEmail(s: String): Boolean = SIMPLE_EMAIL_RE.matches(s)

@Eg(given = ["listOf<String>()"], returns = "listOf<String>()")
@Eg(given = ["""listOf("Cat", "Dog", "Octopus")"""], returns = """listOf("a", "o", "Oou")""")
fun vowels(words: Collection<String>): Collection<String> {
    val vowelSet = setOf('a', 'e', 'i', 'o', 'u')
    return words.map { s -> s.filter { vowelSet.contains(it.toLowerCase()) } }
}