[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [ByteArrayOutput](./index.md)

# ByteArrayOutput

`class ByteArrayOutput : `[`Output`](../-output/index.md)

Output which uses byte array as its data storage.
Byte array grows automatically as data is written to it and
can be accessed with [toByteArray](to-byte-array.md).
Initial capacity of the underlying array can be specified with [initialCapacity](#) parameter.

Calling [close](../-output/close.md) on this class has no effect.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Output which uses byte array as its data storage. Byte array grows automatically as data is written to it and can be accessed with [toByteArray](to-byte-array.md). Initial capacity of the underlying array can be specified with [initialCapacity](#) parameter.`ByteArrayOutput(initialCapacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 16)` |

### Functions

| Name | Summary |
|---|---|
| [toByteArray](to-byte-array.md) | Returns a copy of all bytes that were written to the current output.`fun toByteArray(): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [use](../use.md) | `fun <C : `[`Closeable`](../-closeable/index.md)`, R> C.use(block: (C) -> R): R` |
| [writeByteArray](../write-byte-array.md) | Write an [array](../write-byte-array.md#kotlinx.io$writeByteArray(kotlinx.io.Output, kotlin.ByteArray, kotlin.Int, kotlin.Int)/array) to this [Input](../-input/index.md).`fun `[`Output`](../-output/index.md)`.writeByteArray(array: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`Output`](../-output/index.md)`.writeByteArray(array: `[`UByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeDouble](../write-double.md) | Write a double-precision [value](../write-double.md#kotlinx.io$writeDouble(kotlinx.io.Output, kotlin.Double)/value) to this [Output](../-output/index.md).`fun `[`Output`](../-output/index.md)`.writeDouble(value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeFloat](../write-float.md) | Write a floating-point [value](../write-float.md#kotlinx.io$writeFloat(kotlinx.io.Output, kotlin.Float)/value) to this [Output](../-output/index.md).`fun `[`Output`](../-output/index.md)`.writeFloat(value: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUByte](../write-u-byte.md) | Write a [value](../write-u-byte.md#kotlinx.io$writeUByte(kotlinx.io.Output, kotlin.UByte)/value) to this [Input](../-input/index.md).`fun `[`Output`](../-output/index.md)`.writeUByte(value: `[`UByte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUInt](../write-u-int.md) | Write a [value](../write-u-int.md#kotlinx.io$writeUInt(kotlinx.io.Output, kotlin.UInt)/value) to this [Input](../-input/index.md).`fun `[`Output`](../-output/index.md)`.writeUInt(value: `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeULong](../write-u-long.md) | Write a [value](../write-u-long.md#kotlinx.io$writeULong(kotlinx.io.Output, kotlin.ULong)/value) to this [Input](../-input/index.md).`fun `[`Output`](../-output/index.md)`.writeULong(value: `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUShort](../write-u-short.md) | Write a [value](../write-u-short.md#kotlinx.io$writeUShort(kotlinx.io.Output, kotlin.UShort)/value) to this [Input](../-input/index.md).`fun `[`Output`](../-output/index.md)`.writeUShort(value: `[`UShort`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUtf8String](../../kotlinx.io.text/write-utf8-string.md) | Write [length](../../kotlinx.io.text/write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/length) bytes in [text](../../kotlinx.io.text/write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/text) starting from offset [index](../../kotlinx.io.text/write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/index) to output.`fun `[`Output`](../-output/index.md)`.writeUtf8String(text: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = text.length - index): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
