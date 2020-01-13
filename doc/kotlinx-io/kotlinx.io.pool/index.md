[kotlinx-io](../index.md) / [kotlinx.io.pool](./index.md)

## Package kotlinx.io.pool

### Types

| Name | Summary |
|---|---|
| [DefaultPool](-default-pool/index.md) | Default object pool implementation.`abstract class DefaultPool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ObjectPool`](-object-pool/index.md)`<T>` |
| [DirectAllocationPool](-direct-allocation-pool/index.md) | A pool implementation of zero capacity that always creates new instances`abstract class DirectAllocationPool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ObjectPool`](-object-pool/index.md)`<T>` |
| [ObjectPool](-object-pool/index.md) | `interface ObjectPool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Closeable`](../kotlinx.io/-closeable/index.md) |
| [SingleInstancePool](-single-instance-pool/index.md) | A pool that produces at most one instance`abstract class SingleInstancePool<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ObjectPool`](-object-pool/index.md)`<T>` |

### Functions

| Name | Summary |
|---|---|
| [useInstance](use-instance.md) | Borrows and instance of [T](use-instance.md#T) from the pool, invokes [block](use-instance.md#kotlinx.io.pool$useInstance(kotlinx.io.pool.ObjectPool((kotlinx.io.pool.useInstance.T)), kotlin.Function1((kotlinx.io.pool.useInstance.T, kotlinx.io.pool.useInstance.R)))/block) with it and finally recycles it`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, R> `[`ObjectPool`](-object-pool/index.md)`<T>.useInstance(block: (T) -> R): R` |
