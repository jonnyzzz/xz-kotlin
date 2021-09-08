package org.jonnyzzz.xz

/**
 * Generic IOException specific to this package.
 * The other IOExceptions in this package extend
 * from `XZIOException`.
 */
open class XZIOException : IOException {
  constructor() : super()
  constructor(s: String?) : super(s)

  companion object {
    private const val serialVersionUID = 3L
  }
}

expect open class IOException : Exception {
  constructor()
  constructor(s: String?)
}
