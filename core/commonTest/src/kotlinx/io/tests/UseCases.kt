package kotlinx.io.tests

class UseCases {

    /**
     * Count bytes
     * fixed size packet + random access
     * write bytes, prepend size
     * parse(read) until magic delimeter
     * push back on parse(parse packet from end)
     * readChars/parseUntil
     * mixed endiannes reading
     * data formats parsing: images, ...
     * check read/write position
     * build packet and store hashcode
     *
     * Main:
     *  - parsing: parser with BytesInput
     *  - store: cache with ByteString
     *
     */
}