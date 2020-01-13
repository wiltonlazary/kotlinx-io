[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeUByteAt](./store-u-byte-at.md)

# storeUByteAt

`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.storeUByteAt(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`UByte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html)`): <ERROR CLASS>`
`@ExperimentalUnsignedTypes fun `[`Buffer`](-buffer/index.md)`.storeUByteAt(index: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`UByte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html)`): <ERROR CLASS>`

Write [value](store-u-byte-at.md#kotlinx.io.buffer$storeUByteAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.UByte)/value) at the specified [index](store-u-byte-at.md#kotlinx.io.buffer$storeUByteAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.UByte)/index).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [index](store-u-byte-at.md#kotlinx.io.buffer$storeUByteAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.UByte)/index) is negative or greater than buffer size.

