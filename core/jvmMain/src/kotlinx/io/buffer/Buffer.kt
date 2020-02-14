@file:Suppress("NOTHING_TO_INLINE")

package kotlinx.io.buffer

import kotlinx.io.*
import java.nio.*
import java.nio.ByteOrder

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual typealias Buffer = ByteBuffer

/**
 * Size of buffer range in bytes.
 */
public actual inline val Buffer.size: Int get() = limit()

/**
 * Returns byte at [index] position.
 * May throw [IndexOutOfBoundsException] if index is negative or greater than buffer size.
 */
public actual fun Buffer.loadByteAt(index: Int): Byte = get(index)

/**
 * Writes byte [value] at the specified [index].
 * May throw [IndexOutOfBoundsException] if index is negative or greater than buffer size.
 */
public actual fun Buffer.storeByteAt(index: Int, value: Byte) {
    put(index, value)
}

/**
 * Wrap [array] into [Buffer] from [startIndex] to [endIndex].
 */
@ExperimentalIoApi
public actual fun bufferOf(array: ByteArray, startIndex: Int, endIndex: Int): Buffer =
    ByteBuffer.wrap(array, startIndex, endIndex - startIndex)
