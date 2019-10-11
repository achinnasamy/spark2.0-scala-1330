package fp

class TransformatorData {


  def processData(dataList : List[String]) = {

    val mappedList = dataList.map(each => each.toUpperCase)
    mappedList.foreach(each => println(each))


    val kafkaJob = new KafkaJob with KafkaLogger
    kafkaJob.fileFactory()

    kafkaJob.logMeInsideKafkaTopic()
  }
}
