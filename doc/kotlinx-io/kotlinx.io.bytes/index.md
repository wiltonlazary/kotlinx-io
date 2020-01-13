[kotlinx-io](../index.md) / [kotlinx.io.bytes](./index.md)

## Package kotlinx.io.bytes

### Types

| Name | Summary |
|---|---|
| [BytesInput](-bytes-input/index.md) | In memory byte source created from [BytesOutput](-bytes-output/index.md) or by using [buildInput](build-input.md).`class BytesInput : `[`Input`](../kotlinx.io/-input/index.md) |
| [BytesOutput](-bytes-output/index.md) | Create unlimited [Output](../kotlinx.io/-output/index.md) stored in memory. In advance to [Output](../kotlinx.io/-output/index.md) you can check [size](#) and create [BytesInput](-bytes-input/index.md) with [createInput](-bytes-output/create-input.md). [BytesOutput](-bytes-output/index.md) isn't using any pools and shouldn't be closed.`class BytesOutput : `[`Output`](../kotlinx.io/-output/index.md) |

### Functions

| Name | Summary |
|---|---|
| [buildInput](build-input.md) | Create [BytesInput](-bytes-input/index.md) with content from [block](build-input.md#kotlinx.io.bytes$buildInput(kotlin.Int, kotlin.Function1((kotlinx.io.bytes.BytesOutput, kotlin.Unit)))/block) using specified [bufferSize](build-input.md#kotlinx.io.bytes$buildInput(kotlin.Int, kotlin.Function1((kotlinx.io.bytes.BytesOutput, kotlin.Unit)))/bufferSize).`fun buildInput(bufferSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_BUFFER_SIZE, block: `[`BytesOutput`](-bytes-output/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`BytesInput`](-bytes-input/index.md) |
