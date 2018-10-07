package structuredstreaming

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


object WindowingOperation {

  def main(args : Array[String]) = {


    import org.apache.log4j.{Level, Logger}
    Logger.getLogger("org").setLevel(Level.OFF)


    val sparkSession = SparkSession.builder
      .appName("KafkaJOB").master("local[*]").getOrCreate


    val df = sparkSession.readStream
      .format("socket")
      .option("host","localhost")
      .option("includeTimestamp", true)
      .option("port", "1234")
      .load();

    import sparkSession.implicits._

    /*********************************************************************************************/
    /**** Watermarking and Windowing Dataframe  ****/
    /*********************************************************************************************/
    val groupedDataFrame = df

      //.withWatermark("timestamp", "10 seconds")
      .groupBy(
          window($"timestamp", "5 seconds", "3 seconds"),
          $"value"
      ).count()


    val query = groupedDataFrame.writeStream
                    .outputMode("complete")
                    .option("truncate","false")
                    .format("console")
                    .start


    query.awaitTermination
  }

}
