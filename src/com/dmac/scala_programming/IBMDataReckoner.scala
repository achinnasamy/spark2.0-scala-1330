package com.dmac.scala_programming

import org.apache.spark.sql.SparkSession

object IBMDataReckoner {


  def main(args : Array[String]) = {

    val sparkSession = SparkSession.builder().master("spark://apples-MacBook-Pro.local:7077")
                              .appName("Kafka-JOB")
                              .getOrCreate()

    val csvDF = sparkSession.read.csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")


    csvDF.show(10)

  }
}


git commit -m "Added files" src/DataReckonerJOB.scala  src/FeatureOnImpicit.scala src/FileUtility.scala src/IBMBlueMix.scala src/IBMFormalValidation.scala src/IBMReckonerDataJob.scala src/IBMSubstantialValidation.scala src/IBmDataJob.scala src/catalyst/AbstractFileFactory.scala src/catalyst/CSVFileImpl.scala src/catalyst/Client.scala src/catalyst/JsonFileImpl.scala src/catalyst/LoggingWithDB2.scala src/com/dmac/atos/ExceptionHandler.scala src/com/dmac/atos/FormalValidationPower.scala src/com/dmac/dv/CloudantFactory.scala src/com/dmac/dv/DataReckoner.scala src/com/dmac/dv/FileFactory.scala src/com/dmac/dv/IBMDataReckoner.scala src/com/dmac/dv/IBMDataReckonerJOB.scala src/com/dmac/scala_programming/IBMDataReckoner.scala src/com/dmac/scala_test/EnelTestSuite.scala src/com/ibm/cdp/dw/ibmspark/CDPClient.scala src/com/ibm/cdp/dw/ibmspark/CDPDataReckoner.scala src/com/ibm/cdp/dw/ibmspark/CDPFileReader.scala src/com/ibm/cdp/dw/ibmspark/CSVFileReaderFactory.scala src/com/ibm/cdp/dw/ibmspark/FileReaderFactory.scala src/com/ibm/cdp/dw/ibmspark/ParquetFileReaderFactory.scala src/com/ibm/cdp/dw/ibmspark/TablesEnum.scala src/com/ibm/cdp/dw/ibmspark/XMLFileReaderFactory.scala src/designpattern/CompileTimeDuckTyping.scala src/designpattern/InnerCaseClasses.scala src/designpattern/TypeEnrichment.scala src/fp/DataCollectorJOB.scala src/fp/FactoryJob.scala src/fp/FileSaverFactory.scala src/fp/KafkaJob.scala src/fp/KafkaLogger.scala src/fp/PersistObjectFile.scala src/fp/PersistTextFile.scala
