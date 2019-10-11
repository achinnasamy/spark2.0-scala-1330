import org.apache.spark.sql.SparkSession
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object IBMReckonerDataJob {

  def main(args: Array[String]) = {



    val ss = SparkSession.builder()
                .appName("IBMReckonerJOB")
                .master("local[*]")
                .getOrCreate()


    ss.conf.set("spark.debug.maxToStringFields", 200)
//    ss.read.orc()
//    ss.read.json()
//    ss.read.parquet()

    val csvDF = ss.read.option("header", "true").csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")

    val df = csvDF.select("auth_code", "aua", "asa")

    df.createOrReplaceTempView("AUTH")


    //ss.sql("SELECT aua,asa, TRANSFORM(asa, asa) asa_computed from AUTH").show()

    ss.sql("SELECT *  from AUTH").show()
    //df.show(10)



  }
}