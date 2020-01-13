[kotlinx-io](../index.md) / [kotlinx.io.text](index.md) / [forEachUtf8Line](./for-each-utf8-line.md)

# forEachUtf8Line

`inline fun `[`Input`](../kotlinx.io/-input/index.md)`.forEachUtf8Line(action: (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Iterates through each line of the input, calls [action](for-each-utf8-line.md#kotlinx.io.text$forEachUtf8Line(kotlinx.io.Input, kotlin.Function1((kotlin.String, kotlin.Unit)))/action) for each line read
and closes the input when it is exhausted.

### Exceptions

`EOFException` - if the input is already exhausted