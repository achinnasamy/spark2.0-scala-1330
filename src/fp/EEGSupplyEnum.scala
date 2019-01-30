package fp

object EEGSupplyEnum extends Enumeration {

  type EEGSupplyEnum = Value

  final val tipoRecord = Value("TIPO_RECORD")
  final val tipoRecordAlt = Value("TIPO_RECORD_ALT")
  final val giornoOperazione = Value("GIORNO_OPERAZIONE")
  final val processNext = Value("PROCESSO_NEXT")

}