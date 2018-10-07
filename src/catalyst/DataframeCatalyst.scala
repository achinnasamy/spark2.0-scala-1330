package catalyst

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

object DataframeCatalyst {

  def main(args : Array[String]) = {

    val config = new SparkConf
    config.setMaster("local")
    config.setAppName("JOB")

    val sc = new SparkContext(config)

    val sqlContext = new SQLContext(sc)


    val rdd = sqlContext.sparkContext.makeRDD(List(("hi","1")))

    val dataFrame = sqlContext.createDataFrame(rdd)

    val selectedDataFrame = dataFrame.select("_1")

    selectedDataFrame.explain(true)

  }
}
