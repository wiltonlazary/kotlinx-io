[kotlinx-io](../../index.md) / [kotlinx.io.pool](../index.md) / [ObjectPool](./index.md)

# ObjectPool

`interface ObjectPool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Closeable`](../../kotlinx.io/-closeable/index.md)

### Properties

| Name | Summary |
|---|---|
| [capacity](capacity.md) | Pool capacity`abstract val capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [borrow](borrow.md) | borrow an instance. Pool can recycle an old instance or create a new one`abstract fun borrow(): T` |
| [recycle](recycle.md) | Recycle an instance. Should be recycled what was borrowed before otherwise could fail`abstract fun recycle(instance: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [use](../../kotlinx.io/use.md) | `fun <C : `[`Closeable`](../../kotlinx.io/-closeable/index.md)`, R> C.use(block: (C) -> R): R` |
| [useInstance](../use-instance.md) | Borrows and instance of [T](../use-instance.md#T) from the pool, invokes [block](../use-instance.md#kotlinx.io.pool$useInstance(kotlinx.io.pool.ObjectPool((kotlinx.io.pool.useInstance.T)), kotlin.Function1((kotlinx.io.pool.useInstance.T, kotlinx.io.pool.useInstance.R)))/block) with it and finally recycles it`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, R> `[`ObjectPool`](./index.md)`<T>.useInstance(block: (T) -> R): R` |

### Inheritors

| Name | Summary |
|---|---|
| [DefaultPool](../-default-pool/index.md) | Default object pool implementation.`abstract class DefaultPool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ObjectPool`](./index.md)`<T>` |
| [DirectAllocationPool](../-direct-allocation-pool/index.md) | A pool implementation of zero capacity that always creates new instances`abstract class DirectAllocationPool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ObjectPool`](./index.md)`<T>` |
| [SingleInstancePool](../-single-instance-pool/index.md) | A pool that produces at most one instance`abstract class SingleInstancePool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ObjectPool`](./index.md)`<T>` |
