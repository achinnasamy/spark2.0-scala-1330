import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object FileUtility {


  def main(args : Array[String]) = {


    val conf = new SparkConf()
    conf.setMaster("local[*]")
    conf.setAppName("IBMWatsonJOB")

    val sparkContext = new SparkContext(conf)

    val textFileRDD = sparkContext.textFile("auth.csv")


    textFileRDD.persist(StorageLevel.MEMORY_ONLY_2)

    textFileRDD.persist(StorageLevel.DISK_ONLY_2)

    textFileRDD.persist(StorageLevel.MEMORY_AND_DISK_2)

    textFileRDD.persist(StorageLevel.MEMORY_AND_DISK_SER_2)

    textFileRDD.persist(StorageLevel.OFF_HEAP)

    textFileRDD.unpersist()

  }


}

