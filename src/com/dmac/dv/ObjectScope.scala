package com.dmac.dv

object ObjectScope {

  def main(args: Array[String]) = {

    Constants.ANAG

  }



}


protected[this] object Constants{

  val TYPE_RECORD_FIELD: Int = 6

  val ID_CRM_ANAG_FIELD: Int = 81

  val ID_CRM_CC_FIELD: Int = 51

  val NO_LIMIT: Int = -1

  val ANAG: String = "ANAG" : String

  val CC_PDR = "CC_PDR" : String

  val CC_SITO: String = "CC_SITO"

  val SOURCE_PATH = "read_input_path.input"

  val DESTINATION_PATH = "read_input_path.output"

  val ImmutableQueuePath = "immutable_events_path"


}
