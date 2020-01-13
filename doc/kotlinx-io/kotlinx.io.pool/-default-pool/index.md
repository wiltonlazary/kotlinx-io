[kotlinx-io](../../index.md) / [kotlinx.io.pool](../index.md) / [DefaultPool](./index.md)

# DefaultPool

`abstract class DefaultPool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ObjectPool`](../-object-pool/index.md)`<T>`

Default object pool implementation.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Default object pool implementation.`DefaultPool(capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [capacity](capacity.md) | Pool capacity.`val capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [borrow](borrow.md) | borrow an instance. Pool can recycle an old instance or create a new one`fun borrow(): T` |
| [clearInstance](clear-instance.md) | Clear [instance](clear-instance.md#kotlinx.io.pool.DefaultPool$clearInstance(kotlinx.io.pool.DefaultPool.T)/instance)'s state before reuse: reset pointers, counters and so on`open fun clearInstance(instance: T): T` |
| [close](close.md) | `fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [disposeInstance](dispose-instance.md) | Dispose [instance](dispose-instance.md#kotlinx.io.pool.DefaultPool$disposeInstance(kotlinx.io.pool.DefaultPool.T)/instance) and release it's resources`open fun disposeInstance(instance: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [produceInstance](produce-instance.md) | Creates a new instance of [T](index.md#T)`abstract fun produceInstance(): T` |
| [recycle](recycle.md) | Recycle an instance. Should be recycled what was borrowed before otherwise could fail`fun recycle(instance: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [validateInstance](validate-instance.md) | Validate [instance](validate-instance.md#kotlinx.io.pool.DefaultPool$validateInstance(kotlinx.io.pool.DefaultPool.T)/instance) of [T](index.md#T). Could verify that the object has been borrowed from this pool`open fun validateInstance(instance: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [use](../../kotlinx.io/use.md) | `fun <C : `[`Closeable`](../../kotlinx.io/-closeable/index.md)`, R> C.use(block: (C) -> R): R` |
| [useInstance](../use-instance.md) | Borrows and instance of [T](../use-instance.md#T) from the pool, invokes [block](../use-instance.md#kotlinx.io.pool$useInstance(kotlinx.io.pool.ObjectPool((kotlinx.io.pool.useInstance.T)), kotlin.Function1((kotlinx.io.pool.useInstance.T, kotlinx.io.pool.useInstance.R)))/block) with it and finally recycles it`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, R> `[`ObjectPool`](../-object-pool/index.md)`<T>.useInstance(block: (T) -> R): R` |
