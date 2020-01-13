[kotlinx-io](../../index.md) / [kotlinx.io](../index.md) / [Console](index.md) / [error](./error.md)

# error

`val error: `[`Output`](../-output/index.md)

Standard error output for the platform:

* JVM -- `System.err`
* Native -- output associated with `STDERR_FILENO`
* JS -- output associated with `console.error`
