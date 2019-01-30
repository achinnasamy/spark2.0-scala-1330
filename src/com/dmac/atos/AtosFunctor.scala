package com.dmac.atos

object AtosFunctor {

  def main(args: Array[String]): Unit = {

    implicit val demoFunctor = new Functor[BoxContainer] {
      override def map[A, B](fa: BoxContainer[A])(f: A => B): BoxContainer[B] = {
        BoxContainer(f(fa.firstData), f(fa.secondData))
      }
    }

    val boxContainer = new BoxContainer("", "")
    val mapped = demoFunctor.map(boxContainer)(_.concat("_CON"))




  }
}


case class BoxContainer[A](firstData : A, secondData : A)

trait Functor[F[_]] {
  def map[A,B](fa: F[A])(f: A => B) : F[B]
}

