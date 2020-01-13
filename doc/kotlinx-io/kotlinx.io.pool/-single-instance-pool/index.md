[kotlinx-io](../../index.md) / [kotlinx.io.pool](../index.md) / [SingleInstancePool](./index.md)

# SingleInstancePool

`abstract class SingleInstancePool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ObjectPool`](../-object-pool/index.md)`<T>`

A pool that produces at most one instance

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A pool that produces at most one instance`SingleInstancePool()` |

### Properties

| Name | Summary |
|---|---|
| [capacity](capacity.md) | Pool capacity`val capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [borrow](borrow.md) | borrow an instance. Pool can recycle an old instance or create a new one`fun borrow(): T` |
| [close](close.md) | `fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [disposeInstance](dispose-instance.md) | Dispose [instance](dispose-instance.md#kotlinx.io.pool.SingleInstancePool$disposeInstance(kotlinx.io.pool.SingleInstancePool.T)/instance) and release it's resources`abstract fun disposeInstance(instance: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [produceInstance](produce-instance.md) | Creates a new instance of [T](index.md#T)`abstract fun produceInstance(): T` |
| [recycle](recycle.md) | Recycle an instance. Should be recycled what was borrowed before otherwise could fail`fun recycle(instance: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [use](../../kotlinx.io/use.md) | `fun <C : `[`Closeable`](../../kotlinx.io/-closeable/index.md)`, R> C.use(block: (C) -> R): R` |
| [useInstance](../use-instance.md) | Borrows and instance of [T](../use-instance.md#T) from the pool, invokes [block](../use-instance.md#kotlinx.io.pool$useInstance(kotlinx.io.pool.ObjectPool((kotlinx.io.pool.useInstance.T)), kotlin.Function1((kotlinx.io.pool.useInstance.T, kotlinx.io.pool.useInstance.R)))/block) with it and finally recycles it`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, R> `[`ObjectPool`](../-object-pool/index.md)`<T>.useInstance(block: (T) -> R): R` |
