package fp

/**
  *
  * class, trait, object - OOP
  *
  * Category Theory - Set Theory - FP - cats, scalaz
  *
  *
  * Semigroup - Combine (concatenates) two sets, associative law
  * Monoid - Semigroup + unit
  *
  * Monoid - combine + unit
  *
  *
  *
  *
  * x * y * z = (x * y) * z = x * (y * z)
  * 1 * 2 * 3 = * follows associative
  *
  *
  *
  *
  */
object SemigroupAndMonoid {

  def version125 : List[String] = List("1.25")
  def version32 : List[String] = List("3.2")
  def version41 : String = "4.1"


  def addSubstantialValidation() = {

  }

  def ++++() = {

  }


  def main(args : Array[String]) = {

    import cats.Monoid
    import cats.Semigroup
    import cats.syntax.semigroup._
    import cats.instances.string._
    import cats.instances.list._

    // Heterogenous types datastructures

    val bbentity = BBFormalValidationEntity("","")

    val combinedMonoid = Monoid[String].combine("NoSQL ", " CAP")

    val combinedMonoid2 = "NoSQL" |+| "CAP" |+| Monoid[String].empty


    val listMonoid = Monoid[List[String]].empty


    val cMonoid = version32 |+| version125 |+| Monoid[List[String]].empty


    println(cMonoid)
    println(combinedMonoid2)


  }
}


case class BBFormalValidationEntity(pod : String, date : String)

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