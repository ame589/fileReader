package com.nttdata.fileReader.reader

import com.nttdata.fileReader.constants.FileExtension

trait FileReader {

  def readFile: Iterable[Any]

}

/**
 * Companion Object
 */
object FileReader {

  def getFileReader(path: String, extension: String): FileReader = {

    extension match {
      case FileExtension.CSV => CSVReader(path)
      case FileExtension.TXT => TXTReader(path)
      case _ => throw new Exception
    }
  }
}
