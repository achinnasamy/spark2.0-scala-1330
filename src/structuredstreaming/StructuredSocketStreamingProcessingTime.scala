package structuredstreaming

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.Trigger

object StructuredSocketStreamingProcessingTime {

  def main(args : Array[String]) = {


    import org.apache.log4j.{Level, Logger}
    Logger.getLogger("org").setLevel(Level.OFF)

    val sparkSession = SparkSession.builder
      .appName("SocketJOB").master("local[*]").getOrCreate


    val df = sparkSession.readStream
                          .format("socket")
                          .option("host","localhost")
                          .option("port", "1234").load();


    val query = df.writeStream
                  .outputMode("append")
                  .trigger(Trigger.ProcessingTime("1 seconds"))
                  .format("console").start


    //Trigger.Once()
    //Trigger.ProcessingTime("1 minute")
    //Trigger.ProcessingTime()



    query.awaitTermination
  }
}
