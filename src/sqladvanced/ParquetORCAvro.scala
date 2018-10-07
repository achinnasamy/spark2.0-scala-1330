package sqladvanced

import org.apache.spark.sql.SparkSession

object ParquetORCAvro {


  def main(args: Array[String]) = {
    val sparkSession = SparkSession
      .builder()
      .appName("SparkSQLJOB")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    val csvDF = sparkSession.read
      .option("header", "true")
      .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")
      .select("auth_code","asa","tid").limit(5)


    csvDF.printSchema()
    csvDF.show()



    //csvDF.write
    //     .parquet("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth_parquet/")


    csvDF.write.format("orc")
               .save("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth_orc/")

  }
}
