object FeatureOnImpicit {

  def main(args : Array[String]) = {


    //import ImplicitClasses._
    val data = "IBM"


  }
}



object ImplicitClasses {


  implicit class AddingMoreFunctionalityToString(val input: String) {

    def letMoonBeAddedToString(): String = {
      input.concat("MOON")
    }

    def letGBISBeGod() = {

    }

  }

}
