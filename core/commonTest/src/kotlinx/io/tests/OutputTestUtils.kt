package kotlinx.io.tests

import kotlinx.io.*
import kotlinx.io.buffer.*

class LambdaOutput(private val block: (source: Buffer, endIndex: Int) -> Unit) : Output() {
    override fun flush(source: Buffer, endIndex: Int) {
        block(source, endIndex)
    }

    override fun closeSource() {}
}