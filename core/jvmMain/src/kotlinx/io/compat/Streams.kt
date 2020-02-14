package kotlinx.io.compat

import kotlinx.io.*
import kotlinx.io.buffer.*
import java.io.*


public fun OutputStream.writeBuffer(buffer: Buffer, startIndex: Int, endIndex: Int): Int {
    val length = endIndex - startIndex
    if (buffer.hasArray()) {
        write(buffer.array(), buffer.arrayOffset() + startIndex, length)
    } else {
        val content = buffer.toByteArray(startIndex, length)
        write(content)
    }

    return length
}

public fun OutputStream.toOutput(): Output = object : Output() {
    override fun flush(source: Buffer, startIndex: Int, endIndex: Int) {
        writeBuffer(source, startIndex, endIndex)
    }

    override fun closeSource() {
        this@toOutput.close()
    }
}

public fun InputStream.readTo(buffer: Buffer, startIndex: Int, endIndex: Int): Int {
    val size = endIndex - startIndex
    return if (buffer.hasArray()) {
        val count = read(buffer.array(), buffer.arrayOffset() + startIndex, size)
        if (count == -1) 0 else count
    } else {
        val array = ByteArray(size)
        val count = read(array)

        return if (count == -1) {
            0
        } else {
            buffer.storeByteArray(startIndex, array)
            count
        }
    }
}

public fun InputStream.toInput(): Input = object : Input() {
    override fun closeSource() {
        this@toInput.close()
    }

    override fun fill(buffer: Buffer, startIndex: Int, endIndex: Int): Int = readTo(buffer, startIndex, endIndex)
}
