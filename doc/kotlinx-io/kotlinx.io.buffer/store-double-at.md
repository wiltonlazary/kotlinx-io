[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeDoubleAt](./store-double-at.md)

# storeDoubleAt

`fun `[`Buffer`](-buffer/index.md)`.storeDoubleAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`fun `[`Buffer`](-buffer/index.md)`.storeDoubleAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write short signed 64-bit floating point number in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](store-double-at.md#kotlinx.io.buffer$storeDoubleAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Double)/offset) is negative or greater than buffer size.

