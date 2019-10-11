package sqladvanced

import org.apache.spark.sql.types.{DataTypes, StructField, StructType}
import org.apache.spark.sql.{SparkSession, functions}

object SQLSparkGroupBy {

  def main(args : Array[String]) = {

    val toDouble    = functions.udf[Double, String]( _.toDouble)


    val sparkSession = SparkSession
      .builder()
      .appName("SparkSQLJOB")
      .master("local[*]")
      .getOrCreate()


    val csvDF = sparkSession.read
                            .option("header", "true")
                            .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")


    //csvDF.printSchema()

    csvDF.createOrReplaceTempView("AUTH_TABLE")

    /******************************************************/
      // groupBy
    /******************************************************/
    //csvDF.groupBy("asa").count().show()


    /******************************************************/


    //sparkSession.sql("select * from AUTH_TABLE")





    /******************************************************/
    //groupBy with aggregate function SUM

    val modifiedDF = csvDF.withColumn("asa", toDouble(csvDF.col("asa")))
    //modifiedDF.printSchema()
    val aggregatedDF = modifiedDF.groupBy("auth_code").sum("asa")
    //aggregatedDF.show()

    /******************************************************/




    /******************************************************/
    /** Loading the data using the struct type           **/

    val structType = new StructType().add("auth_code",DataTypes.StringType, true)
              .add("sa",DataTypes.IntegerType, true)
              .add("ver",DataTypes.StringType, true)


    val csvWithStructDF = sparkSession.read
      .option("header", "true")
      .schema(structType)
      .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")


    //csvWithStructDF.printSchema()

    /******************************************************/




    /**********************************************************************************************************/


      val mapType =
                    StructType(
                      StructField("auth_code", DataTypes.createMapType(DataTypes.StringType,DataTypes.StringType),false) :: Nil
                    )
    /**********************************************************************************************************/

    val csvWithStructMapDF = sparkSession.read
      .option("header", "true")
      .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")


    sparkSession.sql("SELECT AUTH_CODE FROM AUTH_TABLE")
      .write
      .parquet("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/parqueout")


    /**********************************************************************************************************/
    //merge schema
    /**********************************************************************************************************/

//    val schema1DF=sparkSession.sparkContext.makeRDD(1 to 5).map(i=>(i,i*i)).toDF("value","square")
//  schema1DF.write.parquet("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/parqueout/key=1")
//  val schema2DF=sparkSession.sparkContext.makeRDD(6 to 10).map(i=>(i,i*i*i)).toDF("value","cube")
//  schema2DF.write.parquet("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/parqueout/key=2")
//  val mergedDF = sparkSession.read.option("mergeSchema", "true").parquet("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/parqueout")
//  mergedDF.printSchema()


    /**********************************************************************************************************/

  }

}


package object PACKAGE_OBJECT {


  val CASE_FACTOR = "CASE_FACTOR"

  def echo(message : String) = {
    println(message)
  }


  implicit def enrichStringWithMethod(s : String) = {
    s.concat("_DATA_ENRICHED")
  }

  XML("DATA").printFileName()



  def functionWithOptionParameter(data : String, id : Int, chain : Option[String] = None) = {
    println(data + " - " + id + " - " + chain )
  }

  /**
    *
    * trait as a enum.
    * Make it as a sealed trait and extend case object
    */
  sealed trait FileFactory

  case object XMLFILE extends FileFactory
  case object CSVFILE extends FileFactory

  def ^ (ff : FileFactory) : String = {
    ff match {
      case XMLFILE => "XmlFile"
      case CSVFILE => "CsvFile"
      case _ => "AllFiles"
    }
  }


}



/** Case classes can extend Classes and Abstract Classes **/
abstract class Factory {

  def printFileName() = {

  }

}


case class XML(data : String) extends Factory
case class CSV(data : String) extends Factory
