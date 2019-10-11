package com.dmac.dv


import org.apache.spark.sql.functions


object DataReckoner1 {

  // Driver Program
  def main(args : Array[String]): Unit  = {


    val toDouble = functions.udf[Double, String](_.toDouble)

    import org.apache.spark.sql.SparkSession

    val ss = SparkSession.builder()
                        .appName("SQLJOB")
                        .master("local[*]")
                        .getOrCreate()


    val csvDF = ss.sqlContext.read.option("header", "true")
                    .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")

    val asaUDF = functions.udf[String,String]((x) =>
      if (x.equals("1400"))
        "authentic-server-agency"
      else "NIL"
    )

    val modifiedDF = csvDF.withColumn("asa", asaUDF(csvDF.col("asa")))


    val modifiedRDD = modifiedDF.rdd


    modifiedDF.printSchema()
    modifiedDF.show()


    










    csvDF.show()

    //csvDF.printSchema()
//
//    csvDF.createOrReplaceTempView("AUTH_TABLE")
//    csvDF.createTempView("AUTH_TABLE")
//    csvDF.createGlobalTempView("AUTH_TABLE")

    //val tidDF = ss.sql("SELECT tid,asa FROM AUTH_TABLE")

    //tidDF.show(50)



  }
}










