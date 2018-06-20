package kotlinx.io.net.socket

actual interface Socket {
    suspend fun connect(host: String, port: Int)
    actual suspend fun readAvailable(buffer: ByteArray): Int
    actual suspend fun writeFully(buffer: ByteArray)
}
