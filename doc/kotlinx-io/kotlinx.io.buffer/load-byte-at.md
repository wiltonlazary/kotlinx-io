[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [loadByteAt](./load-byte-at.md)

# loadByteAt

`fun `[`Buffer`](-buffer/index.md)`.loadByteAt(index: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)

Returns byte at [index](load-byte-at.md#kotlinx.io.buffer$loadByteAt(kotlinx.io.buffer.Buffer, kotlin.Long)/index) position.
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [index](load-byte-at.md#kotlinx.io.buffer$loadByteAt(kotlinx.io.buffer.Buffer, kotlin.Long)/index) is negative or greater than buffer size.

