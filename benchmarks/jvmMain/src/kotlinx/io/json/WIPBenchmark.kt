package kotlinx.io.json

import kotlinx.io.*
import kotlinx.io.bytes.*
import kotlinx.io.text.*
import org.openjdk.jmh.annotations.*
import java.util.concurrent.*

/**
 * ./gradlew :kotlinx-io-benchmarks:jvmBenchmark -PbenchmarkName="WIPBenchmark"
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class WIPBenchmark {
    @Benchmark
    fun largeASCIIKt() = largeTextPacketASCII.createInput().readUtf8String()

//    @Benchmark
//    fun largeAsciiBA() = buildString {
//        decodeAsciiChars(largeTextBytesASCII, this)
//    }

//    @Benchmark
//    fun largeAsciiBB() = buildString {
//        decodeAsciiCharsBB(java.nio.ByteBuffer.wrap(largeTextBytesASCII, 0, largeTextBytesASCII.size), this)
//    }

//    @Benchmark
//    fun largeAsciiReader() = buildString {
//        ByteArrayInputStream(largeTextBytesASCII).bufferedReader().readText()
//    }

//    @Benchmark
//    fun largeASCIIStringCtor() = String(largeTextBytesASCII, Charsets.UTF_8)

    companion object {
        private val smallTextBytes = "\u0422\u0432\u0437.".toByteArray()
        private val smallTextBytesASCII = "ABC.".toByteArray()

        private val largeTextBytes = ByteArray(smallTextBytes.size * 10000) {
            smallTextBytes[it % smallTextBytes.size]
        }

        private val largeTextBytesASCII = ByteArray(smallTextBytesASCII.size * 10000) {
            smallTextBytesASCII[it % smallTextBytesASCII.size]
        }

        private val smallTextPacket = BytesOutput().apply {
            writeByteArray(smallTextBytes)
        }
        private val smallTextPacketASCII = BytesOutput().apply {
            writeByteArray(smallTextBytesASCII)
        }
        private val largeTextPacket = BytesOutput().apply {
            writeByteArray(largeTextBytes)
        }
        private val largeTextPacketASCII = BytesOutput().apply {
            writeByteArray(largeTextBytesASCII)
        }
    }
}