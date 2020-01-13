[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [Closeable](./index.md)

# Closeable

`interface Closeable`

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | `abstract fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [use](../use.md) | `fun <C : `[`Closeable`](./index.md)`, R> C.use(block: (C) -> R): R` |

### Inheritors

| Name | Summary |
|---|---|
| [Input](../-input/index.md) | [Input](../-input/index.md) is an abstract base class for synchronous byte readers.`abstract class Input : `[`Closeable`](./index.md) |
| [ObjectPool](../../kotlinx.io.pool/-object-pool/index.md) | `interface ObjectPool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Closeable`](./index.md) |
| [Output](../-output/index.md) | [Output](../-output/index.md) is an abstract base for writable streams of bytes over some sink.`abstract class Output : `[`Closeable`](./index.md) |
