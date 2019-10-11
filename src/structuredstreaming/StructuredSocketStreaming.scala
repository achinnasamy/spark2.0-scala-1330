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
                      .option("port", "5555").load();


    val sdf = df.selectExpr("CAST(value AS STRING)")

    val query = sdf.writeStream.outputMode("append")
      .format("console").start


    query.awaitTermination
    



    //        StreamingQuery query = df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)").writeStream().outputMode("append")
    //                .format("console").start();





    //netcat
    // https://eternallybored.org/misc/netcat/

    // nc -lk 7777




  }
}
