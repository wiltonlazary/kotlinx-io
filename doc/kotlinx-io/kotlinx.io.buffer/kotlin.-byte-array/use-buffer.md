[kotlinx-io](../../index.md) / [kotlinx.io.buffer](../index.md) / [kotlin.ByteArray](index.md) / [useBuffer](./use-buffer.md)

# useBuffer

`fun <R> `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`.useBuffer(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = size - offset, block: (`[`Buffer`](../-buffer/index.md)`) -> R): R`

Execute [block](use-buffer.md#kotlinx.io.buffer$useBuffer(kotlin.ByteArray, kotlin.Int, kotlin.Int, kotlin.Function1((kotlinx.io.buffer.Buffer, kotlinx.io.buffer.useBuffer.R)))/block) of code providing a temporary instance of [Buffer](../-buffer/index.md) view of this byte array range
starting at the specified [offset](use-buffer.md#kotlinx.io.buffer$useBuffer(kotlin.ByteArray, kotlin.Int, kotlin.Int, kotlin.Function1((kotlinx.io.buffer.Buffer, kotlinx.io.buffer.useBuffer.R)))/offset) and having the specified bytes [length](use-buffer.md#kotlinx.io.buffer$useBuffer(kotlin.ByteArray, kotlin.Int, kotlin.Int, kotlin.Function1((kotlinx.io.buffer.Buffer, kotlinx.io.buffer.useBuffer.R)))/length).
By default, if neither [offset](use-buffer.md#kotlinx.io.buffer$useBuffer(kotlin.ByteArray, kotlin.Int, kotlin.Int, kotlin.Function1((kotlinx.io.buffer.Buffer, kotlinx.io.buffer.useBuffer.R)))/offset) nor [length](use-buffer.md#kotlinx.io.buffer$useBuffer(kotlin.ByteArray, kotlin.Int, kotlin.Int, kotlin.Function1((kotlinx.io.buffer.Buffer, kotlinx.io.buffer.useBuffer.R)))/length) specified, the whole array is used.
An instance of [Buffer](../-buffer/index.md) provided into the [block](use-buffer.md#kotlinx.io.buffer$useBuffer(kotlin.ByteArray, kotlin.Int, kotlin.Int, kotlin.Function1((kotlinx.io.buffer.Buffer, kotlinx.io.buffer.useBuffer.R)))/block) should be never captured and used outside of lambda.

