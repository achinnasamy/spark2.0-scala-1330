package com.dmac.dv

import org.apache.http.auth.AUTH


object IBMDataReckonerJOB {


//  def processData(data : String) : Option[AUTH] = {
//
//     if (data.equals("CASSANDRA"))
//        Some(AUTH)
//     else None
//
//  }

  def main(args : Array[String]) = {

    val noSQList = List("nosql", "stardog", "couchdb")

    val noSQList2 = List("mongodb", "hbase", "cassandra")

    noSQList.head

    val returnSet = noSQList.tail

    noSQList.take(10)

    noSQList.drop(10)

    noSQList.find(each => each.startsWith("zz"))

    noSQList.count(each => each.startsWith("s"))

    val ziippedList = noSQList.zip(noSQList2)

    ziippedList.foreach(each => println(each._1))

    noSQList.zipWithIndex

    val pList = noSQList.partition(each => each.startsWith("s"))

    pList._1.foreach(each => println(each))







    import ImplicitClassesFeature._

    val redis = 1001

    redis.letMoonBeAddedToString("")
    redis.ibmIsDoingGood()


    println("Test")
  }

}

object ImplicitClassesFeature {


  implicit class AddFunctionalityToString(val input: Int) {

    def letMoonBeAddedToString(data : String) : String = {
      "DATA_RETURNED"
    }

    def ibmIsDoingGood() = {

    }
  }


}

