[kotlinx-io](../index.md) / [kotlinx.io](./index.md)

## Package kotlinx.io

### Types

| Name | Summary |
|---|---|
| [ByteArrayOutput](-byte-array-output/index.md) | Output which uses byte array as its data storage. Byte array grows automatically as data is written to it and can be accessed with [toByteArray](-byte-array-output/to-byte-array.md). Initial capacity of the underlying array can be specified with [initialCapacity](#) parameter.`class ByteArrayOutput : `[`Output`](-output/index.md) |
| [ByteOrder](-byte-order/index.md) | Enumeration that represent an endianness of the arbitrary binary data. Endianness refers to the order of bytes within a binary representation of a binary data.`enum class ByteOrder` |
| [Closeable](-closeable/index.md) | `interface Closeable` |
| [Console](-console/index.md) | Console incorporates all system inputs and outputs in a multiplatform manner. All sources are open by default, ready to read from/write to and cannot be closed.`object Console` |
| [Input](-input/index.md) | [Input](-input/index.md) is an abstract base class for synchronous byte readers.`abstract class Input : `[`Closeable`](-closeable/index.md) |
| [Output](-output/index.md) | [Output](-output/index.md) is an abstract base for writable streams of bytes over some sink.`abstract class Output : `[`Closeable`](-closeable/index.md) |

### Annotations

| Name | Summary |
|---|---|
| [ExperimentalIoApi](-experimental-io-api/index.md) | API marked with this annotation is experimental and could be changed`annotation class ExperimentalIoApi` |

### Exceptions

| Name | Summary |
|---|---|
| [EOFException](-e-o-f-exception/index.md) | `open class EOFException : `[`IOException`](-i-o-exception/index.md) |
| [IOException](-i-o-exception/index.md) | `open class IOException : `[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html) |

### Functions

| Name | Summary |
|---|---|
| [ByteArrayInput](-byte-array-input.md) | Creates an input from the given byte array, starting from inclusively [startIndex](-byte-array-input.md#kotlinx.io$ByteArrayInput(kotlin.ByteArray, kotlin.Int, kotlin.Int)/startIndex) and until [endIndex](-byte-array-input.md#kotlinx.io$ByteArrayInput(kotlin.ByteArray, kotlin.Int, kotlin.Int)/endIndex) exclusively. The array is not copied and calling [close](-input/close.md) on the resulting input has no effect.`fun ByteArrayInput(source: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = source.size): `[`Input`](-input/index.md) |
| [copyTo](copy-to.md) | Copy input content to [destination](copy-to.md#kotlinx.io$copyTo(kotlinx.io.Input, kotlinx.io.Output)/destination).`fun `[`Input`](-input/index.md)`.copyTo(destination: `[`Output`](-output/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readByteArray](read-byte-array.md) | Read [length](read-byte-array.md#kotlinx.io$readByteArray(kotlinx.io.Input, kotlin.ByteArray, kotlin.Int, kotlin.Int)/length) bytes from [Input](-input/index.md) to [array](read-byte-array.md#kotlinx.io$readByteArray(kotlinx.io.Input, kotlin.ByteArray, kotlin.Int, kotlin.Int)/array) from [startIndex](read-byte-array.md#kotlinx.io$readByteArray(kotlinx.io.Input, kotlin.ByteArray, kotlin.Int, kotlin.Int)/startIndex).`fun `[`Input`](-input/index.md)`.readByteArray(array: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size - startIndex): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`Input`](-input/index.md)`.readByteArray(array: `[`UByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size - startIndex): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [readDouble](read-double.md) | Reads a [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) from the current [Input](-input/index.md).`fun `[`Input`](-input/index.md)`.readDouble(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [readFloat](read-float.md) | Reads a [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) from the current [Input](-input/index.md).`fun `[`Input`](-input/index.md)`.readFloat(): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [readUByte](read-u-byte.md) | Reads an [UByte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html) from this Input.`fun `[`Input`](-input/index.md)`.readUByte(): `[`UByte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html) |
| [readUInt](read-u-int.md) | Reads an [UInt](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html) from this Input.`fun `[`Input`](-input/index.md)`.readUInt(): `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html) |
| [readULong](read-u-long.md) | Reads a [ULong](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html) from this Input.`fun `[`Input`](-input/index.md)`.readULong(): `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html) |
| [readUShort](read-u-short.md) | Reads an [UShort](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html) from this Input.`fun `[`Input`](-input/index.md)`.readUShort(): `[`UShort`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html) |
| [use](use.md) | `fun <C : `[`Closeable`](-closeable/index.md)`, R> C.use(block: (C) -> R): R` |
| [writeByteArray](write-byte-array.md) | Write an [array](write-byte-array.md#kotlinx.io$writeByteArray(kotlinx.io.Output, kotlin.ByteArray, kotlin.Int, kotlin.Int)/array) to this [Input](-input/index.md).`fun `[`Output`](-output/index.md)`.writeByteArray(array: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`Output`](-output/index.md)`.writeByteArray(array: `[`UByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeDouble](write-double.md) | Write a double-precision [value](write-double.md#kotlinx.io$writeDouble(kotlinx.io.Output, kotlin.Double)/value) to this [Output](-output/index.md).`fun `[`Output`](-output/index.md)`.writeDouble(value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeFloat](write-float.md) | Write a floating-point [value](write-float.md#kotlinx.io$writeFloat(kotlinx.io.Output, kotlin.Float)/value) to this [Output](-output/index.md).`fun `[`Output`](-output/index.md)`.writeFloat(value: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUByte](write-u-byte.md) | Write a [value](write-u-byte.md#kotlinx.io$writeUByte(kotlinx.io.Output, kotlin.UByte)/value) to this [Input](-input/index.md).`fun `[`Output`](-output/index.md)`.writeUByte(value: `[`UByte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUInt](write-u-int.md) | Write a [value](write-u-int.md#kotlinx.io$writeUInt(kotlinx.io.Output, kotlin.UInt)/value) to this [Input](-input/index.md).`fun `[`Output`](-output/index.md)`.writeUInt(value: `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeULong](write-u-long.md) | Write a [value](write-u-long.md#kotlinx.io$writeULong(kotlinx.io.Output, kotlin.ULong)/value) to this [Input](-input/index.md).`fun `[`Output`](-output/index.md)`.writeULong(value: `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeUShort](write-u-short.md) | Write a [value](write-u-short.md#kotlinx.io$writeUShort(kotlinx.io.Output, kotlin.UShort)/value) to this [Input](-input/index.md).`fun `[`Output`](-output/index.md)`.writeUShort(value: `[`UShort`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
