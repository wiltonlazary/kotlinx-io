/*
 * Copyright 2017-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */
package kotlinx.io.json

import kotlinx.io.*
import kotlinx.io.text.*

internal class JsonReaderInput(private val source: Input) {
    internal var position = 0

    public fun nextToken(): Byte {
        var resultToken: Byte = TC_INVALID

        position += source.readUntilExclusive {
            when (val token = charToTokenClass(it)) {
                TC_WS -> return@readUntilExclusive true
                else -> {
                    resultToken = token
                    return@readUntilExclusive false
                }
            }
        }

        return if (resultToken != TC_INVALID) {
            resultToken
        } else {
            TOKEN_EOF
        }
    }

    public fun takeNextToken(): Byte {
        var resultToken: Byte = TC_INVALID

        position += source.readUntil {
            when (val token = charToTokenClass(it)) {
                TC_WS -> return@readUntil true
                else -> {
                    resultToken = token
                    return@readUntil false
                }
            }
        }

        return if (resultToken != TC_INVALID) {
            resultToken
        } else {
            TOKEN_EOF
        }
    }

    fun takeString(): String = buildString {
        var escape = false
        var unicodeEscape = false
        var unicodeChar = 0
        var unicodeSize = 4

        position += source.decodeUtf8Chars {
            if (escape) {
                escape = false
                if (it == UNICODE_ESC) {
                    unicodeEscape = true
                    return@decodeUtf8Chars true
                }

                val unescaped = escapeToChar(it.toInt())
                require(unescaped != INVALID, position) { "Invalid escaped char '$it'" }
                append(unescaped)
                return@decodeUtf8Chars true
            }

            if (unicodeEscape) {
                unicodeChar = fromHexChar(it) or (unicodeChar shl 4)
                unicodeSize -= 1

                if (unicodeSize == 0) {
                    append(unicodeChar.toChar())
                    unicodeEscape = false
                    unicodeChar = 0
                    unicodeSize = 4
                }
            }

            if (it == STRING_ESC) {
                escape = true
                return@decodeUtf8Chars true
            }

            if (it != STRING) {
                append(it)
            }

            it != STRING
        }
    }

    fun takeLiteral(): String = buildString {
        position += source.readUntilExclusive {
            if (charToTokenClass(it) == TC_OTHER) {
                append(it.toChar())
                return@readUntilExclusive true
            } else {
                return@readUntilExclusive false
            }
        }
    }

    override fun toString(): String {
        return "JsonReader(source='$source', position='$position')"
    }


    private fun fromHexChar(char: Char): Int = when (char) {
        in '0'..'9' -> char.toInt() - '0'.toInt()
        in 'a'..'f' -> char.toInt() - 'a'.toInt() + 10
        in 'A'..'F' -> char.toInt() - 'A'.toInt() + 10
        else -> fail("Invalid toHexChar char '$char' in unicode escape")
    }

    fun fail(message: String, position: Int = this.position): Nothing {
        throw JsonDecodingException(position, message)
    }

    private fun require(condition: Boolean, position: Int = this.position, message: () -> String) {
        if (!condition) {
            fail(message(), position)
        }
    }
}
