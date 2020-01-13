[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [of](./of.md)

# of

`fun Buffer.Companion.of(view: <ERROR CLASS>): `[`Buffer`](-buffer/index.md)

Create [Memory](#) view for the specified [view](of.md#kotlinx.io.buffer$of(kotlinx.io.buffer.Buffer.Companion, )/view).

`fun Buffer.Companion.of(buffer: <ERROR CLASS>, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = buffer.byteLength - offset): `[`Buffer`](-buffer/index.md)

Create [Memory](#) view for the specified [buffer](of.md#kotlinx.io.buffer$of(kotlinx.io.buffer.Buffer.Companion, , kotlin.Int, kotlin.Int)/buffer) range starting at [offset](of.md#kotlinx.io.buffer$of(kotlinx.io.buffer.Buffer.Companion, , kotlin.Int, kotlin.Int)/offset) and the specified bytes [length](of.md#kotlinx.io.buffer$of(kotlinx.io.buffer.Buffer.Companion, , kotlin.Int, kotlin.Int)/length).

`fun Buffer.Companion.of(array: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = array.size - offset): `[`Buffer`](-buffer/index.md)

Create [Memory](#) view for the specified [array](of.md#kotlinx.io.buffer$of(kotlinx.io.buffer.Buffer.Companion, kotlin.ByteArray, kotlin.Int, kotlin.Int)/array) range starting at [offset](of.md#kotlinx.io.buffer$of(kotlinx.io.buffer.Buffer.Companion, kotlin.ByteArray, kotlin.Int, kotlin.Int)/offset) and the specified bytes [length](of.md#kotlinx.io.buffer$of(kotlinx.io.buffer.Buffer.Companion, kotlin.ByteArray, kotlin.Int, kotlin.Int)/length).

