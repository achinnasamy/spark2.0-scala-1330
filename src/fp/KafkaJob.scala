package fp

class KafkaJob extends FactoryJob  {

  def processKafkaJOB(topicName : String) = {
    println(topicName)
  }

  override def fileFactory(): Boolean = {
    true
  }
}
