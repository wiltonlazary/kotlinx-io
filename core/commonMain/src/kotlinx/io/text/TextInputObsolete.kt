package kotlinx.io.text

import kotlinx.io.*
import kotlinx.io.text.utf8.*

private const val DEFAULT_CAPACITY: Int = 32

/**
 * Read UTF-8 string until [delimiter] to [output].
 *
 * @throws MalformedInputException if decoder fail to recognize charset.
 */
public fun Input.readUtf8StringUntilDelimiterTo(output: Appendable, delimiter: Char): Int = decodeUtf8Chars {
    if (it == delimiter) {
        return@decodeUtf8Chars false
    }
    output.append(it)
    true
}

/**
 * Read UTF-8 string until any of the [delimiters] to [output]. The delimiter will be consumed from [Input]
 * @throws MalformedInputException if decoder fail to recognize charset.
 */
public fun Input.readUtf8StringUntilDelimitersTo(output: Appendable, delimiters: String): Int = decodeUtf8Chars {
    if (it in delimiters) {
        return@decodeUtf8Chars false
    }

    output.append(it)
    true
}

/**
 * Read fixed [length] UTF-8 string to [output].
 *
 * @throws MalformedInputException if decoder fail to recognize charset.
 */
public fun Input.readUtf8StringTo(output: Appendable, length: Int = Int.MAX_VALUE): Int {
    var remaining = length
    return decodeUtf8Chars {
        output.append(it)
        --remaining > 0
    }
}

/**
 * Read UTF-8 string to [output] until CRLF("\r\n") chars.
 *
 * @throws MalformedInputException if decoder fail to recognize charset.
 */
public fun Input.readUtf8LineTo(output: Appendable, limit: Int = Int.MAX_VALUE) {
    var remaining = limit
    // TODO: consumes char after lonely CR
    var seenCR = false
    decodeUtf8Chars {
        if (it == '\r') {
            seenCR = true
            return@decodeUtf8Chars true // continue & skip
        }

        if (it == '\n') {
            return@decodeUtf8Chars false // stop & skip
        } else if (seenCR) {
            return@decodeUtf8Chars false
        } // lonely CR, stop & skip

        output.append(it)
        remaining--
        remaining > 0
    }
}

/**
 * Read fixed [length] UTF-8 string.
 *
 * @throws MalformedInputException if decoder fail to recognize charset.
 */
public fun Input.readUtf8String(length: Int = Int.MAX_VALUE): String {
    val capacity = if (length == Int.MAX_VALUE) DEFAULT_CAPACITY else length
    return buildString(capacity) {
        readUtf8StringTo(this, length)
    }
}

/**
 * Read UTF-8 string until [delimiter].
 *
 * @throws MalformedInputException if decoder fail to recognize charset.
 */
public fun Input.readUtf8StringUntilDelimiter(delimiter: Char): String = buildString {
    readUtf8StringUntilDelimiterTo(this, delimiter)
}

/**
 * Read UTF-8 string until any of the [delimiters].
 *
 * @throws MalformedInputException if decoder fail to recognize charset.
 */
public fun Input.readUtf8StringUntilDelimiters(delimiters: String): String = buildString {
    readUtf8StringUntilDelimitersTo(this, delimiters)
}
