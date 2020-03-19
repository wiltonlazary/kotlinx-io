package kotlinx.io.text.utf8

import kotlinx.io.*
import kotlinx.io.buffer.*
import kotlinx.io.text.*
import kotlin.math.*

private const val lastASCII = 0x7F.toChar()
private const val lastASCIIInt: Int = 0x7F

/**
 * Write [length] chars in Utf-8 from the [text] starting from offset [index] to output.
 *
 * @throws MalformedInputException if encoding is invalid.
 */
public fun Output.writeUtf8String(text: String, index: Int = 0, length: Int = text.length - index) {
    if (text.isASCII(index, length)) {
        writeASCIIString(text, index, length)
    } else {
        writeUtf8StringExact(text, index, length)
    }
}

public fun Output.writeASCIIString(text: String, index: Int = 0, length: Int = text.length - index) {
    var current = index
    var remaining = length

    while (remaining > 0) {
        val written = writeBuffer { buffer, bufferStart, bufferEnd ->
            val count = min(bufferEnd - bufferStart, remaining)

            for (offset in 0 until count) {
                buffer[bufferStart + offset] = text[current + offset].toByte()
            }

            bufferStart + count
        }

        if (written == 0) {
            unexpectedEOF()
        }

        current += written
        remaining -= written
    }
}


/**
 * Write single UTF-8 [character] to [Output].
 *
 * @return count of written bytes
 * @throws MalformedInputException if [character] is splitted surrogate or invalid.
 */
public fun Output.writeUtf8Char(character: Char): Int {
    // ASCII character
    if (character <= lastASCII) {
        writeByte(character.toByte())
        return 1
    }

    if (character.isHighSurrogate()) {
        throw MalformedInputException("Splitted surrogate character: $character")
    }

    val code = character.toInt()

    return when {
        code <= 0x7ff -> {
            val byte0 = (0xc0 or ((code shr 6) and 0x1f))
            val byte1 = (code and 0x3f) or 0x80
            writeShort(((byte0 shl 8) or byte1).toShort())
            2
        }
        code <= 0xffff -> {
            val byte0 = ((code shr 12) and 0x0f or 0xe0).toByte()
            val byte1 = ((code shr 6) and 0x3f) or 0x80
            val byte2 = (code and 0x3f) or 0x80
            writeByte(byte0)
            writeShort(((byte1 shl 8) or byte2).toShort())
            3
        }
        code <= 0x10ffff -> {
            val byte0 = ((code shr 18) and 0x07 or 0xf0)
            val byte1 = ((code shr 12) and 0x3f) or 0x80
            val byte2 = ((code shr 6) and 0x3f) or 0x80
            val byte3 = (code and 0x3f) or 0x80
            writeInt((byte0 shl 24) or (byte1 shl 16) or (byte2 shl 8) or byte3)
            4
        }
        else -> malformedCodePoint(code)
    }
}

private fun Output.writeUtf8StringExact(text: String, index: Int = 0, length: Int = text.length - index) {
    var currentIndex = index
    val lastIndex = index + length

    while (currentIndex < lastIndex) {
        val char = text[currentIndex++]

        if (char.toInt() <= lastASCII.toInt()) {
            writeByte(char.toByte())
            continue
        }

        val code = if (!char.isHighSurrogate()) {
            char.toInt()
        } else {
            if (currentIndex == lastIndex) {
                splittedSurogate()
            }

            val nextChar = text[currentIndex++]
            codePoint(char, nextChar)
        }

        writeCodePoint(code)
    }
}

private fun Output.writeCodePoint(code: Int) {
    var bytes = encodeCodePoint(code)
    while (bytes != 0) {
        writeByte((bytes and 0xFF).toByte())
        bytes = bytes ushr 8
    }
}

private fun String.indexOfFirstNonASCII(startIndex: Int, endIndex: Int): Int {
    for (index in startIndex until endIndex) {
        if (this[index] > lastASCII) {
            return index
        }
    }

    return endIndex
}

private fun String.isASCII(startIndex: Int, length: Int): Boolean {
    for (it in startIndex until startIndex + length) {
        if (this[it].toInt() > lastASCII.toInt()) {
            return false
        }
    }

    return true
}

private fun encodeCodePoint(code: Int): Int = when {
    code <= 0x7ff -> {
        val byte0 = ((code shr 6) and 0x1F) or 0xC0
        val byte1 = code.lowBitMask()
        (byte1 shl 8) or byte0
    }
    code <= 0xffff -> {
        val byte0 = ((code shr 12) and 0x0F) or 0xE0
        val byte1 = (code shr 6).lowBitMask()
        val byte2 = code.lowBitMask()
        (byte2 shl 16) or (byte1 shl 8) or byte0
    }
    code <= 0x10ffff -> {
        val byte0 = ((code shr 18) and 0x07) or 0xF0
        val byte1 = (code shr 12).lowBitMask()
        val byte2 = (code shr 6).lowBitMask()
        val byte3 = code.lowBitMask()
        (byte3 shl 24) or (byte2 shl 16) or (byte1 shl 8) or byte0
    }
    else -> malformedCodePoint(code)
}

private fun Int.lowBitMask(): Int = ((this and 0x3F) or 0x80) and 0xFF

internal fun unexpectedEOF() {
    throw EOFException("Unexpected end of Input")
}

internal fun codePoint(high: Char, low: Char): Int {
    check(high.isHighSurrogate())
    check(low.isLowSurrogate())

    val highValue = high.toInt() - HighSurrogateMagic
    val lowValue = low.toInt() - MinLowSurrogate

    return highValue shl 10 or lowValue
}

private fun malformedCodePoint(codePoint: Int): Nothing {
    throw MalformedInputException("Malformed Utf8 code point $codePoint")
}

internal fun splittedSurogate(): Nothing {
    throw MalformedInputException("Splitted surrogate character")
}
