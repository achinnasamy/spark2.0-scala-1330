package catalyst

class CSVFileImpl extends AbstractFileFactory {


  override def fetchFileName(): String = {

    // Read and fetch file name

    "enel.csv"
  }

  override def readInputFile(): String = {

    // Read comple file

    "enel_contents"
  }
}
