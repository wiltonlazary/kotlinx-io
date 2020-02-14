@file:Suppress("NOTHING_TO_INLINE")

package kotlinx.io.buffer

import kotlinx.io.internal.*
import java.nio.*
import kotlin.contracts.*

/**
 * Copies bytes from this buffer range from the specified [offset] and [length]
 * to the [destination] at [destinationOffset].
 * Copying bytes from a buffer to itself is allowed.
 */
actual fun Buffer.copyTo(destination: Buffer, offset: Int, length: Int, destinationOffset: Int) {
    if (hasArray() && destination.hasArray() &&
        !isReadOnly && !destination.isReadOnly
    // TODO: why this check? buffer.isReadOnly
    ) {
        System.arraycopy(
            array(),
            arrayOffset() + offset,
            destination.array(),
            destination.arrayOffset() + destinationOffset,
            length
        )
        return
    }

    // NOTE: it is ok here to make copy since it will be escaped by JVM
    // while temporary moving position/offset makes buffer concurrent unsafe that is unacceptable

    val srcCopy = duplicate().apply {
        position(offset)
        limit(offset + length)
    }
    val dstCopy = destination.duplicate().apply {
        position(destinationOffset)
    }

    dstCopy.put(srcCopy)
}

/**
 * Copies bytes from this buffer range from the specified [offset] and [length]
 * to the [destination] at [destinationOffset].
 */
actual fun Buffer.copyTo(
    destination: ByteArray,
    offset: Int,
    length: Int,
    destinationOffset: Int
) {
    if (hasArray()) {
        val array = array()
        val arrayOffset = arrayOffset()
        System.arraycopy(
            array, arrayOffset + offset,
            destination, destinationOffset, length
        )
        return
    }

    // we need to make a copy to prevent moving position
    duplicate().get(destination, destinationOffset, length)
}

/**
 * Copies bytes from this buffer range from the specified [offset]
 * to the [destination] buffer.
 */
//fun Buffer.copyTo(
//    destination: ByteBuffer,
//    offset: Int
//) {
//    val size = destination.remaining()
//
//    if (hasArray() && !isReadOnly &&
//        destination.hasArray() && !destination.isReadOnly
//    ) {
//        val dstPosition = destination.position()
//
//        System.arraycopy(
//            array(), arrayOffset() + offset,
//            destination.array(), destination.arrayOffset() + dstPosition,
//            size
//        )
//        destination.position(dstPosition + size)
//        return
//    }
//
//    // we need to make a copy to prevent moving position
//    val source = buffer.duplicate().apply {
//        limit(offset + size)
//        position(offset)
//    }
//    destination.put(source)
//}

/**
 * Copies bytes from this buffer range from the specified [offset]
 * to the [destination] buffer.
 */
fun Buffer.copyTo(destination: ByteBuffer, offset: Long) {
    copyTo(destination, offset.toIntOrFail { "offset" })
}

/**
 * Copy byte from this buffer moving it's position to the [destination] at [offset].
 */
fun ByteBuffer.copyTo(destination: Buffer, offset: Int) {
    if (hasArray() && !isReadOnly) {
        destination.storeByteArray(offset, array(), arrayOffset() + position(), remaining())
        position(limit())
        return
    }

    destination.sliceSafe(offset, remaining()).put(this)
}

private inline fun ByteBuffer.myDuplicate(): ByteBuffer {
    duplicate().apply { return suppressNullCheck() }
}

private inline fun ByteBuffer.mySlice(): ByteBuffer {
    slice().apply { return suppressNullCheck() }
}

private inline fun ByteBuffer.suppressNullCheck(): ByteBuffer {
    return this
}

internal fun ByteBuffer.sliceSafe(offset: Int, length: Int): ByteBuffer {
    return myDuplicate().apply { position(offset); limit((offset + length)) }.mySlice()
}

/**
 * Fill buffer range starting at the specified [offset] with [value] repeated [count] times.
 */
actual fun Buffer.fill(offset: Int, count: Int, value: Byte) {
    for (index in offset until offset + count) {
        put(index, value)
    }
}

/**
 * Execute [block] of code providing a temporary instance of [Buffer] view of this byte array range
 * starting at the specified [offset] and having the specified bytes [length].
 * By default, if neither [offset] nor [length] specified, the whole array is used.
 * An instance of [Buffer] provided into the [block] should be never captured and used outside of lambda.
 */
actual inline fun <R> ByteArray.useBuffer(offset: Int, length: Int, block: (Buffer) -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    // TODO: too much wrappers for bytearray copy 
    return ByteBuffer.wrap(this, offset, length)
        .slice()
        .order(ByteOrder.BIG_ENDIAN)
        .let(block)
}

/**
 * Compact [Buffer].
 * Move content from [startIndex] to [endIndex] exclusive to beginning of the buffer.
 *
 * @return [endIndex] - [startIndex] (copied bytes count).
 */
internal actual fun Buffer.compact(startIndex: Int, endIndex: Int): Int {
    if (startIndex == 0) {
        return endIndex
    }

    position(startIndex)
    limit(endIndex)
    compact()

    return limit()
}
