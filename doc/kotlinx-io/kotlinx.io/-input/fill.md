[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [Input](index.md) / [fill](./fill.md)

# fill

`protected abstract fun fill(buffer: `[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`, atMost: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = buffer.size): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Reads the next bytes into the [buffer](fill.md#kotlinx.io.Input$fill(kotlinx.io.buffer.Buffer, kotlin.Int)/buffer)
May block until at least one byte is available.

The source will not read more than [atMost](fill.md#kotlinx.io.Input$fill(kotlinx.io.buffer.Buffer, kotlin.Int)/atMost) bytes.

TODO: ?? Usually bypass all exceptions from the underlying source.

**Return**
number of bytes were copied or `0` if no more input is available.

`protected open fun fill(destinations: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`>): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Read next bytes into the [destinations](fill.md#kotlinx.io.Input$fill(kotlin.Array((kotlinx.io.buffer.Buffer)))/destinations).
May block until at least one byte is available.

TODO: purpose.

**Return**
number of bytes were copied or `0` if no more input is available.

