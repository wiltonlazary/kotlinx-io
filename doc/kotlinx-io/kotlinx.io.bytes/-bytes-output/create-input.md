[kotlinx-io](../../index.md) / [kotlinx.io.bytes](../index.md) / [BytesOutput](index.md) / [createInput](./create-input.md)

# createInput

`fun createInput(): `[`BytesInput`](../-bytes-input/index.md)

Create [BytesInput](../-bytes-input/index.md) from this [Output](../../kotlinx.io/-output/index.md).
This can be called multiple times and. It always returns independent [BytesInput](../-bytes-input/index.md) without copying of underline buffers.
The buffers will be copied on demand.

[BytesOutput](index.md) is safe to append content after [createInput](./create-input.md). It won't change any already created [BytesInput](../-bytes-input/index.md).

