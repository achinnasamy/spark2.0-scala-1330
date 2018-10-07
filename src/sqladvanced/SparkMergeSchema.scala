package sqladvanced

import org.apache.spark.sql.SparkSession

object SparkMergeSchema {

  def main(args : Array[String]) = {


    val sparkSession = SparkSession
      .builder()
      .appName("SparkSQLJOB")
      .master("local[*]")
      .getOrCreate()


    val csvDF = sparkSession.read
      .option("header", "true")
      .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")
    csvDF.printSchema()

    val newcsvDF=sparkSession.read
      .option("header","true")
        .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/candidate.csv")

    val mergedschema=(csvDF.schema ++ newcsvDF.schema).distinct
    print(mergedschema)




    //csvDF.write.parquet("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/parqueout/")
    //csvDF.write.orc("")

  }

}
