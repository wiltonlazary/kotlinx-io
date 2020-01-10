package kotlinx.io.tests

import kotlin.test.*

fun assertArrayEquals(expected: ByteArray, actual: ByteArray) {
    assertEquals(expected.toHexString(), actual.toHexString())
}

fun ByteArray.toHexString(): String = "0x" + joinToString("") {
    it.toUInt().toString(16).padStart(2, '0')
}
