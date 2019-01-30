package sqladvanced

import org.apache.spark.sql.SparkSession

object Spark24HigherOrderFunctions {

  def main(args : Array[String]) = {



    val sparkSession = SparkSession
      .builder()
      .appName("SparkSQLJOB")
      .master("local[*]")
      .getOrCreate()


    val csvDF = sparkSession.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv("/Users/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")


    csvDF.createOrReplaceTempView("AUTH_TABLE")


    // Reverse
    //val allColumnDF = sparkSession.sql("SELECT aua, reverse(aua) FROM AUTH_TABLE")

    // Repeat
    //val allColumnDF = sparkSession.sql("SELECT aua, array_repeat(aua, 3) FROM AUTH_TABLE")


    //val allColumnDF = sparkSession.sql("SELECT aua, filter(aua, x -> x = \'49\') FROM AUTH_TABLE")


    // Concat
    //val allColumnDF = sparkSession.sql("SELECT ver, subreq_id, concat(ver, subreq_id) FROM AUTH_TABLE")

    // Concat
    //val allColumnDF = sparkSession.sql("SELECT ver, subreq_id, array_distinct(ver, subreq_id) FROM AUTH_TABLE")

    // Convert a column to an array
    //val allColumnDF = sparkSession.sql("SELECT array(ver) FROM AUTH_TABLE")

    //val allColumnDF = sparkSession.sql("SELECT zip_with(array(ver),array(subreq_id),(x, y) -> x + y) FROM AUTH_TABLE")
    //allColumnDF.rdd.foreach(each => println(each.getAs[String](0)))


    // Image datasource is in the machine learning module.
    // So add that dependency to it
    val imageDF = sparkSession.read.format("image").option("dropInvalid", true)
      .load("/Users/dharshekthvel/ac/images_dataset/")


    imageDF.select("image.origin", "image.width",
                                               "image.height","image.nChannels","image.mode","image.data").show(truncate=false)

    // Barrier Mode Execution
    //imageDF.rdd.barrier().mapPartitions()

    //allColumnDF.show


    println("Done")

  }
}


