[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [copyTo](./copy-to.md)

# copyTo

`fun `[`Buffer`](-buffer/index.md)`.copyTo(destination: `[`Buffer`](-buffer/index.md)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, destinationOffset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`fun `[`Buffer`](-buffer/index.md)`.copyTo(destination: `[`Buffer`](-buffer/index.md)`, offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, destinationOffset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): <ERROR CLASS>`

Copies bytes from this buffer range from the specified [offset](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int, kotlin.Int)/offset) and [length](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int, kotlin.Int)/length)
to the [destination](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int, kotlin.Int)/destination) at [destinationOffset](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int, kotlin.Int)/destinationOffset).
Copying bytes from a buffer to itself is allowed.

`fun `[`Buffer`](-buffer/index.md)`.copyTo(destination: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, destinationOffset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`fun `[`Buffer`](-buffer/index.md)`.copyTo(destination: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, destinationOffset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Copies bytes from this buffer range from the specified [offset](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, kotlin.ByteArray, kotlin.Int, kotlin.Int, kotlin.Int)/offset) and [length](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, kotlin.ByteArray, kotlin.Int, kotlin.Int, kotlin.Int)/length)
to the [destination](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, kotlin.ByteArray, kotlin.Int, kotlin.Int, kotlin.Int)/destination) at [destinationOffset](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, kotlin.ByteArray, kotlin.Int, kotlin.Int, kotlin.Int)/destinationOffset).

`fun `[`Buffer`](-buffer/index.md)`.copyTo(destination: <ERROR CLASS>, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, destinationOffset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`fun <ERROR CLASS>.copyTo(destination: `[`Buffer`](-buffer/index.md)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, destinationOffset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Copies bytes from this memory range from the specified [offset](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, , kotlin.Int, kotlin.Int, kotlin.Int)/offset) and [length](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, , kotlin.Int, kotlin.Int, kotlin.Int)/length)
to the [destination](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, , kotlin.Int, kotlin.Int, kotlin.Int)/destination) at [destinationOffset](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, , kotlin.Int, kotlin.Int, kotlin.Int)/destinationOffset).

`fun `[`Buffer`](-buffer/index.md)`.copyTo(destination: `[`ByteBuffer`](https://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`fun `[`Buffer`](-buffer/index.md)`.copyTo(destination: `[`ByteBuffer`](https://docs.oracle.com/javase/6/docs/api/java/nio/ByteBuffer.html)`, offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Copies bytes from this buffer range from the specified [offset](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, java.nio.ByteBuffer, kotlin.Int)/offset)
to the [destination](copy-to.md#kotlinx.io.buffer$copyTo(kotlinx.io.buffer.Buffer, java.nio.ByteBuffer, kotlin.Int)/destination) buffer.

