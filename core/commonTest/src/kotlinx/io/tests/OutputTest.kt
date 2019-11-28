package kotlinx.io.tests

import kotlinx.io.*
import kotlinx.io.buffer.*
import kotlinx.io.bytes.*
import kotlin.test.*

class OutputTest {
    @Test
    fun testBuildBytes() {
        val input = buildInput {
            writeLong(0x0001020304050607)
            writeLong(0x08090A0B0C0D0E0F)
            writeInt(0x08090A0B)
            writeInt(0x00010203)
        }

        input.apply {
            assertFalse(eof())
            assertReadLong(0x0001020304050607)
            assertReadLong(0x08090A0B0C0D0E0F)
            assertReadInt(0x08090A0B)
            assertReadInt(0x00010203)
            assertTrue(eof())
        }
    }

    @Test
    fun testBuildBytesChunked() {
        val input = buildInput(2) {
            writeByte(0xFF.toByte())
            writeInt(0x08090A0B)
            writeInt(0x00010203)
            writeInt(0xAB023F3)
            writeInt(0xDEAD) // by writing unit tests
        }

        input.apply {
            assertFalse(eof())
            assertReadByte(0xFF.toByte())
            assertReadInt(0x08090A0B)
            assertReadInt(0x00010203)
            assertReadInt(0xAB023F3)
            assertReadInt(0xDEAD)
            assertTrue(eof())
        }
    }

    @Test
    @Ignore
    fun testPipeFromEmpty() {
        val source = buildInput {
        }

        val result = buildInput {
//            pipeFrom(source)
        }

        assertTrue(result.eof())
    }

    @Test
    @Ignore
    fun testPipeFrom() {
        var startWrite = false

        val source = buildInput {
            startWrite = true
            writeByte(42)
        }

        val result = buildInput {
//            pipeFrom(source)
        }

        assertFalse(startWrite)
        result.assertReadByte(42)
        assertTrue(startWrite)
        assertTrue(result.eof())
    }

    @Test
    @Ignore
    fun testPipeFromInfinite() {
        val output = BytesOutput()
//        output.pipeFrom(TestInput())

        output.createInput().apply {
            repeat(100) {
                assertReadByte(42)
            }
        }
    }
}

private class TestInput : Input() {

    override fun fill(buffer: Buffer): Int {
        buffer.storeByteAt(0, 42)
        return 1
    }

    override fun closeSource() {
    }
}