[kotlinx-io](../index.md) / [kotlinx.io.text](index.md) / [readUtf8Line](./read-utf8-line.md)

# readUtf8Line

`fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8Line(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Reads the line in UTF-8 encoding from the input until the next line break or until the input is exhausted.
A line break is either `"\n"` or `"\r\n"` and is not included in the result.

### Exceptions

`EOFException` - if the input is already exhausted