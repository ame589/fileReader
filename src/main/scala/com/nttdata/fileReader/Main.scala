package com.nttdata.fileReader

import com.nttdata.fileReader.reader.FileReader
import com.nttdata.fileReader.util.Validator

object Main extends App {

  //TODO Add check on args
  val extension = Validator.validate(args(0))
  val reader = FileReader.getFileReader(args(0), extension)
  reader.readFile.foreach(println)

}
