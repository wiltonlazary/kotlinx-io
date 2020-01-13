[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeByteArray](./store-byte-array.md)

# storeByteArray

`fun `[`Buffer`](-buffer/index.md)`.storeByteArray(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, source: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, sourceOffset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = source.size - sourceOffset): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Copies unsigned shorts integers from the [source](store-byte-array.md#kotlinx.io.buffer$storeByteArray(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.ByteArray, kotlin.Int, kotlin.Int)/source) array at [sourceOffset](store-byte-array.md#kotlinx.io.buffer$storeByteArray(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.ByteArray, kotlin.Int, kotlin.Int)/sourceOffset) to this buffer at the specified [offset](store-byte-array.md#kotlinx.io.buffer$storeByteArray(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.ByteArray, kotlin.Int, kotlin.Int)/offset).

### Parameters

`sourceOffset` - items