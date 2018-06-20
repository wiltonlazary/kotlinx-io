package kotlinx.io.net.socket

expect interface Socket {
    suspend fun readAvailable(buffer: ByteArray): Int
    suspend fun writeFully(buffer: ByteArray)
}
