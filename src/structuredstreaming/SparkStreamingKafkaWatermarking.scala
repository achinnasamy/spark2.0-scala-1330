package structuredstreaming

import java.sql.Timestamp

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.window

object SparkStreamingKafkaWatermarking {

  def main(args : Array[String]) = {


    val sparkSession = SparkSession .builder
                                    .appName("KafkaJOB")
                                    .master("local[*]")
                                    .getOrCreate


    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

    val ds = sparkSession .readStream
                          .format("kafka")
                          .option("kafka.bootstrap.servers", "localhost:9092")
                          .option("subscribe", "HDFS-TOPIC")
                          .load

    import sparkSession.implicits._
    //val values = ds.toDF("value", "timestamp")


    val query =
          ds
            .withWatermark("timestamp", "300 seconds")
            .groupBy(
              window($"timestamp", "5 seconds") )
            .count
            .writeStream
            .outputMode("update")
            .option("truncate","false")
            .format("console").start

    query.awaitTermination()


  }

}

case class KafkaData(time: Timestamp, key: String, value: Double)