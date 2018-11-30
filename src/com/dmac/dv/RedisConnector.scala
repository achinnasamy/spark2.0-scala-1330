package com.dmac.dv

object RedisConnector {


  def main(args : Array[String]) = {

    val func = new scala.Function1[String, String] {
      override def apply(v1: String): String = v1
    }

    val list = List("mongodb", "nosql")

    list.map(each => each)

    list.map(new scala.Function1[String, String] {
      override def apply(v1: String): String = v1
    })

    list.map(func)

  }

}

class RedisReckoner {

}
