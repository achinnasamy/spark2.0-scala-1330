package fp
import org.apache.spark.rdd.RDD

class PersistObjectFile extends FileSaverFactory {
  override def saveFile(input: RDD[AuthDTO]): Unit = {
    input.saveAsObjectFile("/new/dir/path")
  }
}
