[kotlinx-io](../../index.md) / [kotlinx.io.bytes](../index.md) / [BytesOutput](./index.md)

# BytesOutput

`class BytesOutput : `[`Output`](../../kotlinx.io/-output/index.md)

Create unlimited [Output](../../kotlinx.io/-output/index.md) stored in memory.
In advance to [Output](../../kotlinx.io/-output/index.md) you can check [size](#) and create [BytesInput](../-bytes-input/index.md) with [createInput](create-input.md).
[BytesOutput](./index.md) isn't using any pools and shouldn't be closed.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Create unlimited [Output](../../kotlinx.io/-output/index.md) stored in memory. In advance to [Output](../../kotlinx.io/-output/index.md) you can check [size](#) and create [BytesInput](../-bytes-input/index.md) with [createInput](create-input.md). [BytesOutput](./index.md) isn't using any pools and shouldn't be closed.`BytesOutput(bufferSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_BUFFER_SIZE)` |

### Properties

| Name | Summary |
|---|---|
| [size](size.md) | Size of content.`val size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [closeSource](close-source.md) | Closes the underlying source of data used by this output. This method is invoked once the output is [closed](../../kotlinx.io/-output/close.md).`fun closeSource(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [createInput](create-input.md) | Create [BytesInput](../-bytes-input/index.md) from this [Output](../../kotlinx.io/-output/index.md). This can be called multiple times and. It always returns independent [BytesInput](../-bytes-input/index.md) without copying of underline buffers. The buffers will be copied on demand.`fun createInput(): `[`BytesInput`](../-bytes-input/index.md) |
| [flush](flush.md) | Write [source](../../kotlinx.io/-output/flush.md#kotlinx.io.Output$flush(kotlinx.io.buffer.Buffer, kotlin.Int)/source) buffer to destination.`fun flush(source: `[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [use](../../kotlinx.io/use.md) | `fun <C : `[`Closeable`](../../kotlinx.io/-closeable/index.md)`, R> C.use(block: (C) -> R): R` |
| [writeByteArray](../../kotlinx.io/write-byte-array.md) | Write an [array](../../kotlinx.io/write-byte-array.md#kotlinx.io$writeByteArray(kotlinx.io.Output, kotlin.ByteArray, kotlin.Int, kotlin.Int)/array) to this [Input](../../kotlinx.io/-input/index.md).`fun `[`Output`](../../kotlinx.io/-output/index.md)`.writeByteArray(array: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`Output`](../../kotlinx.io/-output/index.md)`.writeByteArray(array: `[`UByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeDouble](../../kotlinx.io/write-double.md) | Write a double-precision [value](../../kotlinx.io/write-double.md#kotlinx.io$writeDouble(kotlinx.io.Output, kotlin.Double)/value) to this [Output](../../kotlinx.io/-output/index.md).`fun `[`Output`](../../kotlinx.io/-output/index.md)`.writeDouble(value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeFloat](../../kotlinx.io/write-float.md) | Write a floating-point [value](../../kotlinx.io/write-float.md#kotlinx.io$writeFloat(kotlinx.io.Output, kotlin.Float)/value) to this [Output](../../kotlinx.io/-output/index.md).`fun `[`Output`](../../kotlinx.io/-output/index.md)`.writeFloat(value: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUByte](../../kotlinx.io/write-u-byte.md) | Write a [value](../../kotlinx.io/write-u-byte.md#kotlinx.io$writeUByte(kotlinx.io.Output, kotlin.UByte)/value) to this [Input](../../kotlinx.io/-input/index.md).`fun `[`Output`](../../kotlinx.io/-output/index.md)`.writeUByte(value: `[`UByte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUInt](../../kotlinx.io/write-u-int.md) | Write a [value](../../kotlinx.io/write-u-int.md#kotlinx.io$writeUInt(kotlinx.io.Output, kotlin.UInt)/value) to this [Input](../../kotlinx.io/-input/index.md).`fun `[`Output`](../../kotlinx.io/-output/index.md)`.writeUInt(value: `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeULong](../../kotlinx.io/write-u-long.md) | Write a [value](../../kotlinx.io/write-u-long.md#kotlinx.io$writeULong(kotlinx.io.Output, kotlin.ULong)/value) to this [Input](../../kotlinx.io/-input/index.md).`fun `[`Output`](../../kotlinx.io/-output/index.md)`.writeULong(value: `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUShort](../../kotlinx.io/write-u-short.md) | Write a [value](../../kotlinx.io/write-u-short.md#kotlinx.io$writeUShort(kotlinx.io.Output, kotlin.UShort)/value) to this [Input](../../kotlinx.io/-input/index.md).`fun `[`Output`](../../kotlinx.io/-output/index.md)`.writeUShort(value: `[`UShort`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUtf8String](../../kotlinx.io.text/write-utf8-string.md) | Write [length](../../kotlinx.io.text/write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/length) bytes in [text](../../kotlinx.io.text/write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/text) starting from offset [index](../../kotlinx.io.text/write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/index) to output.`fun `[`Output`](../../kotlinx.io/-output/index.md)`.writeUtf8String(text: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = text.length - index): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
