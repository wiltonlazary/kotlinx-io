package kotlinx.io

import kotlinx.io.buffer.*
import kotlin.math.*

/**
 * Write a [value] to this [Input].
 */
@ExperimentalUnsignedTypes
public fun Output.writeUByte(value: UByte): Unit = writeByte(value.toByte())

/**
 * Write a [value] to this [Input].
 */
@ExperimentalUnsignedTypes
public fun Output.writeUShort(value: UShort) : Unit = writeShort(value.toShort())

/**
 * Write a [value] to this [Input].
 */
@ExperimentalUnsignedTypes
public fun Output.writeUInt(value: UInt): Unit = writeInt(value.toInt())

/**
 * Write a [value] to this [Input].
 */
@ExperimentalUnsignedTypes
public fun Output.writeULong(value: ULong): Unit = writeLong(value.toLong())

/**
 * Write an [array] to this [Input].
 */
public fun Output.writeByteArray(array: ByteArray, startIndex: Int = 0, endIndex: Int = array.size) {
    var offset = startIndex
    while (offset < endIndex) {
        writeBufferRange { buffer, start ->
            val count = min(buffer.size - start, endIndex - offset)
            buffer.storeByteArray(start, array, offset, count)
            offset += count
            start + count
        }
    }
}
/**
 * Write an [array] to this [Input].
 *
 * TODO: measure
 */
@ExperimentalUnsignedTypes
public fun Output.writeByteArray(array: UByteArray) {
    for (byte in array) {
        writeUByte(byte)
    }
}

/**
 * Write a floating-point [value] to this [Output].
 */
public fun Output.writeFloat(value: Float) {
    writeInt(value.toBits())
}

/**
 * Write a double-precision [value] to this [Output].
 */
public fun Output.writeDouble(value: Double) {
    writeLong(value.toBits())
}
