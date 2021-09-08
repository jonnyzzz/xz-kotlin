package org.jonnyzzz.xz.check

 /*
class CRC32 : Check() {
  private val state: java.util.zip.CRC32 = java.util.zip.CRC32()
  override fun update(buf: ByteArray, off: Int, len: Int) {
    state.update(buf, off, len)
  }

  override fun finish(): ByteArray {
    val value: Long = state.getValue()
    val buf = byteArrayOf(
      value.toByte(),
      (value ushr 8).toByte(),
      (value ushr 16).toByte(),
      (value ushr 24).toByte()
    )
    state.reset()
    return buf
  }

  init {
    size = 4
    name = "CRC32"
  }
}
*/