package com.dmac.scala_programming

object ReduceFoldScan {

  def main(args: Array[String]) = {




    def add(x:String, y:String): String = {
      x.concat(" - " + y)
    }

    val noSQLList = List("cassandra",
                         "hbase",
                         "cloudant", "redis", "memcache")



    val reduceLeftResult = noSQLList.reduceLeft(add)
    println(reduceLeftResult)

    val foldLeftResult = noSQLList.foldLeft("z")(add)
    println(foldLeftResult)


    val scanLeftResult = noSQLList.scanLeft("z")(add)
    println(scanLeftResult)


    // Package object behave like global variables and methods when imported

    import sqladvanced.PACKAGE_OBJECT._
    echo(CASE_FACTOR)



  }
}
