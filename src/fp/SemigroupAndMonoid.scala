package fp


object SemigroupAndMonoid {

  def version125 : List[String] = List("1.25")
  def version32 : List[String] = List("3.2")
  def version41 : String = "4.1"

  def main(args : Array[String]) = {


    import cats.Monoid
    import cats.syntax.semigroup._
    import cats.instances.string._
    import cats.instances.list._

    val combinedMonoid = Monoid[String].combine("NoSQL ", " CAP")
    val combinedMonoid2 = "NoSQL" |+| "CAP" |+| Monoid[String].empty

    val listMonoid = Monoid[List[String]].empty



    val cMonoid = version32 |+| version125 |+| Monoid[List[String]].empty


    println(cMonoid)
    println(combinedMonoid2)


  }




}

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}


abstract class ContractTest(versionsToTest : List[String]) extends AbstractRuleTest(versionsToTest : List[String])

class RuleTest(versionsToTest : List[String]) extends ContractTest(versionsToTest : List[String]) {



}

abstract class AbstractRuleTest(versionsToTest : List[String])