package fp

trait FactoryJob {

  def fileFactory() : Boolean


  def readFactory(filePath : String) : Boolean = {

    true
  }

}
