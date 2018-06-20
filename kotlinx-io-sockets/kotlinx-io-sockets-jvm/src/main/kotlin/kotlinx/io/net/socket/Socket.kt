package kotlinx.io.net.socket

import java.net.*

actual interface Socket {
    suspend fun connect(address: SocketAddress)
    actual suspend fun readAvailable(buffer: ByteArray): Int
    actual suspend fun writeFully(buffer: ByteArray)
}