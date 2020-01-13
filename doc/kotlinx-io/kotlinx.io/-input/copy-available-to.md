[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [Input](index.md) / [copyAvailableTo](./copy-available-to.md)

# copyAvailableTo

`fun copyAvailableTo(destination: `[`Output`](../-output/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Copy buffered bytes to [destination](copy-available-to.md#kotlinx.io.Input$copyAvailableTo(kotlinx.io.Output)/destination). If no bytes buffered it will block until [fill](fill.md) is finished.

**Return**
transferred bytes count.

`fun copyAvailableTo(destination: `[`Buffer`](../../kotlinx.io.buffer/-buffer/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Copy buffered bytes to [destination](copy-available-to.md#kotlinx.io.Input$copyAvailableTo(kotlinx.io.buffer.Buffer)/destination). If no bytes buffered it will call [fill](fill.md) on [destination](copy-available-to.md#kotlinx.io.Input$copyAvailableTo(kotlinx.io.buffer.Buffer)/destination) directly.

**Return**
transferred bytes count.

