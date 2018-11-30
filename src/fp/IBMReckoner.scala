package fp

import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object IBMReckoner {

  // Lazy Loading of RDD
  // RDD are immutable
  def main(args : Array[String]) = {

    val ss = SparkSession.builder()
                .master("local[*]")
                .appName("IBMWatsonJOB")
                .getOrCreate()


    val toDoubleConverter = functions.udf[Double, String](_.toDouble)

    val toDataValidation = functions.udf[String,String]({ each =>
      if (each.equals("1400"))
        "ASA-1400"
      else "INVALID"
    })

    val authDF = ss.read.option("header", "true")
                    .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")


    authDF.printSchema()

    val modifiedDF = authDF.withColumn("asa", toDataValidation(authDF.col("asa")))

    modifiedDF.show()

    authDF.write.parquet("out.parquet")



  }

}
