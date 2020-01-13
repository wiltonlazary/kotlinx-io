[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeULongAt](./store-u-long-at.md)

# storeULongAt

`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.storeULongAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.storeULongAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write short signed 64-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](store-u-long-at.md#kotlinx.io.buffer$storeULongAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.ULong)/offset) is negative or greater than buffer size.

