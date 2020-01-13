[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [set](./set.md)

# set

`operator fun `[`Buffer`](-buffer/index.md)`.set(index: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`operator fun `[`Buffer`](-buffer/index.md)`.set(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): <ERROR CLASS>`

Index write operator to write [value](set.md#kotlinx.io.buffer$set(kotlinx.io.buffer.Buffer, kotlin.Long, kotlin.Byte)/value) at the specified [index](set.md#kotlinx.io.buffer$set(kotlinx.io.buffer.Buffer, kotlin.Long, kotlin.Byte)/index).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if index is negative or greater than buffer size.

