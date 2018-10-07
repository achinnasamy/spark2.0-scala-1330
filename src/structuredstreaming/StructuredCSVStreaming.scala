package structuredstreaming

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.OutputMode
import org.apache.spark.sql.types.{DataTypes, StructField, StructType}

object StructuredCSVStreaming {

  def main(args : Array[String]) = {

    import org.apache.log4j.{Level, Logger}
    Logger.getLogger("org").setLevel(Level.OFF)

    val sparkSession = SparkSession.builder
      .appName("SocketJOB")
      .master("local[*]").getOrCreate


    val structType = new StructType().add("auth_code",DataTypes.StringType, true)
      .add("sa",DataTypes.IntegerType, true)
      .add("ver",DataTypes.StringType, true)


    val df = sparkSession
            .readStream
            .schema(structType)
            .option("header","true")
            .csv("/Users/dharshekthvel/ac/code/input")



    val query = df.writeStream.outputMode(OutputMode.Append())
                  .format("console").start


    query.awaitTermination

  }
}
