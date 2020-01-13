[kotlinx-io](../../index.md) / [kotlinx.io.buffer](../index.md) / [Buffer](index.md) / [storeByteAt](./store-byte-at.md)

# storeByteAt

`fun storeByteAt(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Writes byte [value](store-byte-at.md#kotlinx.io.buffer.Buffer$storeByteAt(kotlin.Int, kotlin.Byte)/value) at the specified [index](store-byte-at.md#kotlinx.io.buffer.Buffer$storeByteAt(kotlin.Int, kotlin.Byte)/index).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if index is negative or greater than buffer size.

