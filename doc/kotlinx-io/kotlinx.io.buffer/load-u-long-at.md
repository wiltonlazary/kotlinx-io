[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [loadULongAt](./load-u-long-at.md)

# loadULongAt

`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.loadULongAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)
`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.loadULongAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)

Read short signed 64-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](load-u-long-at.md#kotlinx.io.buffer$loadULongAt(kotlinx.io.buffer.Buffer, kotlin.Int)/offset) is negative or greater than buffer size.

