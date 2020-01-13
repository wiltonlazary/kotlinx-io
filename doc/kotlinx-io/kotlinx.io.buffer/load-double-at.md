[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [loadDoubleAt](./load-double-at.md)

# loadDoubleAt

`fun `[`Buffer`](-buffer/index.md)`.loadDoubleAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)
`fun `[`Buffer`](-buffer/index.md)`.loadDoubleAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Read short signed 64-bit floating point number in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](load-double-at.md#kotlinx.io.buffer$loadDoubleAt(kotlinx.io.buffer.Buffer, kotlin.Int)/offset) is negative or greater than buffer size.

