package com.nttdata.fileReader.reader

case class TXTReader(path: String) extends FileReader {

  override def readFile: Iterable[Any] = {

    val bufferedSource = io.Source.fromFile(path)

    val lines = try bufferedSource.getLines() finally bufferedSource.close()
    lines.toSeq

  }
}
