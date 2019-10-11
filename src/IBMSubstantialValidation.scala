

object IBMSubstantialValidation {

  def main(args : Array[String]) = {

    val outData = processData(Some(1000))

    outData.isEmpty
    outData.getOrElse("")
  }

  def processData(id : Option[Int]) : Option[AuthDTO] = {

    if (id.get == 1000)
      Some(AuthDTO("79000"))
    else
      None
  }

}

case class AuthDTO(aua : String)