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