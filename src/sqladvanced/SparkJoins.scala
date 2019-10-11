package sqladvanced

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{ when, col, lit }

object SparkJoins {


  def main(args : Array[String]) = {

    val ss = SparkSession.builder()
                         .master("local[*]")
                         .appName("JoinJob")
                         .getOrCreate()


    val authCSVDF = ss.read
                      .option("header", "true")
                      .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")


    val streamsDF = ss.read
      .option("header", "true")
      .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/stream_sets.csv")



    val selectedColumnsDF = authCSVDF.select("aua", "asa", "license_id").where(col("aua") =!= "740000")

    val resultantDF = selectedColumnsDF.withColumn("AUA_REFACTORED", col("aua").startsWith("74"))
                                       .withColumn("KERBEROS", lit("AUTHENTICATED"))
                                       .withColumnRenamed("ASA", "ASA_KERBORISED")
                                       .withColumn("AUA_AGENCY", when(col("aua").equalTo("340000"), "AUTHENTIC_AGENCY").otherwise("AGENCY_TO_BE_VALIDATED"))
                                       .drop(col("license_id"))
                                       .filter(!col("ASA").equalTo("500"))


    resultantDF.join(streamsDF, resultantDF("ASA_KERBORISED") === streamsDF("asa"), "left_outer")
               .withColumn("stream_sets", streamsDF("stream_sets"))
               .na.fill("UNKNOWN_STREAM", Seq("stream_sets"))
               .dropDuplicates()
               //.show(1000)

    resultantDF.explain(true)

    //resultantDF.show()

    //resultantDF.show()

  }
}
