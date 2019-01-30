package com.dmac.atos


object AtosCurrying {

  def sum(a : Int, b : Int, c : Int ) = a+b+c

  def main(args: Array[String]): Unit = {

    //Constants.ANAG

    val parSum = sum(1, _:Int, 3)

    val output = parSum(2)


    //val currySum = (sum _).curried
    val currySum = sum _ curried

    val cs2 = currySum(1)

    val cs3 = cs2(4)(5)

    println(cs3)
  }

}
