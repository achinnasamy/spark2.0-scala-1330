package fp

import org.apache.spark.rdd.RDD

trait FileSaverFactory {

  def saveFile(input : RDD[AuthDTO])

}
