@file:Suppress("NOTHING_TO_INLINE", "IntroduceWhenSubject")

package kotlinx.io.buffer

import kotlinx.cinterop.*
import kotlinx.io.*

public actual class Buffer constructor(
    val array: ByteArray,
    inline val offset: Int = 0,
    inline val size: Int = array.size - offset
) {
    init {
        requirePositiveIndex(size, "size")
    }

    public fun Buffer.toString(): String = usePointer {
        "Buffer[$it:$size]"
    }
}

public actual inline val Buffer.size get() = size

public actual inline fun Buffer.loadByteAt(index: Int): Byte = array[assertIndex(offset + index, 1)]

public actual inline fun Buffer.storeByteAt(index: Int, value: Byte) {
    array[assertIndex(offset + index, 1)] = value
}

/**
 * Executes block with raw [pointer] to [Buffer] memory area.
 *
 * Consider using it only in interop calls.
 */
public inline fun <R> Buffer.usePointer(block: (pointer: CPointer<ByteVar>) -> R): R = array.usePinned {
    block((it.addressOf(0) + offset)!!)
}

/**
 * Wrap [array] into [Buffer] from [startIndex] to [endIndex].
 */
@ExperimentalIoApi
public actual fun bufferOf(array: ByteArray, startIndex: Int, endIndex: Int): Buffer =
    Buffer(array, startIndex, endIndex - startIndex)
