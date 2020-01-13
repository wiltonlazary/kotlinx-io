[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [Output](./index.md)

# Output

`abstract class Output : `[`Closeable`](../-closeable/index.md)

[Output](./index.md) is an abstract base for writable streams of bytes over some sink.

[Output](./index.md) is buffered. Buffer size depends on [Buffer.size](../../kotlinx.io.buffer/-buffer/size.md) in the [bufferPool](#) buffer.
Buffer size is [DEFAULT_BUFFER_SIZE](#) by default. Buffer can be flushed using [flush](flush.md) method.

To implement [Output](./index.md) over a custom sink you should override only [fill](../../kotlinx.io.buffer/fill.md) method.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Output(bufferSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_BUFFER_SIZE)`<br>[Output](./index.md) is an abstract base for writable streams of bytes over some sink.`Output(bufferPool: `[`ObjectPool`](../../kotlinx.io.pool/-object-pool/index.md)`<`[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`>)` |

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | Closes the current output, flushing all buffered data to the underlying source and [closing](close-source.md) it`fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [closeSource](close-source.md) | Closes the underlying source of data used by this output. This method is invoked once the output is [closed](close.md).`abstract fun closeSource(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [flush](flush.md) | Write all buffered bytes to underlying sink.`fun flush(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Write [source](flush.md#kotlinx.io.Output$flush(kotlinx.io.buffer.Buffer, kotlin.Int)/source) buffer to destination.`abstract fun flush(source: `[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeBufferDirect](write-buffer-direct.md) | Bypass [data](write-buffer-direct.md#kotlinx.io.Output$writeBufferDirect(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int)/data) from [startOffset](write-buffer-direct.md#kotlinx.io.Output$writeBufferDirect(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int)/startOffset) to [endOffset](write-buffer-direct.md#kotlinx.io.Output$writeBufferDirect(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Int)/endOffset) by using [Output.flush](flush.md). If [Output](./index.md) is not empty, all data will flushed beforehand.`fun writeBufferDirect(data: `[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`, startOffset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, endOffset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = data.size): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeByte](write-byte.md) | Write a [value](write-byte.md#kotlinx.io.Output$writeByte(kotlin.Byte)/value) to this [Input](../-input/index.md).`fun writeByte(value: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeInt](write-int.md) | Write a [value](write-int.md#kotlinx.io.Output$writeInt(kotlin.Int)/value) to this [Input](../-input/index.md).`fun writeInt(value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeLong](write-long.md) | Write a [value](write-long.md#kotlinx.io.Output$writeLong(kotlin.Long)/value) to this [Input](../-input/index.md).`fun writeLong(value: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeShort](write-short.md) | Write a [value](write-short.md#kotlinx.io.Output$writeShort(kotlin.Short)/value) to this [Input](../-input/index.md).`fun writeShort(value: `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [use](../use.md) | `fun <C : `[`Closeable`](../-closeable/index.md)`, R> C.use(block: (C) -> R): R` |
| [writeByteArray](../write-byte-array.md) | Write an [array](../write-byte-array.md#kotlinx.io$writeByteArray(kotlinx.io.Output, kotlin.ByteArray, kotlin.Int, kotlin.Int)/array) to this [Input](../-input/index.md).`fun `[`Output`](./index.md)`.writeByteArray(array: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`Output`](./index.md)`.writeByteArray(array: `[`UByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeDouble](../write-double.md) | Write a double-precision [value](../write-double.md#kotlinx.io$writeDouble(kotlinx.io.Output, kotlin.Double)/value) to this [Output](./index.md).`fun `[`Output`](./index.md)`.writeDouble(value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeFloat](../write-float.md) | Write a floating-point [value](../write-float.md#kotlinx.io$writeFloat(kotlinx.io.Output, kotlin.Float)/value) to this [Output](./index.md).`fun `[`Output`](./index.md)`.writeFloat(value: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUByte](../write-u-byte.md) | Write a [value](../write-u-byte.md#kotlinx.io$writeUByte(kotlinx.io.Output, kotlin.UByte)/value) to this [Input](../-input/index.md).`fun `[`Output`](./index.md)`.writeUByte(value: `[`UByte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUInt](../write-u-int.md) | Write a [value](../write-u-int.md#kotlinx.io$writeUInt(kotlinx.io.Output, kotlin.UInt)/value) to this [Input](../-input/index.md).`fun `[`Output`](./index.md)`.writeUInt(value: `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeULong](../write-u-long.md) | Write a [value](../write-u-long.md#kotlinx.io$writeULong(kotlinx.io.Output, kotlin.ULong)/value) to this [Input](../-input/index.md).`fun `[`Output`](./index.md)`.writeULong(value: `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUShort](../write-u-short.md) | Write a [value](../write-u-short.md#kotlinx.io$writeUShort(kotlinx.io.Output, kotlin.UShort)/value) to this [Input](../-input/index.md).`fun `[`Output`](./index.md)`.writeUShort(value: `[`UShort`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUtf8String](../../kotlinx.io.text/write-utf8-string.md) | Write [length](../../kotlinx.io.text/write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/length) bytes in [text](../../kotlinx.io.text/write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/text) starting from offset [index](../../kotlinx.io.text/write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/index) to output.`fun `[`Output`](./index.md)`.writeUtf8String(text: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = text.length - index): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ByteArrayOutput](../-byte-array-output/index.md) | Output which uses byte array as its data storage. Byte array grows automatically as data is written to it and can be accessed with [toByteArray](../-byte-array-output/to-byte-array.md). Initial capacity of the underlying array can be specified with [initialCapacity](#) parameter.`class ByteArrayOutput : `[`Output`](./index.md) |
| [BytesOutput](../../kotlinx.io.bytes/-bytes-output/index.md) | Create unlimited [Output](./index.md) stored in memory. In advance to [Output](./index.md) you can check [size](#) and create [BytesInput](../../kotlinx.io.bytes/-bytes-input/index.md) with [createInput](../../kotlinx.io.bytes/-bytes-output/create-input.md). [BytesOutput](../../kotlinx.io.bytes/-bytes-output/index.md) isn't using any pools and shouldn't be closed.`class BytesOutput : `[`Output`](./index.md) |
