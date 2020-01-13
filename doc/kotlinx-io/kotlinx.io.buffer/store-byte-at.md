[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeByteAt](./store-byte-at.md)

# storeByteAt

`fun `[`Buffer`](-buffer/index.md)`.storeByteAt(index: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write [value](store-byte-at.md#kotlinx.io.buffer$storeByteAt(kotlinx.io.buffer.Buffer, kotlin.Long, kotlin.Byte)/value) at the specified [index](store-byte-at.md#kotlinx.io.buffer$storeByteAt(kotlinx.io.buffer.Buffer, kotlin.Long, kotlin.Byte)/index).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [index](store-byte-at.md#kotlinx.io.buffer$storeByteAt(kotlinx.io.buffer.Buffer, kotlin.Long, kotlin.Byte)/index) is negative or greater than buffer size.

