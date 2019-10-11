package catalyst

object Client {

  def main(args : Array[String]) = {

    //Mixin
    val csvFileReader = new CSVFileImpl with LoggingWithDB2


    csvFileReader.readInputFile()

    csvFileReader.logDataToDB2()

  }

}
