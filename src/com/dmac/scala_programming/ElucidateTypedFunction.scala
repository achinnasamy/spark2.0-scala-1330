package com.dmac.scala_programming

object ElucidateTypedFunction {


  def main(args : Array[String]) = {

    computeDataFrontier(Contract("contract_input_data"))

  }

  def computeDataFrontier[T](input : T) = {

    input match {
      case i : Contract => println("Process for Contract")
      case i : TimeLine => println("Process for Timeline")
      case i : String => println("Process for String")
      case _ => println("Invalid input")
    }
  }

}


case class Contract(contractData : String)

case class TimeLine(timeLineData : String)



