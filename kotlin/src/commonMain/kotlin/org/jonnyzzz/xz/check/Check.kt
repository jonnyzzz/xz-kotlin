package org.jonnyzzz.xz.check

import org.jonnyzzz.xz.UnsupportedOptionsException
import org.jonnyzzz.xz.XZ

abstract class Check {
  var size = 0
  var name: String? = null

  abstract fun update(buf: ByteArray, off: Int, len: Int)
  abstract fun finish(): ByteArray
  fun update(buf: ByteArray) {
    update(buf, 0, buf.size)
  }

  companion object {
    @Throws(UnsupportedOptionsException::class)
    fun getInstance(checkType: Int): Check {
      when (checkType) {
        XZ.CHECK_NONE -> return None()
//        XZ.CHECK_CRC32 -> return CRC32()
        XZ.CHECK_CRC64 -> return CRC64()
//        XZ.CHECK_SHA256 -> try {
//          return SHA256()
//        } catch (e: NoSuchAlgorithmException) {
//        }
      }
      throw UnsupportedOptionsException(
        "Unsupported Check ID $checkType"
      )
    }
  }
}