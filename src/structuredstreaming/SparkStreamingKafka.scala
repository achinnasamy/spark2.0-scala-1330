package structuredstreaming

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.streaming.StreamingQuery
import org.apache.spark.sql.{Dataset, Row, SparkSession}

object SparkStreamingKafka {

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
                          .option("subscribe", "WATSON-TOPIC")
                          .load

    ds rdd

    //val values = ds.toDF("value", "timestamp")

    val query = ds//.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
                  .writeStream
                  .outputMode("append")
                  .format("console").start


    query.awaitTermination()


  }

}
