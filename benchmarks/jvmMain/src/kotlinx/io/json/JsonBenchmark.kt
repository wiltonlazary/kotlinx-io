package json.kotlinx.io.json

import kotlinx.benchmark.*
import kotlinx.io.*
import kotlinx.io.json.*
import kotlinx.io.json.data.*
import kotlinx.serialization.*
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import java.util.concurrent.*
import kotlin.reflect.*

@ImplicitReflectionSerializer
@ExperimentalStdlibApi
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class JsonBenchmark {

    val canada = Resource("canada.json").readText()
    val citmCatalog = Resource("citm_catalog.json").readText()
    val twitter = Resource("twitter.json").readText()

    val jsons = mapOf(
        "io" to KxJson,
        "default" to SerializationJson,
        "gson" to GsonJson
    )

    class Dataset(val content: String, val type: KType, val clazz: Class<*>, val data: Any)

    val canadaObject = ioJson.parse<Canada>(canada)
    val citmObject = ioJson.parse<CitmCatalog>(citmCatalog)
    val twitterObject = ioJson.parse<Twitter>(twitter)

    val datasets = mapOf(
        "canada" to Dataset(canada, typeOf<Canada>(), Canada::class.java, canadaObject),
        "citm" to Dataset(citmCatalog, typeOf<CitmCatalog>(), CitmCatalog::class.java, citmObject),
        "twitter" to Dataset(twitter, typeOf<Twitter>(), Twitter::class.java, twitterObject)
    )

    @Param("canada", "citm", "twitter")
    var datasetName: String = ""

    @Param("io", "default", "gson")
    var jsonName: String = ""

    @Benchmark
    fun benchmarkParse() {
        val json = jsons[jsonName]!!
        val dataset = datasets[datasetName]!!

        json.parse(dataset.content, dataset.type, dataset.clazz)
    }

    @Benchmark
    fun benchmarkWrite() {
        val json = jsons[jsonName]!!
        val dataset = datasets[datasetName]!!

        json.encode(dataset.data, dataset.type)
    }
}
