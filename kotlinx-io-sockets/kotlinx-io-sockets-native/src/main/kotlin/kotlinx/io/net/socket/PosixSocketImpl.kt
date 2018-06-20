package kotlinx.io.net.socket

import kotlinx.io.net.selector.*

class PosixSocketImpl(override val fd: Int) : Socket, Selectable() {

    override suspend fun connect(host: String, port: Int) {

    }

    override suspend fun readAvailable(buffer: ByteArray): Int {
        TODO()
    }

    override suspend fun writeFully(buffer: ByteArray) {

    }
}
