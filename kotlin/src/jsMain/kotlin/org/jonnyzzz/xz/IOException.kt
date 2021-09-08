package org.jonnyzzz.xz

actual open class IOException : Exception {
  actual constructor() : super()
  actual constructor(s: String?): super(s)
}
