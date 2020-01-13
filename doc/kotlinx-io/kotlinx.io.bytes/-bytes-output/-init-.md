[kotlinx-io](../../index.md) / [kotlinx.io.bytes](../index.md) / [BytesOutput](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`BytesOutput(bufferSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_BUFFER_SIZE)`

Create unlimited [Output](../../kotlinx.io/-output/index.md) stored in memory.
In advance to [Output](../../kotlinx.io/-output/index.md) you can check [size](#) and create [BytesInput](../-bytes-input/index.md) with [createInput](create-input.md).
[BytesOutput](index.md) isn't using any pools and shouldn't be closed.

