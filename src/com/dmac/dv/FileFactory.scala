package com.dmac.dv

class FileFactory extends Logger {


}


trait Logger {

  def logMeInHDFS() = {
    println("Logged In HDFS")
  }
}