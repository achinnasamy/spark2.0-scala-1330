package com.dmac.dv

import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object IBMDataJOB extends App {


    val ss = SparkSession.builder()
                         .appName("SparkJOB")
                         .master("local[*]")
                         .getOrCreate()

    //csv
    //txt
    //json
    //orc
    //parquet
    //ss.sqlContext.read.csv("")

    val authDF = ss.read
        .option("header","true")
        .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")


    authDF.createOrReplaceTempView("AUTH_DATA_TABLE")

    val toChangeDataType = functions.udf[Double,String](_.toDouble)


    val complexFunction = functions.udf[String,String](new scala.Function1[String, String]{
        override def apply(inputAUA: String): String = {
            if (inputAUA.equals("4900000")) "AUA_KNOWN"
            else "UNKNOWN"
        }
    })

    val authTableDF = ss.sql("select * from AUTH_DATA_TABLE")

    val changedDF = authTableDF.withColumn("aua",
                            complexFunction(authTableDF.col("aua")))


    authTableDF.printSchema()

    changedDF.printSchema()

    changedDF.show()
    //authTableDF.show()
    //authDF.show()

    ss.stop()

}

