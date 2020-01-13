[kotlinx-io](../index.md) / [kotlinx.io.buffer](index.md) / [storeLongAt](./store-long-at.md)

# storeLongAt

`fun `[`Buffer`](-buffer/index.md)`.storeLongAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write short signed 64-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](store-long-at.md#kotlinx.io.buffer$storeLongAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Long)/offset) is negative or greater than buffer size.

`fun `[`Buffer`](-buffer/index.md)`.storeLongAt(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, byteOrder: `[`ByteOrder`](../kotlinx.io/-byte-order/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write signed 64-bit integer in the given [byte order](store-long-at.md#kotlinx.io.buffer$storeLongAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Long, kotlinx.io.ByteOrder)/byteOrder)..
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](store-long-at.md#kotlinx.io.buffer$storeLongAt(kotlinx.io.buffer.Buffer, kotlin.Int, kotlin.Long, kotlinx.io.ByteOrder)/offset) is negative or greater than buffer size.

`fun `[`Buffer`](-buffer/index.md)`.storeLongAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, value: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

write short signed 64-bit integer in the network byte order (Big Endian).
May throw [IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) if given [offset](store-long-at.md#kotlinx.io.buffer$storeLongAt(kotlinx.io.buffer.Buffer, kotlin.Long, kotlin.Long)/offset) is negative or greater than buffer size.

