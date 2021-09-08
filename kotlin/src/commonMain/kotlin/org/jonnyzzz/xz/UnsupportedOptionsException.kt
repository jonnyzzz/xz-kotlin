package org.jonnyzzz.xz

/**
 * Thrown when compression options not supported by this implementation
 * are detected. Some other implementation might support those options.
 */
class UnsupportedOptionsException : XZIOException {
  /**
   * Creates a new UnsupportedOptionsException with null
   * as its error detail message.
   */
  constructor() {}

  /**
   * Creates a new UnsupportedOptionsException with the given
   * error detail message.
   *
   * @param       s           error detail message
   */
  constructor(s: String?) : super(s)

  companion object {
    private const val serialVersionUID = 3L
  }
}
