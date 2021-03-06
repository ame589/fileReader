package com.nttdata.fileReader.exceptions

abstract class CustomException(message: String) extends Exception(message) {

  def this(message: String, cause: Throwable) {
    this(message)
    initCause(cause)
  }

  def this(cause: Throwable) {
    this(Option(cause).map(_.toString).orNull, cause)
  }

  def this() {
    this(null: String)
  }
}

/** Override of Exception class to manage missing file */
class FileExtensionException(message: String) extends CustomException(message)
