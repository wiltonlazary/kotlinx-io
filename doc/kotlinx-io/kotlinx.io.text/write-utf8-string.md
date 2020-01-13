[kotlinx-io](../index.md) / [kotlinx.io.text](index.md) / [writeUtf8String](./write-utf8-string.md)

# writeUtf8String

`fun `[`Output`](../kotlinx.io/-output/index.md)`.writeUtf8String(text: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = text.length - index): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Write [length](write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/length) bytes in [text](write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/text) starting from offset [index](write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/index) to output.

### Exceptions

`MalformedInputException` - if encoding is invalid.