[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [get](./get.md)

# get

`operator fun `[`Buffer`](-buffer/index.md)`.get(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)
`operator fun `[`Buffer`](-buffer/index.md)`.get(index: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)

Read byte at the specified [index](get.md#kotlinx.io.buffer$get(kotlinx.io.buffer.Buffer, kotlin.Int)/index).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if index is negative or greater than buffer size.

