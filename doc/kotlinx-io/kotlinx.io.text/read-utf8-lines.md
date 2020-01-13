[kotlinx-io](../index.md) / [kotlinx.io.text](index.md) / [readUtf8Lines](./read-utf8-lines.md)

# readUtf8Lines

`fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8Lines(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`

Reads the whole input as a list of UTF-8 encoded lines separated by a line break
and closes the input when it is exhausted.
A line break is either `"\n"` or `"\r\n"` and is not included in resulting strings.

### Exceptions

`EOFException` - if the input is already exhausted