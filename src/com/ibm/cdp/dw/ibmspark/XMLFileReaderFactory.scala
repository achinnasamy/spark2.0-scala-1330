package com.ibm.cdp.dw.ibmspark

class XMLFileReaderFactory extends FileReaderFactory {
  override def readFileName(): String = {
    "auth.xml"
  }

  override def readFileContent(): String = {
    "xml_content"
  }
}
