[kotlinx-io](../../index.md) / [kotlinx.io.bytes](../index.md) / [BytesOutput](index.md) / [flush](./flush.md)

# flush

`protected fun flush(source: `[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write [source](../../kotlinx.io/-output/flush.md#kotlinx.io.Output$flush(kotlinx.io.buffer.Buffer, kotlin.Int)/source) buffer to destination.

May block until destination has no available space.

