[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [loadShortAt](./load-short-at.md)

# loadShortAt

`fun `[`Buffer`](-buffer/index.md)`.loadShortAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)
`fun `[`Buffer`](-buffer/index.md)`.loadShortAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)

Read short signed 16-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](load-short-at.md#kotlinx.io.buffer$loadShortAt(kotlinx.io.buffer.Buffer, kotlin.Int)/offset) is negative or greater than buffer size.

