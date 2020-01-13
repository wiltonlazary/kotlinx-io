[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeUIntAt](./store-u-int-at.md)

# storeUIntAt

`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.storeUIntAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.storeUIntAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write regular unsigned 32-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](store-u-int-at.md#kotlinx.io.buffer$storeUIntAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.UInt)/offset) is negative or greater than buffer size.

