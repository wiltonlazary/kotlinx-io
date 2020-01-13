[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [loadUIntAt](./load-u-int-at.md)

# loadUIntAt

`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.loadUIntAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)
`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.loadUIntAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)

Read regular unsigned 32-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](load-u-int-at.md#kotlinx.io.buffer$loadUIntAt(kotlinx.io.buffer.Buffer, kotlin.Int)/offset) is negative or greater than buffer size.

