[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [loadUShortAt](./load-u-short-at.md)

# loadUShortAt

`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.loadUShortAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`UShort`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)
`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.loadUShortAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`UShort`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)

Read short unsigned 16-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](load-u-short-at.md#kotlinx.io.buffer$loadUShortAt(kotlinx.io.buffer.Buffer, kotlin.Int)/offset) is negative or greater than buffer size.

