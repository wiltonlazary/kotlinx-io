
# 2019-11-26
- `fill(buffer, count)`

# 2019-11-07
- remove pool from `Bytes` -> GC managed(for efficiency consider using `Buffer`)
- `Bytes` internal, but public `BytesInput` & `BytesOutput`
- Add `array = readByteArray()`
- Add `Input.copyTo(Output)`
- Add `Input.copyAvailableTo(Output | Buffer)` 
- Prototype `PipedInput`
- Prototype `PipedOutput`
- Remove Input/Output companion