//+--------------------+---------+----------+----------+----+---+------+-------------+-------------------+-------------+--------+-------------------+-------+------------+------------+-------------+-------------+----------------+----------------+----------------+-------------+-------------+------------+------------+-------------+-------------+----------------+----------------+----------------+-------------+-------------+--------------------+----+-----------------+-----+-----+--------------+------------------+-----------+-----------+--------------------+------------------+------------------+-------------------+---------+----------------+----------+-----------------+-------+----------------+------+------------------+-----------+-----------+---------------+-------------------+------------+------------+---------------------+-----+---------------+------------------+-------------------+---------------+----------------+----------------+------+---------------+-----+--------------------+----------+-----------------+-------+------------------+--------+---------------+-----+---------+---------+---------+------------------+----------+--------+----------------------+-------------+---------------+--------------+---------------+-------------+---------------+--------------+---------------+-------------+---------------+--------------+---------------+-----------+----------+-------------+-------------------+-------------+----+----+------------------+--------+--------+-------------+-----------------+--------------+----------------+-------+--------------------+----------+-------------+---------------+--------------+----------+--------+-------+-----------+--------------------+------------------+-------------------+----------------+----------------+-------------+-------------+--------------+--------------+-------------------+--------------------+---------+--------+--------+----+-------------+--------------------+----------------------+----------------+--------------+------------------+--------------------+-------------+--------+---------+-----------+--------+--------------------+--------+
//|           auth_code|subreq_id|       aua|        sa| asa|ver|   tid|   license_id|       req_datetime|tkn_used_flag|tkn_type|             pid_ts|pid_ver|pi_uses_flag|pa_uses_flag|pfa_uses_flag|bio_uses_flag|bt_fmr_uses_flag|bt_fir_uses_flag|bt_iir_uses_flag|pin_uses_flag|otp_uses_flag|pi_used_flag|pa_used_flag|pfa_used_flag|bio_used_flag|bt_fmr_used_flag|bt_fir_used_flag|bt_iir_used_flag|pin_used_flag|otp_used_flag|      otp_identifier|lang|pi_name_used_flag|pi_ms|pi_mv|pi_match_score|pi_lname_used_flag|pi_lname_ms|pi_lname_mv|pi_lname_match_score|pi_phone_used_flag|pi_email_used_flag|pi_gender_used_flag|pi_gender|pi_dob_used_flag|    pi_dob|pi_dobt_used_flag|pi_dobt|pi_age_used_flag|pi_age|pfa_addr_used_flag|pfa_addr_ms|pfa_addr_mv|pfa_match_score|pfa_laddr_used_flag|pfa_laddr_ms|pfa_laddr_mv|pfa_laddr_match_score|pa_ms|pa_co_used_flag|pa_house_used_flag|pa_street_used_flag|pa_lm_used_flag|pa_loc_used_flag|pa_vtc_used_flag|pa_vtc|pa_po_used_flag|pa_po|pa_subdist_used_flag|pa_subdist|pa_dist_used_flag|pa_dist|pa_state_used_flag|pa_state|pa_pc_used_flag|pa_pc|fmr_count|fir_count|iir_count|finger_match_score|uidai_tfmr|aua_tfmr|finger_match_threshold|fmr_gall_type|fmr_gall_vendor|fmr_sdk_vendor|fmr_sdk_version|fir_gall_type|fir_gall_vendor|fir_sdk_vendor|fir_sdk_version|iir_gall_type|iir_gall_vendor|iir_sdk_vendor|iir_sdk_version|auth_result|error_code|error_classfn|      resp_datetime|auth_duration| fdc| idc|               udc|locn_lat|locn_lng|locn_vtc_code|locn_subdist_code|locn_dist_code| locn_state_code|locn_pc|          enr_ref_id|res_gender|res_birth_day|res_birth_month|res_birth_year|   res_dob|res_dobt|res_age|res_pincode|        res_vtc_code|      res_vtc_name|        res_po_name|res_subdist_code|res_subdist_name|res_dist_code|res_dist_name|res_state_code|res_state_name|       uid_gen_date|                 txn|auth_type|hash_uid|locn_alt| lot|bfd_done_flag|finger_matching_type|finger_fusion_perfomed|iris_match_score|iris_threshold|iris_matching_type|iris_fusion_perfomed|auth_xml_size|pid_size|data_type|skey_scheme|ssk_type|                  ki|kyc_flag|
//+--------------------+---------+----------+----------+----+---+------+-------------+-------------------+-------------+--------+-------------------+-------+------------+------------+-------------+-------------+----------------+----------------+----------------+-------------+-------------+------------+------------+-------------+-------------+----------------+----------------+----------------+-------------+-------------+--------------------+----+-----------------+-----+-----+--------------+------------------+-----------+-----------+--------------------+------------------+------------------+-------------------+---------+----------------+----------+-----------------+-------+----------------+------+------------------+-----------+-----------+---------------+-------------------+------------+------------+---------------------+-----+---------------+------------------+-------------------+---------------+----------------+----------------+------+---------------+-----+--------------------+----------+-----------------+-------+------------------+--------+---------------+-----+---------+---------+---------+------------------+----------+--------+----------------------+-------------+---------------+--------------+---------------+-------------+---------------+--------------+---------------+-------------+---------------+--------------+---------------+-----------+----------+-------------+-------------------+-------------+----+----+------------------+--------+--------+-------------+-----------------+--------------+----------------+-------+--------------------+----------+-------------+---------------+--------------+----------+--------+-------+-----------+--------------------+------------------+-------------------+----------------+----------------+-------------+-------------+--------------+--------------+-------------------+--------------------+---------+--------+--------+----+-------------+--------------------+----------------------+----------------+--------------+------------------+--------------------+-------------+--------+---------+-----------+--------+--------------------+--------+
//|95fe167618534c47b...|        1|    490000|0000490AWZ|1400|1.6|public| 0000490000:1|2015-06-03 00:00:04|            0|    null|2015-06-02 23:57:37|      1|           0|           0|            0|            0|               0|               0|               0|            0|            0|           0|           0|            0|            1|               1|               0|               0|            0|            0|                null|  23|                0| null| null|          null|                 0|       null|       null|                null|                 0|                 0|                  0|     null|               0|      null|                0|   null|               0|  null|                 0|       null|       null|           null|                  0|        null|        null|                 null| null|              0|                 0|                  0|              0|               0|               0|  null|              0| null|                   0|      null|                0|   null|                 0|    null|              0| null|        1|     null|     null|                62|      null|    null|                    42|          ISO|      Accenture|     Accenture|           v4.6|         null|           null|          null|           null|         null|           null|          null|           null|          y|      null|         null|2015-06-03 00:00:05|         1135|  NC|  NA|            DA0091|    null|    null|         null|             null|          null|            null| 462026|e1733d7d-64f1-4b1...|         M|            1|              1|          1963|  1/1/1963|       A|     52|     462010|         2.33203E+13|             Huzur|     Sikandri Sarai|          233202|           Huzur|         2332|       Bhopal|            23|Madhya Pradesh|2012-11-02 12:46:01|SUBAUAMBE14332697...|        F|      NA|    null|   P|            0|                 SUT|                     0|            null|          null|              null|                   0|         5393|     574|        X|          N|    null|                null|       0|
//|835cc94e920a40e19...|        1|    340000|SERVICEMON|1200|1.6|public| 0000340000:6|2015-06-03 00:00:03|            0|    null|2015-06-03 00:00:03|      1|           0|           0|            0|            1|               0|               0|               1|            0|            0|           0|           0|            0|            1|               0|               0|               1|            0|            0|                null|null|                0| null| null|          null|                 0|       null|       null|                null|                 0|                 0|                  0|     null|               0|      null|                0|   null|               0|  null|                 0|       null|       null|           null|                  0|        null|        null|                 null| null|              0|                 0|                  0|              0|               0|               0|  null|              0| null|                   0|      null|                0|   null|                 0|    null|              0| null|     null|     null|        1|              null|      null|    null|                  null|         null|           null|          null|           null|         null|           null|          null|           null|       NATIVE|             L1|            L1|QSSEngine2.0.27|          y|      null|         null|2015-06-03 00:00:05|         1405|  NC|  NC| AUTHMON-Prod-GNDC|    null|    null|         null|             null|          null|            null| 560103|df56b62e-7ce5-470...|         M|           29|             11|          1984|11/29/1984|       V|     30|     305624|          8.2105E+12|             Baral|         Bijainagar|           82105|          Masuda|          821|        Ajmer|             8|     Rajasthan|2013-02-09 04:06:05|UASMON:0000340000...|        I|      NA|    null|   P|            1|                null|                     0|     122.7005428|            42|               SUT|                   0|        38187|   25884|        X|          N|    null|                null|       0|
//|92ddd4ad42ca4ec8b...|        1|    340000|SERVICEMON|1200|1.6|public| 0000340000:6|2015-06-03 00:00:06|            0|    null|2015-06-03 00:00:05|      1|           0|           0|            0|            1|               0|               0|               1|            0|            0|           0|           0|            0|            1|               0|               0|               1|            0|            0|                null|null|                0| null| null|          null|                 0|       null|       null|                null|                 0|                 0|                  0|     null|               0|      null|                0|   null|               0|  null|                 0|       null|       null|           null|                  0|        null|        null|                 null| null|              0|                 0|                  0|              0|               0|               0|  null|              0| null|                   0|      null|                0|   null|                 0|    null|              0| null|     null|     null|        1|              null|      null|    null|                  null|         null|           null|          null|           null|         null|           null|          null|           null|       NATIVE|             L1|            L1|QSSEngine2.0.27|          n|       300|         null|2015-06-03 00:00:06|          375|  NC|  NC|AUTHMON-PRODBDC-01|    null|    null|         null|             null|          null|            null| 560103|df56b62e-7ce5-470...|         M|           29|             11|          1984|11/29/1984|       V|     30|     305624|          8.2105E+12|             Baral|         Bijainagar|           82105|          Masuda|          821|        Ajmer|             8|     Rajasthan|2013-02-09 04:06:05|UASMON:0000340000...|        I|      NA|    null|   P|            1|                null|                     0|             0.0|            42|               SLT|                   0|         6656|    2230|        X|          N|    null|                null|       0|
