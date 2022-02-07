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

    val csvExtension = FileExtension.CSV.toString
    val txtExtension = FileExtension.TXT.toString

    extension match {
      case csvExtension => CSVReader(path)
      case txtExtension => TXTReader(path)
      case _ => throw new Exception
    }
  }
}
