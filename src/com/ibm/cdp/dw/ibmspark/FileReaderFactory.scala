package com.ibm.cdp.dw.ibmspark

trait FileReaderFactory {

  def readFileName() : String

  def readFileContent() : String

}
