[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [Output](index.md) / [writeBufferDirect](./write-buffer-direct.md)

# writeBufferDirect

`fun writeBufferDirect(data: `[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`, startOffset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, endOffset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = data.size): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Bypass [data](write-buffer-direct.md#kotlinx.io.Output$writeBufferDirect(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int)/data) from [startOffset](write-buffer-direct.md#kotlinx.io.Output$writeBufferDirect(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int)/startOffset) to [endOffset](write-buffer-direct.md#kotlinx.io.Output$writeBufferDirect(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int)/endOffset) by using [Output.flush](flush.md).
If [Output](index.md) is not empty, all data will flushed beforehand.

