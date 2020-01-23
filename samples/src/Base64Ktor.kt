import kotlinx.io.*
import kotlinx.io.buffer.*
import kotlinx.io.bytes.*
import kotlin.experimental.*

private const val BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
private const val BASE64_MASK: Byte = 0x3f
private const val BASE64_PAD = '='

private val BASE64_INVERSE_ALPHABET = IntArray(256) {
    BASE64_ALPHABET.indexOf(it.toChar())
}

fun Input.encodeBase64(): String = buildString {
    val data = bufferOf(ByteArray(3))
    while (!eof()) {

        val read = readAvailableTo(data)
        data.clearFrom(read)

        val padSize = (data.size - read) * 8 / 6
        val chunk = ((data[0].toInt() and 0xFF) shl 16) or
                ((data[1].toInt() and 0xFF) shl 8) or
                (data[2].toInt() and 0xFF)

        for (index in data.size downTo padSize) {
            val char = (chunk shr (6 * index)) and BASE64_MASK.toInt()
            append(char.toBase64())
        }

        repeat(padSize) { append(BASE64_PAD) }
    }
}

fun Input.decodeBase64Bytes(): Input = buildInput {
    val data = bufferOf(ByteArray(4))

    while (!eof()) {
        val count = readAvailableTo(data)

        var chunk = 0
        for (index in 0..4) {
            chunk = chunk or (data[index].toInt() shl ((3 - index) * 6))
        }

        for (index in data.size - 2 downTo (data.size - count)) {
            val origin = (chunk shr (8 * index)) and 0xff
            writeByte(origin.toByte())
        }
    }
}

internal fun Buffer.clearFrom(from: Int) {
    fill(from, size - from, 0)
}

internal fun Int.toBase64(): Char = BASE64_ALPHABET[this]
internal fun Byte.fromBase64(): Byte = BASE64_INVERSE_ALPHABET[toInt() and 0xff].toByte() and BASE64_MASK
