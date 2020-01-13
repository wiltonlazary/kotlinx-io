[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [ByteArrayOutput](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`ByteArrayOutput(initialCapacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 16)`

Output which uses byte array as its data storage.
Byte array grows automatically as data is written to it and
can be accessed with [toByteArray](to-byte-array.md).
Initial capacity of the underlying array can be specified with [initialCapacity](#) parameter.

Calling [close](../-output/close.md) on this class has no effect.

