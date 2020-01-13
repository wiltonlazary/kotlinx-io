[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [Input](./index.md)

# Input

`abstract class Input : `[`Closeable`](../-closeable/index.md)

[Input](./index.md) is an abstract base class for synchronous byte readers.

It contains [read*](#) methods to read primitive types ([readByte](read-byte.md), [readInt](read-int.md), ...) and arrays([readByteArray](../read-byte-array.md)).

[Input](./index.md) is buffered. Buffer size depends on [Buffer.size](../../kotlinx.io.buffer/-buffer/size.md) in the [bufferPool](#) buffer.
Buffer size is [DEFAULT_BUFFER_SIZE](#) by default.

To ensure that the required amount bytes is available, you can prefetch it with the [prefetch](prefetch.md) method.

[Input](./index.md) supports a rewind mechanism with the [preview](preview.md) method.

[Input](./index.md) is a resource because it holds the source. The user has to close [Input](./index.md) with the [close](close.md) method at the end.

To implement [Input](./index.md) over a custom source you should override [fill](fill.md) and [closeSource](close-source.md) methods:

```
class Input42 : Input() {
 private var closed: Boolean = false

  override fun fill(buffer: Buffer): Int {
     if (closed) {
         return 0
     }

     buffer.storeByteAt(index = 0, value = 42)
     return 1
  }

  override fun closeSource() {
     closed = true
  }
}
```

Please note that [Input](./index.md) doesn't provide any synchronization over source and doesn't support concurrent access.

TODO: document [prefetch](prefetch.md) and (abstract, protected) API.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Constructs a new Input with the given `bufferPool`.`Input(pool: `[`ObjectPool`](../../kotlinx.io.pool/-object-pool/index.md)`<`[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`>)`<br>Constructs a new Input with the default pool of buffers with the given [bufferSize](-init-.md#kotlinx.io.Input$<init>(kotlin.Int)/bufferSize).`Input(bufferSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_BUFFER_SIZE)` |

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | Closes input including the underlying source. All pending bytes will be discarded.`fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [closeSource](close-source.md) | Closes the underlying source of data used by this input. This method is invoked once the input is [closed](close.md).`abstract fun closeSource(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [copyAvailableTo](copy-available-to.md) | Copy buffered bytes to [destination](copy-available-to.md#kotlinx.io.Input$copyAvailableTo(kotlinx.io.Output)/destination). If no bytes buffered it will block until [fill](fill.md) is finished.`fun copyAvailableTo(destination: `[`Output`](../-output/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Copy buffered bytes to [destination](copy-available-to.md#kotlinx.io.Input$copyAvailableTo(kotlinx.io.buffer.Buffer)/destination). If no bytes buffered it will call [fill](fill.md) on [destination](copy-available-to.md#kotlinx.io.Input$copyAvailableTo(kotlinx.io.buffer.Buffer)/destination) directly.`fun copyAvailableTo(destination: `[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [eof](eof.md) | Check if at least 1 byte available to read.`fun eof(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [fill](fill.md) | Reads the next bytes into the [buffer](fill.md#kotlinx.io.Input$fill(kotlinx.io.buffer.Buffer, kotlin.Int)/buffer) May block until at least one byte is available.`abstract fun fill(buffer: `[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`, atMost: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = buffer.size): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Read next bytes into the [destinations](fill.md#kotlinx.io.Input$fill(kotlin.Array((kotlinx.io.buffer.Buffer)))/destinations). May block until at least one byte is available.`open fun fill(destinations: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`>): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [prefetch](prefetch.md) | Check that [size](prefetch.md#kotlinx.io.Input$prefetch(kotlin.Int)/size) bytes are fetched in [Input](./index.md).`fun prefetch(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [preview](preview.md) | Allows reading from [Input](./index.md) in the [reader](preview.md#kotlinx.io.Input$preview(kotlin.Function1((kotlinx.io.Input, kotlinx.io.Input.preview.R)))/reader) block without consuming its content.`fun <R> preview(reader: `[`Input`](./index.md)`.() -> R): R` |
| [readByte](read-byte.md) | Reads a [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) from this Input.`fun readByte(): `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [readInt](read-int.md) | Reads an [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) from this Input.`fun readInt(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readLong](read-long.md) | Reads a [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) from this Input.`fun readLong(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [readShort](read-short.md) | Reads a [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) from this Input.`fun readShort(): `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [copyTo](../copy-to.md) | Copy input content to [destination](../copy-to.md#kotlinx.io$copyTo(kotlinx.io.Input, kotlinx.io.Output)/destination).`fun `[`Input`](./index.md)`.copyTo(destination: `[`Output`](../-output/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [forEachUtf8Line](../../kotlinx.io.text/for-each-utf8-line.md) | Iterates through each line of the input, calls [action](../../kotlinx.io.text/for-each-utf8-line.md#kotlinx.io.text$forEachUtf8Line(kotlinx.io.Input, kotlin.Function1((kotlin.String, kotlin.Unit)))/action) for each line read and closes the input when it is exhausted.`fun `[`Input`](./index.md)`.forEachUtf8Line(action: (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [readByteArray](../read-byte-array.md) | Read [length](../read-byte-array.md#kotlinx.io$readByteArray(kotlinx.io.Input, kotlin.ByteArray, kotlin.Int, kotlin.Int)/length) bytes from [Input](./index.md) to [array](../read-byte-array.md#kotlinx.io$readByteArray(kotlinx.io.Input, kotlin.ByteArray, kotlin.Int, kotlin.Int)/array) from [startIndex](../read-byte-array.md#kotlinx.io$readByteArray(kotlinx.io.Input, kotlin.ByteArray, kotlin.Int, kotlin.Int)/startIndex).`fun `[`Input`](./index.md)`.readByteArray(array: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size - startIndex): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`Input`](./index.md)`.readByteArray(array: `[`UByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size - startIndex): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [readDouble](../read-double.md) | Reads a [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) from the current [Input](./index.md).`fun `[`Input`](./index.md)`.readDouble(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [readFloat](../read-float.md) | Reads a [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) from the current [Input](./index.md).`fun `[`Input`](./index.md)`.readFloat(): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [readUByte](../read-u-byte.md) | Reads an [UByte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html) from this Input.`fun `[`Input`](./index.md)`.readUByte(): `[`UByte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html) |
| [readUInt](../read-u-int.md) | Reads an [UInt](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html) from this Input.`fun `[`Input`](./index.md)`.readUInt(): `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html) |
| [readULong](../read-u-long.md) | Reads a [ULong](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html) from this Input.`fun `[`Input`](./index.md)`.readULong(): `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html) |
| [readUShort](../read-u-short.md) | Reads an [UShort](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html) from this Input.`fun `[`Input`](./index.md)`.readUShort(): `[`UShort`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html) |
| [readUtf8Line](../../kotlinx.io.text/read-utf8-line.md) | Reads the line in UTF-8 encoding from the input until the next line break or until the input is exhausted. A line break is either `"\n"` or `"\r\n"` and is not included in the result.`fun `[`Input`](./index.md)`.readUtf8Line(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [readUtf8Lines](../../kotlinx.io.text/read-utf8-lines.md) | Reads the whole input as a list of UTF-8 encoded lines separated by a line break and closes the input when it is exhausted. A line break is either `"\n"` or `"\r\n"` and is not included in resulting strings.`fun `[`Input`](./index.md)`.readUtf8Lines(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [readUtf8LineTo](../../kotlinx.io.text/read-utf8-line-to.md) | `fun `[`Input`](./index.md)`.readUtf8LineTo(out: `[`Appendable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-appendable/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [readUtf8String](../../kotlinx.io.text/read-utf8-string.md) | `fun `[`Input`](./index.md)`.readUtf8String(length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [readUtf8StringTo](../../kotlinx.io.text/read-utf8-string-to.md) | `fun `[`Input`](./index.md)`.readUtf8StringTo(out: `[`Appendable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-appendable/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readUtf8StringUntilDelimiter](../../kotlinx.io.text/read-utf8-string-until-delimiter.md) | `fun `[`Input`](./index.md)`.readUtf8StringUntilDelimiter(delimiter: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [readUtf8StringUntilDelimiters](../../kotlinx.io.text/read-utf8-string-until-delimiters.md) | `fun `[`Input`](./index.md)`.readUtf8StringUntilDelimiters(delimiters: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [readUtf8StringUntilDelimitersTo](../../kotlinx.io.text/read-utf8-string-until-delimiters-to.md) | `fun `[`Input`](./index.md)`.readUtf8StringUntilDelimitersTo(stringBuilder: `[`Appendable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-appendable/index.html)`, delimiters: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readUtf8StringUntilDelimiterTo](../../kotlinx.io.text/read-utf8-string-until-delimiter-to.md) | `fun `[`Input`](./index.md)`.readUtf8StringUntilDelimiterTo(stringBuilder: `[`Appendable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-appendable/index.html)`, delimiter: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [use](../use.md) | `fun <C : `[`Closeable`](../-closeable/index.md)`, R> C.use(block: (C) -> R): R` |

### Inheritors

| Name | Summary |
|---|---|
| [BytesInput](../../kotlinx.io.bytes/-bytes-input/index.md) | In memory byte source created from [BytesOutput](../../kotlinx.io.bytes/-bytes-output/index.md) or by using [buildInput](../../kotlinx.io.bytes/build-input.md).`class BytesInput : `[`Input`](./index.md) |
