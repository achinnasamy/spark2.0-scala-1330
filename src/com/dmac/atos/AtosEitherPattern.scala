package com.dmac.atos

object AtosEitherPattern {

  type AuthResult = Either[BiometricData, IrisData]

  def fetchDataResult(input : Int) : AuthResult = {

    if (input == 0)
      Left(BiometricData("hand-biometric"))
    else
      Right(IrisData("iris"))

  }


  def main(args : Array[String]) = {

    val output = fetchDataResult(1)

    output.isRight
    println(output.right.get.data)

  }
}

final case class BiometricData(data : String)

final case class IrisData(data : String)
