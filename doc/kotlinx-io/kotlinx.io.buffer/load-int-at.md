[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [loadIntAt](./load-int-at.md)

# loadIntAt

`fun `[`Buffer`](-buffer/index.md)`.loadIntAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)
`fun `[`Buffer`](-buffer/index.md)`.loadIntAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Read regular signed 32-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](load-int-at.md#kotlinx.io.buffer$loadIntAt(kotlinx.io.buffer.Buffer, kotlin.Int)/offset) is negative or greater than buffer size.

