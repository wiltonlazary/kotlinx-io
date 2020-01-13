[kotlinx-io](../index.md) / [kotlinx.io.pool](index.md) / [useInstance](./use-instance.md)

# useInstance

`inline fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, R> `[`ObjectPool`](-object-pool/index.md)`<T>.useInstance(block: (T) -> R): R`

Borrows and instance of [T](use-instance.md#T) from the pool, invokes [block](use-instance.md#kotlinx.io.pool$useInstance(kotlinx.io.pool.ObjectPool((kotlinx.io.pool.useInstance.T)), kotlin.Function1((kotlinx.io.pool.useInstance.T, kotlinx.io.pool.useInstance.R)))/block) with it and finally recycles it

