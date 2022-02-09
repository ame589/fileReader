package com.nttdata.fileReader.util

import com.nttdata.fileReader.constants.FileExtension
import com.nttdata.fileReader.exceptions.FileExtensionException

import java.io.FileNotFoundException
import java.nio.file.{Files, Path, Paths}

object Validator {

  /**
   *
   * @param path input file
   * @return the extension of the validated path
   */
  def validate(path: String): String = {

    if(!validatePath(path))
      throw new FileNotFoundException(f"File $path doesn't exist")

    val extension = path.split("\\.").last
    if(!validateExtension(extension))
      throw new FileExtensionException(f"Extension $extension not valid")

    extension

  }

  /**
   *
   * @param path input file
   * @return if the file exists
   */
  def validatePath(path: String): Boolean = {

    Files.exists(Paths.get(path))

  }

  def validateExtension(extension: String): Boolean = {

     FileExtension.values.map(_.toString).contains(extension)

  }

}
