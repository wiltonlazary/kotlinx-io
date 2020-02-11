package kotlinx.io.text.utf8

import kotlinx.io.text.*

/**
 * Inline depth optimisation
 */
internal fun malformedInput(codePoint: Int): Nothing {
    throw MalformedInputException("Malformed Utf8 input, current code point $codePoint")
}

@Suppress("NOTHING_TO_INLINE")
internal inline fun lowSurrogate(codePoint: Int): Int = (codePoint and 0x3ff) + MinLowSurrogate

@Suppress("NOTHING_TO_INLINE")
internal inline fun highSurrogate(codePoint: Int): Int = (codePoint ushr 10) + HighSurrogateMagic


internal const val MinLowSurrogate = 0xdc00
private const val MinHighSurrogate = 0xd800
private const val MinSupplementary = 0x10000

internal const val HighSurrogateMagic = MinHighSurrogate - (MinSupplementary ushr 10)

// Alternative implementation, slower x1.5
// Based on https://bjoern.hoehrmann.de/utf-8/decoder/dfa/
// 364 ints


internal const val STATE_FINISH = -2
internal const val STATE_UTF_8 = 0
internal const val STATE_REJECT = 1

internal const val MaxCodePoint = 0x10ffff
