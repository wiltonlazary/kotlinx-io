/*
 * Copyright 2017-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.io.json

import kotlinx.io.bytes.*
import kotlinx.io.json.internal.*
import kotlinx.io.text.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.json.*
import kotlinx.serialization.list
import kotlinx.serialization.modules.*
import kotlin.test.*

abstract class JsonTestBase {
    protected val strict = ioJson(ioJsonConfiguration.Default)
    protected val unquoted = ioJson { unquoted = true }
    protected val nonStrict = ioJson { strictMode = false }

    @ImplicitReflectionSerializer
    internal inline fun <reified T : Any> ioJson.stringify(value: T, useStreaming: Boolean): String {
        val serializer = context.getContextualOrDefault(T::class)
        return stringify(serializer, value, useStreaming)
    }

    internal fun <T> ioJson.stringify(serializer: SerializationStrategy<T>, value: T, useStreaming: Boolean): String {
        return if (useStreaming) {
            stringify(serializer, value)
        } else {
            val tree = writeJson(value, serializer)
            // kotlinx.serialization/issues/277
            stringify(ioJsonElementSerializer, tree)
        }
    }

    @ImplicitReflectionSerializer
    inline fun <reified T : Any> Json.stringify(list: List<T>, useStreaming: Boolean): String {
        return if (useStreaming) {
            // Overload to test public list extension
            stringify(list)
        } else {
            stringify(context.getContextualOrDefault(T::class).list, list)
        }
    }

    @ImplicitReflectionSerializer
    inline fun <reified K : Any, reified V : Any> ioJson.stringify(map: Map<K, V>, useStreaming: Boolean): String {
        return if (useStreaming) {
            // Overload to test public map extension
            stringify(map)
        } else {
            val key = context.getContextualOrDefault(K::class)
            val value = context.getContextualOrDefault(V::class)
            stringify(MapSerializer(key, value), map)
        }
    }

    @ImplicitReflectionSerializer
    internal inline fun <reified T : Any> ioJson.parse(source: String, useStreaming: Boolean): T {
        val deserializer = context.getContextualOrDefault(T::class)
        return parse(deserializer, source, useStreaming)
    }

    internal fun <T> ioJson.parse(deserializer: DeserializationStrategy<T>, source: String, useStreaming: Boolean): T {
        return if (useStreaming) {
            parse(deserializer, source)
        } else {
            val parser = ioJsonReader(buildInput { writeUtf8String(source) })
            val input = ioStreamingJsonInput(this, ioWriteMode.OBJ, parser)
            val tree = input.decodeJson()
            if (!input.reader.isDone) {
                error("Reader has not consumed the whole input: ${input.reader}")
            }
            readJson(tree, deserializer)
        }
    }

    @ImplicitReflectionSerializer
    internal inline fun <reified T : Any> ioJson.parseList(content: String, useStreaming: Boolean): List<T> {
        return if (useStreaming) {
            // Overload to test public list extension
            parseList(content)
        } else {
            parse(context.getContextualOrDefault(T::class).list, content, useStreaming)
        }
    }

    @ImplicitReflectionSerializer
    internal inline fun <reified K : Any, reified V : Any> ioJson.parseMap(
        content: String,
        useStreaming: Boolean
    ): Map<K, V> {
        return if (useStreaming) {
            // Overload to test public map extension
            parseMap(content)
        } else {
            val key = context.getContextualOrDefault(K::class)
            val value = context.getContextualOrDefault(V::class)
            parse(
                MapSerializer(key, value),
                content,
                useStreaming
            )
        }
    }

    protected fun parametrizedTest(test: (Boolean) -> Unit) {
        val streamingResult = runCatching { test(true) }
        val treeResult = runCatching { test(false) }
        processResults(streamingResult, treeResult)
    }

    private inner class DualFormat(
        val json: ioJson,
        val useStreaming: Boolean,
        override val context: SerialModule = EmptyModule
    ) : StringFormat {
        override fun <T> stringify(serializer: SerializationStrategy<T>, obj: T): String {
            return json.stringify(serializer, obj, useStreaming)
        }

        override fun <T> parse(deserializer: DeserializationStrategy<T>, string: String): T {
            return json.parse(deserializer, string, useStreaming)
        }
    }

    protected fun parametrizedTest(json: ioJson, test: StringFormat.(StringFormat) -> Unit) {
        val streamingResult = runCatching { json.test(DualFormat(json, true)) }
        val treeResult = runCatching { json.test(DualFormat(json, false)) }
        processResults(streamingResult, treeResult)
    }

    private fun processResults(streamingResult: Result<*>, treeResult: Result<*>) {
        val results = listOf(streamingResult, treeResult)
        results.forEachIndexed { index, result ->
            if (result.isFailure)
                throw Exception("Failed ${if (index == 0) "streaming" else "tree"} test", result.exceptionOrNull()!!)
        }
        assertEquals(streamingResult.getOrNull()!!, treeResult.getOrNull()!!)
    }

    /**
     * Same as [assertStringFormAndRestored], but tests both json converters (streaming and tree)
     * via [parametrizedTest]
     */
    internal fun <T> assertJsonFormAndRestored(
        serializer: KSerializer<T>,
        data: T,
        expected: String,
        json: ioJson = unquoted,
        printResult: Boolean = false
    ) {
        parametrizedTest { useStreaming ->
            val serialized = json.stringify(serializer, data, useStreaming)
            assertEquals(expected, serialized)
            val deserialized: T = json.parse(serializer, serialized, useStreaming)
            assertEquals(data, deserialized)
        }
    }

    inline fun <reified T : Throwable> assertFailsWithMessage(message: String, block: () -> Unit) {
        val exception = assertFailsWith(T::class, null, block)
        assertTrue(
            exception.message!!.contains(message),
            "Expected message '${exception.message}' to contain substring '$message'"
        )
    }
}
