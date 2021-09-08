package org.jonnyzzz.xz

/**
 * XZ constants.
 */
object XZ {
    /**
     * XZ Header Magic Bytes begin a XZ file.
     * This can be useful to detect XZ compressed data.
     */
    val HEADER_MAGIC = byteArrayOf(
        0xFD.toByte(), '7'.code.toByte(), 'z'.code.toByte(), 'X'.code.toByte(), 'Z'.code.toByte(),
        '\u0000'.code.toByte()
    )

    /**
     * XZ Footer Magic Bytes are the last bytes of a XZ Stream.
     */
    val FOOTER_MAGIC = byteArrayOf('Y'.code.toByte(), 'Z'.code.toByte())

    /**
     * Integrity check ID indicating that no integrity check is calculated.
     *
     *
     * Omitting the integrity check is strongly discouraged except when
     * the integrity of the data will be verified by other means anyway,
     * and calculating the check twice would be useless.
     */
    const val CHECK_NONE = 0

    /**
     * Integrity check ID for CRC32.
     */
    const val CHECK_CRC32 = 1

    /**
     * Integrity check ID for CRC64.
     */
    const val CHECK_CRC64 = 4

    /**
     * Integrity check ID for SHA-256.
     */
    const val CHECK_SHA256 = 10
}
