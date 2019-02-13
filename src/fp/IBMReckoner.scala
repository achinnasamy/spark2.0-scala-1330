package fp



import structuredstreaming.IBMDataElucidator

import scala.io._


object IBMReckoner {

  // Functional Language
  // Concise Language - Less Verbose
  // Type Inferences
  // Expressive
  def main(args : Array[String]): Unit = {


    import ImplicitClassesFeature._

    val input = "DATA"

    input.letMoonBeAddedToString()
    input.ibmProcessesStringInHyperledger()

    val dataList = List("nosql", "data")

    dataList.map(each => each.toUpperCase)


    dataList.map(new Function[String,String] {
      override def apply(v1: String): String = {
        v1.toUpperCase
      }
    })



  }


}

object ImplicitClassesFeature {

  implicit class AddFunctionalityToString(val input: String)
  {

    def letMoonBeAddedToString() : String =
      input.concat("MOON" )

    def ibmProcessesStringInHyperledger() = {

    }
  }
}
