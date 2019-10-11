package fp

import org.apache.spark.sql.SparkSession

object DataCollectorJOB {


  def main(args : Array[String]) = {


    val ss = SparkSession .builder()
                          .appName("IBMReckoner")
                          .master("local[*]")
                          .getOrCreate()

    val sc = ss.sparkContext

    //csv, parquet, orc, json, avro

    val csv = ss.read.csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")

    csv.show()



  }
}