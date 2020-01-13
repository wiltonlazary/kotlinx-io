[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeIntAt](./store-int-at.md)

# storeIntAt

`fun `[`Buffer`](-buffer/index.md)`.storeIntAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`fun `[`Buffer`](-buffer/index.md)`.storeIntAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write regular signed 32-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](store-int-at.md#kotlinx.io.buffer$storeIntAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int)/offset) is negative or greater than buffer size.

