package kotlinx.io.tests

import kotlinx.io.*
import kotlinx.io.buffer.*
import kotlinx.io.bytes.buildInput
import kotlin.test.*

class InputTest {

    @Test
    fun testReadAvailableToWithSameBuffer() {
        var instance: Buffer = Buffer.EMPTY
        var result: Buffer = Buffer.EMPTY

        val input: Input = LambdaInput {
            instance = it
            return@LambdaInput 42
        }

        val output = LambdaOutput { source, endIndex ->
            result = source
            assertEquals(42, endIndex)
        }

        input.copyAvailableTo(output)

        assertNotNull(instance)
        @Suppress("FORBIDDEN_IDENTITY_EQUALS")
        assertTrue(instance === result)
    }

    @Test
    fun testCopyTo() {
        val source = ByteArray(4 * 1024) { it.toByte() }
        val input = buildInput {
            writeByteArray(source)
        }

        val output = ByteArrayOutput()
        input.copyTo(output)

        val result = output.toByteArray()
        assertArrayEquals(source, result)
    }
}

