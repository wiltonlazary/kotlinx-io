[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [loadFloatAt](./load-float-at.md)

# loadFloatAt

`fun `[`Buffer`](-buffer/index.md)`.loadFloatAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)
`fun `[`Buffer`](-buffer/index.md)`.loadFloatAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)

Read short signed 32-bit floating point number in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](load-float-at.md#kotlinx.io.buffer$loadFloatAt(kotlinx.io.buffer.Buffer, kotlin.Int)/offset) is negative or greater than buffer size.

