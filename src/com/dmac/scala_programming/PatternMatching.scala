package com.dmac.scala_programming

object PatternMatching {


  def main(args : Array[String]) = {

    println(fetchMeData(Auth_DTO("1982","1330","76")))
  }


  def fetchMeData(data : Any): Any = {

    val output = data match {
      case data_match : Int => 100
      case data_match : String => 100
      case data_match : Auth_DTO => Auth_DTO("123456", "17800", "1600")
      case _ => "Invalid"


    }

    output
  }

}

case class Auth_DTO(refID : String, aua : String, asa : String)