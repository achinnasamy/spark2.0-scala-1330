package typesystem

object CovariantContravariantInvariant {


  def main(args: Array[String]) = {


    //val container = new Container[Derived](base)


  }

}


class Container[+A] {

  def addContainer[U >: A](input : U) = {

  }
}