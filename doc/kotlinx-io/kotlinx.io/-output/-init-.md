[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [Output](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`protected Output(bufferSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_BUFFER_SIZE)``Output(bufferPool: `[`ObjectPool`](../../kotlinx.io.pool/-object-pool/index.md)`<`[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`>)`

[Output](index.md) is an abstract base for writable streams of bytes over some sink.

[Output](index.md) is buffered. Buffer size depends on [Buffer.size](../../kotlinx.io.buffer/-buffer/size.md) in the [bufferPool](#) buffer.
Buffer size is [DEFAULT_BUFFER_SIZE](#) by default. Buffer can be flushed using [flush](flush.md) method.

To implement [Output](index.md) over a custom sink you should override only [fill](../../kotlinx.io.buffer/fill.md) method.

