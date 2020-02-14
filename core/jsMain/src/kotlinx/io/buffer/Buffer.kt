@file:Suppress("NOTHING_TO_INLINE")

package kotlinx.io.buffer

import kotlinx.io.*
import org.khronos.webgl.*

public actual class Buffer(public val view: DataView)

public actual inline val Buffer.size: Int get() = view.byteLength

public actual fun Buffer.loadByteAt(index: Int): Byte = checked(index) {
    return view.getInt8(index)
}

public actual fun Buffer.storeByteAt(index: Int, value: Byte) = checked(index) {
    view.setInt8(index, value)
}

/**
 * Wrap [array] into [Buffer] from [startIndex] to [endIndex].
 */
@ExperimentalIoApi
public actual fun bufferOf(array: ByteArray, startIndex: Int, endIndex: Int): Buffer {
    val content = array as Int8Array
    val view = DataView(
        content.buffer, content.byteOffset + startIndex, endIndex - startIndex
    )
    return Buffer(view)
}