package structuredstreaming

import java.sql.Timestamp

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.window
import org.apache.spark.sql.functions._

object SparkStreamingKafkaToStructCaseClass {

  def main(args : Array[String]) = {


    val sparkSession = SparkSession .builder
                                    .appName("KafkaJOB")
                                    .master("local[*]")
                                    .getOrCreate

    import sparkSession.implicits._
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)
    //sparkSession.sparkContext.setLogLevel("ERROR")

    val ds = sparkSession .readStream
                          .format("kafka")
                          .option("kafka.bootstrap.servers", "localhost:9092")
                          .option("subscribe", "HDFS-TOPIC")
                          .load()


    //val values = ds.toDF("value", "timestamp")

    val query = ds        .writeStream
                        .queryName("KafkaData")
            .option("truncate","false")
            .format("memory").start()



    query.awaitTermination()



    Thread.sleep(5000)

    sparkSession.sql("SELECT * FROM KafkaData").show()


  }

}

case class KafkaData(key: String, value: String, partition: Int, offset : Long, timestamp : Timestamp, timestamptype: Int)