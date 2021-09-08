package org.jonnyzzz.xz.check

class None : Check() {
  override fun update(buf: ByteArray, off: Int, len: Int) {}
  override fun finish(): ByteArray {
    return ByteArray(0)
  }

  init {
    size = 0
    name = "None"
  }
}
