package kotlinx.io.tests

import kotlinx.io.*
import kotlinx.io.buffer.*
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

        input.readAvailableTo(output)

        assertNotNull(instance)
        @Suppress("FORBIDDEN_IDENTITY_EQUALS")
        assertTrue(instance === result)
    }
}

