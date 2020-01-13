[kotlinx-io](../index.md) / [kotlinx.io](index.md) / [readByteArray](./read-byte-array.md)

# readByteArray

`fun `[`Input`](-input/index.md)`.readByteArray(array: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size - startIndex): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`@ExperimentalUnsignedTypes fun `[`Input`](-input/index.md)`.readByteArray(array: `[`UByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size - startIndex): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Read [length](read-byte-array.md#kotlinx.io$readByteArray(kotlinx.io.Input, kotlin.ByteArray, kotlin.Int, kotlin.Int)/length) bytes from [Input](-input/index.md) to [array](read-byte-array.md#kotlinx.io$readByteArray(kotlinx.io.Input, kotlin.ByteArray, kotlin.Int, kotlin.Int)/array) from [startIndex](read-byte-array.md#kotlinx.io$readByteArray(kotlinx.io.Input, kotlin.ByteArray, kotlin.Int, kotlin.Int)/startIndex).

### Exceptions

`EOFException` - if not enough bytes available.