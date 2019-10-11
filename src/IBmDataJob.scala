import scala.collection.mutable.ListBuffer

// OOP - Java - Objects
// OOP + Functional - Scala - functions
// Scala - Type Inferenced
// Scala - Expressive
// Scala - Favors Immutability
object IBmDataJob {


  implicit val floatValue = 167f


  def getMeRoundedNumberOfFloat(implicit anyFloatValue : Float) {
    println(anyFloatValue)


  }


  def main(args : Array[String]): Unit  = {

      logWarn("logging in spark")


    getMeRoundedNumberOfFloat

    watsonProcessor(postfix, "Martin", "Oderskey")

  }

  def logWarn(warningMessage : String) =
    println(s"Logging a warning message - " + warningMessage)



  def watsonProcessor(hofFN : (String, String) => String, first : String, second : String) = {
    hofFN(first, second)
  }



  def prefix(param1 : String, param2: String) : String = {
    val concatenated  = param1.concat(param2)

    concatenated
  }

  def postfix(param1 : String, param2: String) : String = {
    param2.concat(param1)
  }

}


case class AuthBeanDTO(refID : String, refName : String, aua : String, asa: String)













