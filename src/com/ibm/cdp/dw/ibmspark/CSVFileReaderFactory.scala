package com.ibm.cdp.dw.ibmspark

//OCP - SRP
class CSVFileReaderFactory extends FileReaderFactory {

  override def readFileName(): String = {
    "auth.csv"
  }

  override def readFileContent(): String = {


    "content_of_file"
  }
}
