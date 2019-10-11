package com.ibm.cdp.dw.ibmspark

import org.apache.spark.Partitioner
import org.apache.spark.sql.{SparkSession, functions}


object CDPClient {


  SparkSession
  //------------------------------------------------
  // Core               SQL             Streaming

  //1.6// RDD             Dataframe       DStreams
  //2.0

  def main(args : Array[String]) = {

    import org.apache.spark.{SparkContext}

    val ss = SparkSession.builder()
      .appName("IBMJob").master("local[*]")

      .getOrCreate()


    val csvDF = ss.read
                    .option("header", "true")
                    .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")


    val toDouble = functions.udf[Double, String](_.toDouble)


    val toDataValidation = functions.udf[Double,String]({ each =>
      if (each.equals("1400"))
        123d
      else 456d
    })

    val dbDF = ss.read.format("jdbc").options(
                              Map("url" -> "jdbc:mysql://127.0.0.1:3306/slz_core",
                                "user" -> "slz02",
                                "password" -> "slz02@123",
                                "dbtable" -> "regions"))
                .load()



    //csv, json, parquet, orc, avro

    csvDF.createGlobalTempView("AUTH_TABLE")

    val allDF = ss.sql("SELECT asa FROM global_temp.auth_table LIMIT 500 where asa > 500")

    val changedDF = allDF.withColumn("ver", toDouble(allDF.col("ver")))

    val modifiedDF = allDF.withColumn("asa", toDataValidation(allDF.col("asa")))

    val sDF = modifiedDF.select(allDF.col("asa").gt(450d))

    sDF.show()



  }

}

