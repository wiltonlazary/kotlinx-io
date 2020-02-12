@file:UseExperimental(ImplicitReflectionSerializer::class, ExperimentalStdlibApi::class)

package kotlinx.io.json

import kotlinx.io.*
import kotlinx.io.bytes.*
import kotlinx.io.json.data.*
import kotlinx.io.json.utils.*
import kotlinx.io.text.*
import kotlinx.serialization.*
import java.io.*
import java.io.ByteArrayInputStream
import kotlin.reflect.*

private val twitter = File("benchmarks/commonMain/resources/twitter.json").readText()

private val smallTextBytesASCII = "ABC.".toByteArray()

private val largeTextBytesASCII = ByteArray(smallTextBytesASCII.size * 10000 * 10000) {
    smallTextBytesASCII[it % smallTextBytesASCII.size]
}
private val largeTextPacketASCII = BytesOutput().apply {
    writeByteArray(largeTextBytesASCII)
}

fun main() {
    var result: Any = Unit
    result = readLargeASCII()
    println(result)
}


@UseExperimental(ExperimentalStdlibApi::class)
private fun parseTwitter(): Twitter =
    KxJson.parse(twitter, typeOf<Twitter>(), Twitter::class.java)

private fun readLargeASCII(): String =
    largeTextPacketASCII.createInput().readUtf8String()

private fun constructorLargeASCII(): String = String(largeTextBytesASCII, Charsets.UTF_8)

private fun readReader() {
    val x = ByteArrayInputStream(largeTextBytesASCII)
        .bufferedReader()
        .readText()
}
