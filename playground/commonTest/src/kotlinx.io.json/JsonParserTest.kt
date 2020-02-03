/*
 * Copyright 2017-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.io.json

import kotlinx.io.bytes.*
import kotlinx.io.text.*
import kotlin.test.*


class JsonParserTest {
    @Test
    fun testQuotedBrace() {
        val tree = parse("""{x: "{"}""")
        assertTrue("x" in tree)
        assertEquals("{", tree.getAs<JsonLiteral>("x").content)
    }

    private fun parse(input: String): JsonObject =
        JsonParserInput(JsonReaderInput(buildInput { writeUtf8String(input) })).read().jsonObject

    @Test
    fun testEmptyKey() {
        val tree = parse("""{"":"","":""}""")
        assertTrue("" in tree)
        assertEquals("", tree.getAs<JsonLiteral>("").content)
    }

    @Test
    fun testEmptyValue() {
        assertFailsWith<JsonDecodingException> {
            parse("""{"X": "foo", "Y"}""")
        }
    }

    @Test
    fun testIncorrectUnicodeEscape() {
        assertFailsWith<JsonDecodingException> {
            parse("""{"X": "\uDD1H"}""")
        }
    }
}
