/*
 * Copyright 2017-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */
package kotlinx.io.json

import kotlin.jvm.*

// Streaming JSON reader
internal class JsonReaderOrigin(private val source: String) {

    @JvmField
    var currentPosition: Int = 0 // position in source

    @JvmField
    var tokenClass: Byte = TOKEN_EOF

    public val isDone: Boolean get() = tokenClass == TOKEN_EOF

    public val canBeginValue: Boolean
        get() = when (tokenClass) {
            TC_BEGIN_LIST, TC_BEGIN_OBJ, TC_OTHER, TC_STRING, TC_NULL -> true
            else -> false
        }

    // updated by nextToken
    private var tokenPosition: Int = 0

    // update by nextString/nextLiteral
    private var offset = -1 // when offset >= 0 string is in source, otherwise in buf
    private var length = 0 // length of string
    private var buf = CharArray(16) // only used for strings with escapes

    init {
        nextToken()
    }

    internal inline fun requireTokenClass(expected: Byte, errorMessage: (Char) -> String) {
        if (tokenClass != expected) fail(errorMessage(tokenClass.toChar()), tokenPosition)
    }

    fun takeString(): String {
        if (tokenClass != TC_OTHER && tokenClass != TC_STRING) fail(
            "Expected string or non-null literal",
            tokenPosition
        )
        val prevStr = if (offset < 0)
            String(buf, 0, length) else
            source.substring(offset, offset + length)
        nextToken()
        return prevStr
    }

    private fun append(ch: Char) {
        if (length >= buf.size) buf = buf.copyOf(2 * buf.size)
        buf[length++] = ch
    }

    // initializes buf usage upon the first encountered escaped char
    private fun appendRange(source: String, fromIndex: Int, toIndex: Int) {
        val addLen = toIndex - fromIndex
        val oldLen = length
        val newLen = oldLen + addLen
        if (newLen > buf.size) buf = buf.copyOf(newLen.coerceAtLeast(2 * buf.size))
        for (i in 0 until addLen) buf[oldLen + i] = source[fromIndex + i]
        length += addLen
    }

    fun nextToken() {
        val source = source
        var currentPosition = currentPosition
        while (currentPosition < source.length) {
            val ch = source[currentPosition]
            when (val tc = charToTokenClass(ch)) {
                TC_WS -> currentPosition++ // skip whitespace
                TC_OTHER -> {
                    nextLiteral(source, currentPosition)
                    return
                }
                TC_STRING -> {
                    nextString(source, currentPosition)
                    return
                }
                else -> {
                    this.tokenPosition = currentPosition
                    this.tokenClass = tc
                    this.currentPosition = currentPosition + 1
                    return
                }
            }
        }

        tokenPosition = currentPosition
        tokenClass = TOKEN_EOF
    }

    private fun nextLiteral(source: String, startPos: Int) {
        tokenPosition = startPos
        offset = startPos
        var currentPosition = startPos
        while (currentPosition < source.length && charToTokenClass(source[currentPosition]) == TC_OTHER) {
            currentPosition++
        }
        this.currentPosition = currentPosition
        length = currentPosition - offset
        tokenClass = if (rangeEquals(source, offset, length, NULL)) TC_NULL else TC_OTHER
    }

    private fun nextString(source: String, startPosition: Int) {
        tokenPosition = startPosition
        length = 0 // in buffer
        var currentPosition = startPosition + 1
        var lastPosition = currentPosition
        val length = source.length
        while (source[currentPosition] != STRING) {
            if (currentPosition >= length) fail("Unexpected EOF", currentPosition)
            if (source[currentPosition] == STRING_ESC) {
                appendRange(source, lastPosition, currentPosition)
                val newPosition = appendEsc(source, currentPosition + 1)
                currentPosition = newPosition
                lastPosition = newPosition
            } else {
                currentPosition++
            }
        }
        if (lastPosition == startPosition + 1) {
            // there was no escaped chars
            offset = lastPosition
            this.length = currentPosition - lastPosition
        } else {
            // some escaped chars were there
            appendRange(source, lastPosition, currentPosition)
            this.offset = -1
        }
        this.currentPosition = currentPosition + 1
        tokenClass = TC_STRING
    }

    private fun appendEsc(source: String, startPosition: Int): Int {
        var currentPosition = startPosition
        require(currentPosition < source.length, currentPosition) { "Unexpected EOF after escape character" }
        val currentChar = source[currentPosition++]
        if (currentChar == UNICODE_ESC) {
            return appendHex(source, currentPosition)
        }

        val c = escapeToChar(currentChar.toInt())
        require(c != INVALID, currentPosition) { "Invalid escaped char '$currentChar'" }
        append(c)
        return currentPosition
    }

    private fun appendHex(source: String, startPos: Int): Int {
        var curPos = startPos
        append(
            ((fromHexChar(source, curPos++) shl 12) +
                    (fromHexChar(source, curPos++) shl 8) +
                    (fromHexChar(source, curPos++) shl 4) +
                    fromHexChar(source, curPos++)).toChar()
        )
        return curPos
    }

    fun skipElement() {
        if (tokenClass != TC_BEGIN_OBJ && tokenClass != TC_BEGIN_LIST) {
            nextToken()
            return
        }
        val tokenStack = mutableListOf<Byte>()
        do {
            when (tokenClass) {
                TC_BEGIN_LIST, TC_BEGIN_OBJ -> tokenStack.add(tokenClass)
                TC_END_LIST -> {
                    if (tokenStack.last() != TC_BEGIN_LIST) throw JsonDecodingException(
                        currentPosition,
                        "found ] instead of }"
                    )
                    tokenStack.removeAt(tokenStack.size - 1)
                }
                TC_END_OBJ -> {
                    if (tokenStack.last() != TC_BEGIN_OBJ) throw JsonDecodingException(
                        currentPosition,
                        "found } instead of ]"
                    )
                    tokenStack.removeAt(tokenStack.size - 1)
                }
            }
            nextToken()
        } while (tokenStack.isNotEmpty())
    }

    override fun toString(): String {
        return "JsonReader(source='$source', currentPosition=$currentPosition, tokenClass=$tokenClass, tokenPosition=$tokenPosition, offset=$offset)"
    }

    public fun fail(message: String, position: Int = currentPosition): Nothing {
        throw JsonDecodingException(position, message)
    }

    internal inline fun require(condition: Boolean, position: Int = currentPosition, message: () -> String) {
        if (!condition) fail(message(), position)
    }

    private fun fromHexChar(source: String, currentPosition: Int): Int {
        require(currentPosition < source.length, currentPosition) { "Unexpected EOF during unicode escape" }
        return when (val curChar = source[currentPosition]) {
            in '0'..'9' -> curChar.toInt() - '0'.toInt()
            in 'a'..'f' -> curChar.toInt() - 'a'.toInt() + 10
            in 'A'..'F' -> curChar.toInt() - 'A'.toInt() + 10
            else -> fail("Invalid toHexChar char '$curChar' in unicode escape")
        }
    }
}
