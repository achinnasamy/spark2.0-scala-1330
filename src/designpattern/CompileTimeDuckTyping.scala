package designpattern

/**
  * Functions as Structural Types
  *
  * Compile-Time Duck Typing Pattern or Structural Type
  * The main difference is that it is a type safe, static typed implementation checked up at compile time.
  * This means that you can create a function (or method) that receives an expected duck
  *
  */
object CompileTimeDuckTyping {

  def computeData(fetchModel : { def reckonModel(input:String) : String }) = {
      val returnValue = fetchModel.reckonModel("input_data")
      println(returnValue)
  }

  def main(args : Array[String]) = {
    computeData(RCTData)
    computeData(new RCTDataComponent)
    println("")
  }
}


class RCTDataComponent {

  def reckonModel(input:String) = {
    "RCT computed " + input
  }

}

object RCTData {

  def reckonModel(input:String) = {
    "RCT computed " + input
  }

}


object AvoxData {

  def reckonModel(input:String) = {
    "RCT computed " + input
  }

}

object DandBData {

  def reckonModel(input:String) = {
    "DandB computed " + input
  }

}