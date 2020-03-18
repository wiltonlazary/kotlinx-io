package kotlinx.io

import com.google.gson.*
import kotlinx.io.json.data.*
import kotlinx.io.json.utils.*
import kotlinx.serialization.*
import kotlin.reflect.*
import kotlin.test.*

class JsonTest {
    val canada = Resource("canada.json").readText()
    val canadaObject = Gson().fromJson(canada, Canada::class.java)

    val citm = Resource("citm_catalog.json").readText()
    val citmObject = Gson().fromJson(citm, CitmCatalog::class.java)

    val twitter = Resource("twitter.json").readText()
    val twitterObject = Gson().fromJson(twitter, Twitter::class.java)

    val jsons = listOf(
        KxJson,
        SerializationJson,
        GsonJson
//        JacksonJson
    )

    @Test
    fun testBenchmarks() {
        jsons.forEach {
            equalsBackAndForth<Canada>(canada, it, canadaObject)
            equalsBackAndForth<CitmCatalog>(citm, it, citmObject)
            equalsBackAndForth<Twitter>(twitter, it, twitterObject)
        }
    }
}

@OptIn(ImplicitReflectionSerializer::class, ExperimentalStdlibApi::class)
inline fun <reified T : Any> equalsBackAndForth(
    content: String,
    json: JsonAdapter,
    origin: Any
) {
    val firstData = json.parse(content, typeOf<T>(), T::class.java)
    assertEquals(origin, firstData)

    val secondContent = json.encode(firstData, typeOf<T>())
    val secondData = json.parse(secondContent, typeOf<T>(), T::class.java)

    assertEquals(origin, secondData)
    assertEquals(secondData, firstData)
}