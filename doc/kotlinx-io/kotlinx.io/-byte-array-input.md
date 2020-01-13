[kotlinx-io](../index.md) / [kotlinx.io](index.md) / [ByteArrayInput](./-byte-array-input.md)

# ByteArrayInput

`fun ByteArrayInput(source: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = source.size): `[`Input`](-input/index.md)

Creates an input from the given byte array, starting from inclusively [startIndex](-byte-array-input.md#kotlinx.io$ByteArrayInput(kotlin.ByteArray, kotlin.Int, kotlin.Int)/startIndex) and until [endIndex](-byte-array-input.md#kotlinx.io$ByteArrayInput(kotlin.ByteArray, kotlin.Int, kotlin.Int)/endIndex) exclusively.
The array is not copied and calling [close](-input/close.md) on the resulting input has no effect.

