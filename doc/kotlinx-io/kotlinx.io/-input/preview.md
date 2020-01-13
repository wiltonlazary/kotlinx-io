[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [Input](index.md) / [preview](./preview.md)

# preview

`fun <R> preview(reader: `[`Input`](index.md)`.() -> R): R`

Allows reading from [Input](index.md) in the [reader](preview.md#kotlinx.io.Input$preview(kotlin.Function1((kotlinx.io.Input, kotlinx.io.Input.preview.R)))/reader) block without consuming its content.

This operation saves the state of the [Input](index.md) before [reader](preview.md#kotlinx.io.Input$preview(kotlin.Function1((kotlinx.io.Input, kotlinx.io.Input.preview.R)))/reader) and accumulates buffers for replay.
When the [reader](preview.md#kotlinx.io.Input$preview(kotlin.Function1((kotlinx.io.Input, kotlinx.io.Input.preview.R)))/reader) finishes, it rewinds this [Input](index.md) to the state before the [reader](preview.md#kotlinx.io.Input$preview(kotlin.Function1((kotlinx.io.Input, kotlinx.io.Input.preview.R)))/reader) block.
Please note that [Input](index.md) holds accumulated buffers until they are't consumed outside of the [preview](./preview.md).

Preview operations can be nested.

