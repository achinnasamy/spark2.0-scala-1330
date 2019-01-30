package com.dmac.atos

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * BestPractices for the Atos project
  *
  * Specify the `data` when creating a new `BestPractice`,
  * then access the fields like this:
  *
  * {{{
  * val bp = new BestPractice("DATA")
  * bp partialFunction
  * }}}
  *
  * Did you know: The [[com.dmac.atos.AtosUtils]] extends this class.
  *
  * @constructor Create a new BestPractice with `data`.
  * @param data The person's data.
  * @author Chinnasamy
  * @version 2.0
  * @since 1.0
  * @note
  *       Document the pre and post conditions
  * @example
  *       Provide an example of how the class is called or its usage
  * @todo Add more functionality.
  * @see See [[http://centillionlabs.com centillionlabs.com]] for more
  * information.
  */
class BestPractice(val data : String) {

  /**
    * @author Chinnasamy Subburayar
    */
  def partialFunction() = {

    val processPF: PartialFunction[String, String] = {

      case input: String if input.equals("AUA") => "ASA"

      case input: String if input.equals("UID") => "REFID"

      case default : String => default

    }


    val list = Seq("AUA", "UID", "REF", "ASAA")

    list.toList.collect(processPF).foreach(each => println(each))


    val one: PartialFunction[Int, String] = { case 1 => "ONE" }
    val two: PartialFunction[Int, String] = { case 2 => "TWO" }
    val three: PartialFunction[Int, String] = { case 3 => "THREE" }


    val mypartialfunction = one orElse two orElse three

    if (mypartialfunction isDefinedAt 2)
      println("Final Output : " + mypartialfunction(3))

  }


  /********
    *
    * Using the compose and andThen helpers
    *
    * @param input
    * @return
    */

  def convertStringToInt(input : String) : Int = {
    Integer.parseInt(input)
  }

  def convertIntToFloat(inputInteger : Int) : Float = {
    inputInteger.toFloat
  }

  def convertFloatToString(inputFloat : Float) : String = {
    inputFloat.toString
  }
  val convertStringToFloat =  convertStringToInt _ andThen convertIntToFloat _
  println(convertStringToFloat("1055"))


  /*********************************************************************************************************************************************************/



  def UsingtheTry() = {

    readTextFile("/Users/dharshekthvel/ac/code/input/auth.csv") match {
      case Success(lines) => lines.foreach(println)
      case Failure(f) => println(f)
    }

  }

  def readTextFile(filename: String): Try[List[String]] = {
    Try(Source.fromFile(filename).getLines.toList)
  }



}


