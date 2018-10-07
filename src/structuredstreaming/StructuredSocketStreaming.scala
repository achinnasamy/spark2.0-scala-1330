package structuredstreaming

import org.apache.spark.sql.SparkSession

object StructuredSocketStreaming {

  def main(args : Array[String]) = {

    import org.apache.log4j.{Level, Logger}
    Logger.getLogger("org").setLevel(Level.OFF)

    val sparkSession = SparkSession.builder
      .appName("SocketJOB")
      .master("local[*]").getOrCreate


    val df = sparkSession.readStream
      .format("socket")
      .option("host","localhost")
      .option("port", "7777").load();

    //        StreamingQuery query = df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)").writeStream().outputMode("append")
    //                .format("console").start();


    val query = df.writeStream.outputMode("append")
                  .format("kafka").start


    //netcat
    // https://eternallybored.org/misc/netcat/

    // nc -lk 7777


    query.awaitTermination

  }
}
