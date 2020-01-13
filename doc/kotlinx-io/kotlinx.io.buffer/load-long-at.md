[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [loadLongAt](./load-long-at.md)

# loadLongAt

`fun `[`Buffer`](-buffer/index.md)`.loadLongAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

Read signed 64-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](load-long-at.md#kotlinx.io.buffer$loadLongAt(kotlinx.io.buffer.Buffer, kotlin.Int)/offset) is negative or greater than buffer size.

`fun `[`Buffer`](-buffer/index.md)`.loadLongAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, byteOrder: `[`ByteOrder`](../kotlinx.io/-byte-order/index.md)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

Read signed 64-bit integer in the given [byte order](load-long-at.md#kotlinx.io.buffer$loadLongAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlinx.io.ByteOrder)/byteOrder).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](load-long-at.md#kotlinx.io.buffer$loadLongAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlinx.io.ByteOrder)/offset) is negative or greater than buffer size.

`fun `[`Buffer`](-buffer/index.md)`.loadLongAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

Read short signed 64-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](load-long-at.md#kotlinx.io.buffer$loadLongAt(kotlinx.io.buffer.Buffer, kotlin.Long)/offset) is negative or greater than buffer size.

