[kotlinx-io](../../index.md) / [kotlinx.io.pool](../index.md) / [DirectAllocationPool](./index.md)

# DirectAllocationPool

`abstract class DirectAllocationPool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ObjectPool`](../-object-pool/index.md)`<T>`

A pool implementation of zero capacity that always creates new instances

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A pool implementation of zero capacity that always creates new instances`DirectAllocationPool()` |

### Properties

| Name | Summary |
|---|---|
| [capacity](capacity.md) | Pool capacity`open val capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | `open fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [recycle](recycle.md) | Recycle an instance. Should be recycled what was borrowed before otherwise could fail`open fun recycle(instance: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [use](../../kotlinx.io/use.md) | `fun <C : `[`Closeable`](../../kotlinx.io/-closeable/index.md)`, R> C.use(block: (C) -> R): R` |
| [useInstance](../use-instance.md) | Borrows and instance of [T](../use-instance.md#T) from the pool, invokes [block](../use-instance.md#kotlinx.io.pool$useInstance(kotlinx.io.pool.ObjectPool((kotlinx.io.pool.useInstance.T)), kotlin.Function1((kotlinx.io.pool.useInstance.T, kotlinx.io.pool.useInstance.R)))/block) with it and finally recycles it`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, R> `[`ObjectPool`](../-object-pool/index.md)`<T>.useInstance(block: (T) -> R): R` |
