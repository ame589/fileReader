package com.nttdata.fileReader.reader

import scala.collection.mutable

case class CSVReader(path: String) extends FileReader {

  override def readFile: Iterable[Any] = {

    val bufferedSource = io.Source.fromFile(path)

    val map = new mutable.HashMap[String, (String, String)]
    for (line <- bufferedSource.getLines.drop(1)) {
      val cols = line.split(";").map(_.trim)
      map += cols(0) -> (cols(1), cols(2))
    }

    bufferedSource.close
    map
  }
}
