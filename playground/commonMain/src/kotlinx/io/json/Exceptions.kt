package kotlinx.io.json

import kotlin.jvm.*

/**
 * A generic exception indicating the problem during serialization or deserialization process
 */
public open class SerializationException @JvmOverloads constructor(
    message: String, cause: Throwable? = null
) : RuntimeException(message, cause)

/**
 * Generic exception indicating a problem with JSON operations.
 */
public open class JsonException(message: String) : SerializationException(message)

/**
 * Exception thrown when [Json] has failed to parse provided JSON or deserialize it to a given model.
 *
 * Such exception usually indicate that [Json] input is not a valid JSON.
 */
public class JsonDecodingException(
    position: Int, message: String
) : JsonException("Invalid JSON at $position: $message")

/**
 * Exception thrown when [Json] has failed to create JSON string or encode particular value
 *
 * Such exception usually indicates that input data can't be represented as a valid JSON
 */
public class JsonEncodingException(message: String) : JsonException(message)
