

### All Types

| Name | Summary |
|---|---|
|

##### [kotlinx.io.buffer.Buffer](../kotlinx.io.buffer/-buffer/index.md)

[Buffer](../kotlinx.io.buffer/-buffer/index.md) represents a linear range of sequentially placed and randomly accessible bytes.
[Buffer](../kotlinx.io.buffer/-buffer/index.md) primitive is used as the underlying storage for higher-level primitives such as [Bytes](#), [Input](../kotlinx.io/-input/index.md) and [Output](../kotlinx.io/-output/index.md).


|

##### [kotlinx.io.buffer.BufferAllocator](../kotlinx.io.buffer/-buffer-allocator/index.md)


| (extensions in package kotlinx.io.buffer)

##### [kotlin.ByteArray](../kotlinx.io.buffer/kotlin.-byte-array/index.md)


|

##### [kotlinx.io.ByteArrayOutput](../kotlinx.io/-byte-array-output/index.md)

Output which uses byte array as its data storage.
Byte array grows automatically as data is written to it and
can be accessed with [toByteArray](../kotlinx.io/-byte-array-output/to-byte-array.md).
Initial capacity of the underlying array can be specified with [initialCapacity](#) parameter.


| (extensions in package kotlinx.io.buffer)

##### [java.nio.ByteBuffer](../kotlinx.io.buffer/java.nio.-byte-buffer/index.md)


|

##### [kotlinx.io.ByteOrder](../kotlinx.io/-byte-order/index.md)

Enumeration that represent an endianness of the arbitrary binary data.
Endianness refers to the order of bytes within a binary representation of a binary data.


|

##### [kotlinx.io.bytes.BytesInput](../kotlinx.io.bytes/-bytes-input/index.md)

In memory byte source created from [BytesOutput](../kotlinx.io.bytes/-bytes-output/index.md) or by using [buildInput](../kotlinx.io.bytes/build-input.md).


|

##### [kotlinx.io.bytes.BytesOutput](../kotlinx.io.bytes/-bytes-output/index.md)

Create unlimited [Output](../kotlinx.io/-output/index.md) stored in memory.
In advance to [Output](../kotlinx.io/-output/index.md) you can check [size](#) and create [BytesInput](../kotlinx.io.bytes/-bytes-input/index.md) with [createInput](../kotlinx.io.bytes/-bytes-output/create-input.md).
[BytesOutput](../kotlinx.io.bytes/-bytes-output/index.md) isn't using any pools and shouldn't be closed.


|

##### [kotlinx.io.text.Charset](../kotlinx.io.text/-charset/index.md)


|

##### [kotlinx.io.text.CharsetDecoder](../kotlinx.io.text/-charset-decoder/index.md)


|

##### [kotlinx.io.text.CharsetEncoder](../kotlinx.io.text/-charset-encoder/index.md)


|

##### [kotlinx.io.text.Charsets](../kotlinx.io.text/-charsets/index.md)


|

##### [kotlinx.io.Closeable](../kotlinx.io/-closeable/index.md)


|

##### [kotlinx.io.Console](../kotlinx.io/-console/index.md)

Console incorporates all system inputs and outputs in a multiplatform manner.
All sources are open by default, ready to read from/write to and cannot be closed.


|

##### [kotlinx.io.pool.DefaultPool](../kotlinx.io.pool/-default-pool/index.md)

Default object pool implementation.


|

##### [kotlinx.io.pool.DirectAllocationPool](../kotlinx.io.pool/-direct-allocation-pool/index.md)

A pool implementation of zero capacity that always creates new instances


|

##### [kotlinx.io.EOFException](../kotlinx.io/-e-o-f-exception/index.md)


|

##### [kotlinx.io.ExperimentalIoApi](../kotlinx.io/-experimental-io-api/index.md)

API marked with this annotation is experimental and could be changed


|

##### [kotlinx.io.Input](../kotlinx.io/-input/index.md)

[Input](../kotlinx.io/-input/index.md) is an abstract base class for synchronous byte readers.


|

##### [kotlinx.io.IOException](../kotlinx.io/-i-o-exception/index.md)


|

##### [kotlinx.io.text.MalformedInputException](../kotlinx.io.text/-malformed-input-exception/index.md)


|

##### [kotlinx.io.pool.ObjectPool](../kotlinx.io.pool/-object-pool/index.md)


|

##### [kotlinx.io.Output](../kotlinx.io/-output/index.md)

[Output](../kotlinx.io/-output/index.md) is an abstract base for writable streams of bytes over some sink.


|

##### [kotlinx.io.buffer.PlatformBufferAllocator](../kotlinx.io.buffer/-platform-buffer-allocator/index.md)


|

##### [kotlinx.io.pool.SingleInstancePool](../kotlinx.io.pool/-single-instance-pool/index.md)

A pool that produces at most one instance


|

##### [kotlinx.io.buffer.UnmanagedBufferAllocator](../kotlinx.io.buffer/-unmanaged-buffer-allocator.md)


