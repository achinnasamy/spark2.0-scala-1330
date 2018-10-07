package com.dmac.dv

class IBMDataReckoner {



  def processData(data: String, id : Int) : String  = {

    import scala.io._
    val list = List("")

    val integerList = List(1,2,3,4,5)

    list.foreach(each => println(each))
    list.foreach(println)
    list.foreach(println(_))


    list.map(each => each.toUpperCase)
    list.map(_.toUpperCase)

    integerList.reduce((x,y) => x + y)
    integerList.reduce(_+_)


    println(data)
    println(id)

    "BLOCK_CHAIN"
  }

  def processDB(data: String) : String  = {

    println(data)


    "BLOCK_CHAIN"
  }

}
