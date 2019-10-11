package com.ibm.cdp.dw.ibmspark

class CDPFileReader {


  //LSP
  def readFile(frf: FileReaderFactory) = {
    frf.readFileContent()
  }
}
