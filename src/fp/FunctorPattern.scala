package fp

import cats.Functor
import cats.Functor.ToFunctorOps

object FunctorPattern {

  def main(args : Array[String]) = {

    import cats.instances.function._ // for Functor
    import cats.syntax.functor._     // for map
    import cats.instances.option._
    import cats.instances.list._

    implicit class FunctorOps[F[_], A](src: F[A]) {
      def map[B](func: A => B)
                (implicit functor: Functor[F]): F[B] =
        functor.map(src)(func)
    }

    val contract = new ContractData


    val fo = new FunctorOps[List, CONTRACT](List(CONTRACT(1,"")))

    import cats.Semigroupal._
    import cats.syntax.apply._
    //val data = (1, "BDDF").map2(CONTRACT.apply)


  }
}

case class CONTRACT(id : Int, data: String)
case class TIMELINE(id : Int, data: String)

class ContractData {


  def processData(contract : CONTRACT) = {

  }
}
