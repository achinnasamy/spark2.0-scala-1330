package fp

import org.apache.spark.sql.SparkSession


object IBMReckoner {

  def main(args : Array[String]): Unit = {

    import org.apache.spark.{SparkConf, SparkContext}

    val sparkSession = SparkSession.builder()
                                   .appName("EnelJob")
                                   .master("local[*]")
                                   .getOrCreate()


    val sc = sparkSession.sparkContext

    val textFileRDD = sc.textFile("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")

    val pipeRDD = textFileRDD.pipe("ls -lart")
    //pipeRDD.foreach(each => println(each))

    textFileRDD.sample(true, 0.2)

    textFileRDD.distinct()

    textFileRDD.union(textFileRDD)

    textFileRDD.intersection(textFileRDD)

    textFileRDD.cartesian(textFileRDD)

    textFileRDD.repartition(30)
    textFileRDD.coalesce(30) // better to use this


    textFileRDD.foreach(each => println(each))
    //textFileRDD.foreach(println)
    //textFileRDD.foreach(println(_))

    sc.stop()


  }
}

case class AuthDTO(refID: String, aua:String, asa : String)

