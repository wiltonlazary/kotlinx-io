package kotlinx.io.json


internal class JsonParserInput(private val reader: JsonReaderInput) {

    fun read(): JsonElement = when (reader.nextToken()) {
        TC_OTHER -> readValue(isString = false)
        TC_STRING -> readValue(isString = true)
        TC_BEGIN_OBJ -> readObject()
        TC_BEGIN_LIST -> readArray()
        else -> reader.fail("Can't begin reading element, unexpected token")
    }

    private fun readObject(): JsonElement {
        val result = linkedMapOf<String, JsonElement>()
        reader.consume(TC_BEGIN_OBJ) { "Expected '{', but found '$it' " }

        while (true) {
            val key = readObjectKey()

            reader.consume(TC_COLON) { "Expected ':', but found '$it' " }

            val value = read()
            result[key] = value

            val token = reader.takeNextToken()
            if (token == TC_END_OBJ) {
                break
            }

            if (token != TC_COMMA) {
                reader.fail("\"Expected ',', Actual '$token'\"")
            }
        }

        return JsonObject(result)
    }

    private fun readObjectKey(): String {
        if (reader.nextToken() == TC_STRING) {
            reader.consume(TC_STRING) { "Internal error. Please file an issue." }
            return reader.takeString()
        }

        return reader.takeLiteral()
    }

    private fun readValue(isString: Boolean): JsonElement {
        val value = if (isString) {
            reader.consume(TC_STRING) { "String expected" }
            reader.takeString()
        } else {
            val literal = reader.takeLiteral()
            if (literal == NULL) {
                return JsonNull
            } else literal
        }

        return JsonLiteral(value, isString)
    }

    private fun readArray(): JsonElement {
        val result = arrayListOf<JsonElement>()

        reader.consume(TC_BEGIN_LIST) { "List expected" }
        while (true) {
            result += read()

            val token = reader.takeNextToken()
            if (token == TC_END_LIST) {
                break
            }

            if (token != TC_COMMA) {
                reader.fail("\"Expected ',', Actual '$token'\"")
            }
        }

        return JsonArray(result)
    }
}

internal inline fun JsonReaderInput.consume(expected: Byte, errorMessage: (Char) -> String) {
    val type = takeNextToken()
    if (type != expected) {
        fail(errorMessage(type.toChar()), position - 1)
    }
}
