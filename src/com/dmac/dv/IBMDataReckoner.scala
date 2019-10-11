package com.dmac.dv


import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}


object IBMDataReckoner {

  def main(args : Array[String]) = {


    // UDF - User Defined Function
    // Hive - Pig
    import org.apache.spark.sql.streaming.OutputMode
    val ss = SparkSession.builder()
                        .appName("IBMJOB")
                        .master("local[*]").getOrCreate()


    val eachLineStream = ss.readStream.format("socket")
          .option("host","localhost")
          .option("port", "4568").load()


    val streamWriter = eachLineStream.writeStream
                          .outputMode(OutputMode.Append())
                          .format("console")

    streamWriter.start().awaitTermination()

  }

}
