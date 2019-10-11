package com.dmac.atos

import java.io.{BufferedInputStream, File, FileInputStream}

object ExceptionHandler {


  def main(args : Array[String]) = {

    try {

      val file = new BufferedInputStream(
                new FileInputStream("auth.csv"))

    }
    catch {
      case ex: Exception =>{
        println(ex)
      }

    }
    finally {

    }

  }
}
