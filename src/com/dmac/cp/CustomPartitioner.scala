package com.dmac.cp

import org.apache.spark.Partitioner
import org.apache.spark.sql.SparkSession

object CustomPartitioner {


  def main(args: Array[String]) = {

    val ss = SparkSession.builder()
                         .appName("IBMJob")
                         .master("local[*]")
                         .getOrCreate()


    val sc = ss.sparkContext

    val textFileRDD = sc.textFile("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")


    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")

      (columns(2), columns(4))
    })


    val partitionedRDD = mappedRDD.partitionBy(new AUAPartitioner)

    partitionedRDD.mapPartitionsWithIndex( (partitionIndex, dataIterator) => {
        dataIterator.map(dataInfo =>
            if (partitionIndex==26) {
                println(dataInfo._1 + dataInfo._2)
            }
        )

    })


    partitionedRDD.saveAsTextFile("/dir")

    mappedRDD.foreach(each => println(each._1 + "  " + each._2))


  }
}

class AUAPartitioner extends Partitioner {

  override def numPartitions: Int = 90

  override def getPartition(key: Any): Int = {

    val auaKey = key.asInstanceOf[String]

    if (auaKey.equals("340000")) 78
    else if (auaKey.equals("740000")) 26
    else 30

  }
}