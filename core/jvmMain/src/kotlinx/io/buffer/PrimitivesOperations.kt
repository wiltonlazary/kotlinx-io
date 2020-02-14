@file:Suppress("NOTHING_TO_INLINE")

package kotlinx.io.buffer

import kotlinx.io.internal.*

public actual inline fun Buffer.loadByteAt(index: Long): Byte = loadByteAt(index.toIntOrFail("index"))

public actual inline fun Buffer.loadShortAt(offset: Int): Short {
    return getShort(offset)
}

public actual inline fun Buffer.loadShortAt(offset: Long): Short {
    return getShort(offset.toIntOrFail("offset"))
}

public actual inline fun Buffer.loadIntAt(offset: Int): Int {
    return getInt(offset)
}

public actual inline fun Buffer.loadIntAt(offset: Long): Int {
    return getInt(offset.toIntOrFail("offset"))
}

public actual inline fun Buffer.loadLongAt(offset: Int): Long {
    return getLong(offset)
}

public actual inline fun Buffer.loadLongAt(offset: Long): Long {
    return getLong(offset.toIntOrFail("offset"))
}

public actual inline fun Buffer.loadFloatAt(offset: Int): Float {
    return getFloat(offset)
}

public actual inline fun Buffer.loadFloatAt(offset: Long): Float {
    return getFloat(offset.toIntOrFail("offset"))
}

public actual inline fun Buffer.loadDoubleAt(offset: Int): Double {
    return getDouble(offset)
}

public actual inline fun Buffer.loadDoubleAt(offset: Long): Double {
    return getDouble(offset.toIntOrFail("offset"))
}

public actual inline fun Buffer.storeIntAt(offset: Int, value: Int) {
    putInt(offset, value)
}

public actual inline fun Buffer.storeIntAt(offset: Long, value: Int) {
    storeIntAt(offset.toIntOrFail("offset"), value)
}

public actual inline fun Buffer.storeShortAt(offset: Int, value: Short) {
    putShort(offset, value)
}

public actual inline fun Buffer.storeShortAt(offset: Long, value: Short) {
    storeShortAt(offset.toIntOrFail("offset"), value)
}

public actual inline fun Buffer.storeLongAt(offset: Int, value: Long) {
    putLong(offset, value)
}

public actual inline fun Buffer.storeLongAt(offset: Long, value: Long) {
    storeLongAt(offset.toIntOrFail("offset"), value)
}

public actual inline fun Buffer.storeFloatAt(offset: Int, value: Float) {
    putFloat(offset, value)
}

public actual inline fun Buffer.storeFloatAt(offset: Long, value: Float) {
    storeFloatAt(offset.toIntOrFail("offset"), value)
}

public actual inline fun Buffer.storeDoubleAt(offset: Int, value: Double) {
    putDouble(offset, value)
}

public actual inline fun Buffer.storeDoubleAt(offset: Long, value: Double) {
    storeDoubleAt(offset.toIntOrFail("offset"), value)
}

public actual inline fun Buffer.storeByteAt(index: Long, value: Byte) = storeByteAt(index.toIntOrFail("index"), value)