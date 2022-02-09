package com.nttdata.fileReader.reader

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class FileReaderTest extends AnyFlatSpec with Matchers with GivenWhenThen {

  behavior of "FileReader"

  it should "correctly return a CSVReader if the extension is CSV" in {
    Given("A correct path and a csv extension")
    val path = "/opt/test.csv"
    When("Method is called")
    val reader = FileReader.getFileReader(path, "csv")
    Then("A CSVReader is returned")
    reader.isInstanceOf[CSVReader] shouldBe true
  }

  it should "correctly return a TXTReader if the extension is TXT" in {
    Given("A correct path and a txt extension")
    val path = "/opt/test.txt"
    When("Method is called")
    val reader = FileReader.getFileReader(path, "txt")
    Then("A TXTReader is returned")
    reader.isInstanceOf[TXTReader] shouldBe true
  }

  it should "Throws an exception if the extension is not managed" in {
    Given("A correct path but a wrong extension")
    val path = "/opt/test.pdf"
    When("Method is called")
    assertThrows[Exception](FileReader.getFileReader(path, "pdf"))
    Then("An exception is fired")
  }

}