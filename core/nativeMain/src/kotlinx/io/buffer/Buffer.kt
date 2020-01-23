@file:Suppress("NOTHING_TO_INLINE", "IntroduceWhenSubject")

package kotlinx.io.buffer

import kotlinx.cinterop.*
import kotlinx.io.*
import kotlin.native.concurrent.*

public actual class Buffer constructor(
    val array: ByteArray,
    inline val offset: Int = 0,
    actual inline val size: Int = array.size - offset
) {
    init {
        requirePositiveIndex(size, "size")
    }

    public actual inline fun loadByteAt(index: Int): Byte = array[assertIndex(offset + index, 1)]

    public actual inline fun storeByteAt(index: Int, value: Byte) {
        array[assertIndex(offset + index, 1)] = value
    }

    public actual companion object {
        @SharedImmutable
        public actual val EMPTY: Buffer = Buffer(ByteArray(0))
    }
}

/**
 * Executes block with raw [pointer] to [Buffer] memory area.
 *
 * Consider using it only in interop calls.
 */
public inline fun <R> Buffer.usePointer(block: (pointer: CPointer<ByteVar>) -> R) = array.usePinned {
    block((it.addressOf(0) + offset)!!)
}

/**
 * Wrap [array] into [Buffer] from [startIndex] to [endIndex].
 */
@ExperimentalIoApi
public actual fun bufferOf(array: ByteArray, startIndex: Int, endIndex: Int): Buffer =
    Buffer(array, startIndex, endIndex - startIndex)
