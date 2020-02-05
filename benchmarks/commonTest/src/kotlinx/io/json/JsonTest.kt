package kotlinx.io.json.kotlinx.io.json

import kotlinx.io.*
import kotlinx.io.json.*
import kotlinx.io.json.data.*
import kotlinx.serialization.*
import kotlin.test.*


class JsonTest {

    @Test
    fun testReadCanada() {
        val file = Resource("canada.json").readText()
        equalsBackAndForth<Canada>(file)
    }

    @Test
    fun testReadCitmCatalog() {
        val file = Resource("citm_catalog.json").readText()
    }

    @Test
    fun testTwitter() {
        val file = Resource("twitter.json").readText()
    }

    @UseExperimental(ImplicitReflectionSerializer::class)
    inline fun <reified T : Any> equalsBackAndForth(content: String) {
        val firstData = ioJson.parse<T>(content)
        val secondContent = ioJson.stringify(firstData)
        val secondData = ioJson.parse<T>(secondContent)
        assertEquals(secondData, firstData)
    }
}