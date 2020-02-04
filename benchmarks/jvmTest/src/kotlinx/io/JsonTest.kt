package kotlinx.io

import kotlinx.io.json.*
import kotlinx.io.json.data.*
import kotlinx.serialization.*
import kotlin.reflect.*
import kotlin.test.*

class JsonTest {

    val canada = Resource("canada.json").readText()
    val citm = Resource("citm_catalog.json").readText()

    val jsons = listOf(
        KxJson
//        SerializationJson,
//        GsonJson
//        JacksonJson
    )

    @Test
    fun testBenchmarks() {
        while (true) {
            jsons.forEach {
                //            equalsBackAndForth<Canada>(canada, it)
//            equalsBackAndForth<CitmCatalog>(citm, it)
                equalsBackAndForth<Twitter>(twitter, it)
            }
        }
    }

}

val twitter = Resource("twitter.json").readText()
fun main() {
    while (true) {
        equalsBackAndForth<Twitter>(twitter, KxJson)
    }
}

@UseExperimental(ImplicitReflectionSerializer::class, ExperimentalStdlibApi::class)
inline fun <reified T : Any> equalsBackAndForth(content: String, json: JsonAdapter) {
    val firstData = json.parse(content, typeOf<T>(), T::class.java)
//        val secondContent = json.encode(firstData, typeOf<T>())
//        val secondData = json.parse(secondContent, typeOf<T>(), T::class.java)
//        assertEquals(secondData, firstData)
}