[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeShortAt](./store-short-at.md)

# storeShortAt

`fun `[`Buffer`](-buffer/index.md)`.storeShortAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`fun `[`Buffer`](-buffer/index.md)`.storeShortAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write short signed 16-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](store-short-at.md#kotlinx.io.buffer$storeShortAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Short)/offset) is negative or greater than buffer size.

