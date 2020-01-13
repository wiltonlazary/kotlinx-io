[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeUShortAt](./store-u-short-at.md)

# storeUShortAt

`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.storeUShortAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`UShort`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.storeUShortAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`UShort`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write short unsigned 16-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](store-u-short-at.md#kotlinx.io.buffer$storeUShortAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.UShort)/offset) is negative or greater than buffer size.

