package kotlinx.io.net.socket

import kotlinx.io.net.selector.*
import java.net.*
import java.nio.*
import java.nio.channels.*

class NIOSocketImpl(override val nioChannel: SocketChannel,
                    private val selector: SelectorManager) : Socket, Selectable() {

    constructor(selector: SelectorManager) : this(SocketChannel.open(), selector)

    override suspend fun connect(address: SocketAddress) {
        if (nioChannel.connect(address)) {
            return
        }

        return connectSuspend()
    }

    private suspend fun connectSuspend() {
        do {
            selector.select(this, SelectInterest.CONNECT)
            if (nioChannel.finishConnect()) break
        } while (true)
    }

    override suspend fun readAvailable(buffer: ByteArray): Int {
        val bb = ByteBuffer.wrap(buffer)
        val rc = nioChannel.read(bb)
        if (rc == 0) {
            return readAvailableSuspend(bb)
        }

        return rc
    }

    private suspend fun readAvailableSuspend(bb: ByteBuffer): Int {
        do {
            selector.select(this, SelectInterest.READ)
            val rc = nioChannel.read(bb)
            if (rc != 0) return rc
        } while (true)
    }

    override suspend fun writeFully(buffer: ByteArray) {
        val bb = ByteBuffer.wrap(buffer)
        val rc = nioChannel.write(bb)
        if (rc != 0 && !bb.hasRemaining()) return

        return writeFullySuspend(bb)
    }

    private suspend fun writeFullySuspend(buffer: ByteBuffer) {
        do {
            selector.select(this, SelectInterest.WRITE)
            val rc = nioChannel.write(buffer)
            if (rc != 0) return
        } while (true)
    }
}
