package kotlinx.io.json

import kotlinx.benchmark.*
import kotlinx.io.*
import kotlinx.io.json.data.*
import kotlinx.io.json.utils.*
import kotlinx.serialization.*
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.Setup
import java.util.concurrent.*
import kotlin.reflect.*

/**
 * ./gradlew :kotlinx-io-benchmarks:jvmBenchmark -PbenchmarkName="JsonBenchmark"
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@UseExperimental(ExperimentalStdlibApi::class, ImplicitReflectionSerializer::class)
class JsonBenchmark {
    @Param("canada", "citm", "twitter")
    var datasetName: String = ""

    @Param("io", "default", "gson")
    var jsonName: String = ""

    private lateinit var data: Any
    private lateinit var content: String
    private lateinit var json: JsonAdapter
    private lateinit var type: KType
    private lateinit var clazz: Class<*>

    class Dataset(val content: String, val type: KType, val clazz: Class<*>, val data: Any)

    @Setup
    fun setup() {
        val dataset = JsonStreamBenchmark.datasets[datasetName]!!

        json = JsonStreamBenchmark.jsons[jsonName]!!
        content = dataset.content
        type = dataset.type
        clazz = dataset.clazz
        data = dataset.data
    }

    @Benchmark
    fun benchmarkRead() = json.parse(content, type, clazz)

    @Benchmark
    fun benchmarkWrite() = json.encode(data, type)

    companion object {
        val canada = Resource("canada.json").readText()
        val citmCatalog = Resource("citm_catalog.json").readText()
        val twitter = Resource("twitter.json").readText()

        val jsons = mapOf(
            "io" to KxJson,
            "default" to SerializationJson,
            "gson" to GsonJson
        )

        val canadaObject = ioJson.parse<Canada>(canada)
        val citmObject = ioJson.parse<CitmCatalog>(citmCatalog)
        val twitterObject = ioJson.parse<Twitter>(twitter)

        val datasets = mapOf(
            "canada" to Dataset(canada, typeOf<Canada>(), Canada::class.java, canadaObject),
            "citm" to Dataset(citmCatalog, typeOf<CitmCatalog>(), CitmCatalog::class.java, citmObject),
            "twitter" to Dataset(twitter, typeOf<Twitter>(), Twitter::class.java, twitterObject)
        )
    }
}
