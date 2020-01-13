[kotlinx-io](../index.md) / [kotlinx.io.text](./index.md)

## Package kotlinx.io.text

### Types

| Name | Summary |
|---|---|
| [Charsets](-charsets/index.md) | `object Charsets` |

### Exceptions

| Name | Summary |
|---|---|
| [MalformedInputException](-malformed-input-exception/index.md) | `open class MalformedInputException : `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |

### Properties

| Name | Summary |
|---|---|
| [charset](charset.md) | Decoder's charset it is created for.`val `[`CharsetDecoder`](-charset-decoder/index.md)`.charset: `[`Charset`](-charset/index.md)`val `[`CharsetEncoder`](-charset-encoder/index.md)`.charset: `[`Charset`](-charset/index.md) |
| [name](name.md) | `val `[`Charset`](-charset/index.md)`.name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [forEachUtf8Line](for-each-utf8-line.md) | Iterates through each line of the input, calls [action](for-each-utf8-line.md#kotlinx.io.text$forEachUtf8Line(kotlinx.io.Input, kotlin.Function1((kotlin.String, kotlin.Unit)))/action) for each line read and closes the input when it is exhausted.`fun `[`Input`](../kotlinx.io/-input/index.md)`.forEachUtf8Line(action: (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [readUtf8Line](read-utf8-line.md) | Reads the line in UTF-8 encoding from the input until the next line break or until the input is exhausted. A line break is either `"\n"` or `"\r\n"` and is not included in the result.`fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8Line(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [readUtf8Lines](read-utf8-lines.md) | Reads the whole input as a list of UTF-8 encoded lines separated by a line break and closes the input when it is exhausted. A line break is either `"\n"` or `"\r\n"` and is not included in resulting strings.`fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8Lines(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [readUtf8LineTo](read-utf8-line-to.md) | `fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8LineTo(out: `[`Appendable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-appendable/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [readUtf8String](read-utf8-string.md) | `fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8String(length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [readUtf8StringTo](read-utf8-string-to.md) | `fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8StringTo(out: `[`Appendable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-appendable/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readUtf8StringUntilDelimiter](read-utf8-string-until-delimiter.md) | `fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8StringUntilDelimiter(delimiter: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [readUtf8StringUntilDelimiters](read-utf8-string-until-delimiters.md) | `fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8StringUntilDelimiters(delimiters: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [readUtf8StringUntilDelimitersTo](read-utf8-string-until-delimiters-to.md) | `fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8StringUntilDelimitersTo(stringBuilder: `[`Appendable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-appendable/index.html)`, delimiters: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readUtf8StringUntilDelimiterTo](read-utf8-string-until-delimiter-to.md) | `fun `[`Input`](../kotlinx.io/-input/index.md)`.readUtf8StringUntilDelimiterTo(stringBuilder: `[`Appendable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-appendable/index.html)`, delimiter: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [writeUtf8String](write-utf8-string.md) | Write [length](write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/length) bytes in [text](write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/text) starting from offset [index](write-utf8-string.md#kotlinx.io.text$writeUtf8String(kotlinx.io.Output, kotlin.CharSequence, kotlin.Int, kotlin.Int)/index) to output.`fun `[`Output`](../kotlinx.io/-output/index.md)`.writeUtf8String(text: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = text.length - index): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
