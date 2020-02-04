package kotlinx.io.json

import com.fasterxml.jackson.module.kotlin.*
import com.google.gson.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlin.reflect.*

interface JsonAdapter {
    fun <T> parse(content: String, type: KType, clazz: Class<T>): T
    fun <T> encode(data: T, type: KType): String
}

@UseExperimental(ImplicitReflectionSerializer::class)
object KxJson : JsonAdapter {
    override fun <T> parse(content: String, type: KType, clazz: Class<T>): T =
        ioJson.parse(serializer(type), content) as T

    override fun <T> encode(data: T, type: KType): String =
        ioJson.stringify(serializer(type), data)
}

@UseExperimental(ImplicitReflectionSerializer::class)
object SerializationJson : JsonAdapter {
    override fun <T> parse(content: String, type: KType, clazz: Class<T>): T =
        Json.parse(serializer(type), content) as T


    override fun <T> encode(data: T, type: KType): String =
        Json.stringify(serializer(type), data)
}

object JacksonJson : JsonAdapter {
    private val jackson = jacksonObjectMapper()

    override fun <T> parse(content: String, type: KType, clazz: Class<T>): T = jackson.readValue(content, clazz)

    override fun <T> encode(data: T, type: KType): String = jackson.writeValueAsString(data)
}

object GsonJson : JsonAdapter {
    private val gson = Gson()

    override fun <T> parse(content: String, type: KType, clazz: Class<T>): T = gson.fromJson(content, clazz)

    override fun <T> encode(data: T, type: KType): String = gson.toJson(data)
}
