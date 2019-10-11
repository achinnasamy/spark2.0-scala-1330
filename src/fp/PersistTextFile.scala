package fp
import org.apache.spark.rdd.RDD

class PersistTextFile extends FileSaverFactory {

  override def saveFile(input: RDD[AuthDTO]): Unit = {
    input.saveAsTextFile("/Users/fileSave")
  }
}
