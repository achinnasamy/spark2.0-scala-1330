package fp

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import scala.util.{Failure, Success, Try}

case class StringOps(input: String) {

  def getDoubleValue: Double = {
    Try(input.toDouble) match {
      case Success(s) => s
      case Failure(f) => 0.0
    }
  }

  def getIntValue: Int = {
    Try(input.toInt) match {
      case Success(s) => s
      case Failure(f) => 0
    }
  }

  def getBooleanValue: Boolean = {
    input match {
      case "N" => false
      case "S" => true
      case _ => false
    }
  }

  def getOptionalInt: Option[Int] = {
    try {
      Some(input.toInt)
    } catch {
      case e: NumberFormatException => None
    }
  }

  def getOptionalDouble: Option[Double] = {
    try {
      Some(input.toDouble)
    } catch {
      case e: NumberFormatException => None
    }
  }

  def isInt: Boolean = {
    try {
      input.toInt
      true
    } catch {
      case e: NumberFormatException => false
    }
  }

  def isNumber: Boolean = {
    try {
      input.toDouble
      true
    } catch {
      case e: NumberFormatException => false
    }
  }

  def isFloat: Boolean = {
    try {
      input.toFloat
      true
    } catch {
      case e: NumberFormatException => false
    }
  }

  def getDateOfFormat: Option[LocalDate] = {
    try {
      Some(LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
    } catch {
      case e: Exception => None
    }
  }

  def validateDateFormat: Boolean = {
    Try {DateTimeFormatter.ofPattern("dd/MM/yyyy").parse(input)
    } match {
      case Success(_) => true
      case Failure(_) => false
    }
  }
}
