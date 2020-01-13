[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeFloatAt](./store-float-at.md)

# storeFloatAt

`fun `[`Buffer`](-buffer/index.md)`.storeFloatAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`fun `[`Buffer`](-buffer/index.md)`.storeFloatAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write short signed 32-bit floating point number in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](store-float-at.md#kotlinx.io.buffer$storeFloatAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Float)/offset) is negative or greater than buffer size.

