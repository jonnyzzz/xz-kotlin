package org.jonnyzzz.xz.check

class CRC64 : Check() {
  companion object {
    private val TABLE = Array(4) { LongArray(256) }

    init {
      val poly64 = -0x3693a86a2878f0beL
      for (s in 0..3) {
        for (b in 0..255) {
          var r = if (s == 0) b.toLong() else TABLE[s - 1][b]
          for (i in 0..7) {
            r = if (r and 1 == 1L) {
              r ushr 1 xor poly64
            } else {
              r ushr 1
            }
          }
          TABLE[s][b] = r
        }
      }
    }
  }

  private var crc: Long = -1
  override fun update(buf: ByteArray, off: Int, len: Int) {
    val end = off + len
    var i = off
    val end4 = end - 3
    while (i < end4) {
      val tmp = crc.toInt()
      crc = TABLE[3][tmp and 0xFF xor (buf[i].toInt() and 0xFF)] xor
              TABLE[2][tmp ushr 8 and 0xFF xor (buf[i + 1].toInt() and 0xFF)] xor
              (crc ushr 32) xor
              TABLE[1][tmp ushr 16 and 0xFF xor (buf[i + 2].toInt() and 0xFF)] xor
              TABLE[0][tmp ushr 24 and 0xFF xor (buf[i + 3].toInt() and 0xFF)]
      i += 4
    }
    while (i < end) crc = TABLE[0][buf[i++].toInt() and 0xFF xor (crc.toInt() and 0xFF)] xor
            (crc ushr 8)
  }

  override fun finish(): ByteArray {
    val value = crc.inv()
    crc = -1
    val buf = ByteArray(8)
    for (i in buf.indices) buf[i] = (value shr i * 8).toByte()
    return buf
  }

  init {
    size = 8
    name = "CRC64"
  }
}
