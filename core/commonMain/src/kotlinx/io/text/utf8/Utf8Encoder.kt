package kotlinx.io.text.utf8

import kotlinx.io.text.*

internal fun codePoint(high: Char, low: Char): Int {
    check(high.isHighSurrogate())
    check(low.isLowSurrogate())

    val highValue = high.toInt() - HighSurrogateMagic
    val lowValue = low.toInt() - MinLowSurrogate

    return highValue shl 10 or lowValue
}

internal fun malformedCodePoint(codePoint: Int): Nothing {
    // TODO: revise exceptions
    throw MalformedInputException("Malformed Utf8 code point 0x${codePoint.toString(16)}")
}