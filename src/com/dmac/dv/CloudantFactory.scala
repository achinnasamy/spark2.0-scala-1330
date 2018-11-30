package com.dmac.dv

object CloudantFactory {

  def main(args : Array[String]) = {


    val list = List(1,2,3,4,5)

    list.reduceLeft((x,y) => x + y)
    list.foldLeft(0)((x,y) => x + y)




  }
}
