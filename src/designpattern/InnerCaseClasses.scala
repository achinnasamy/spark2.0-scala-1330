package designpattern


/**
  * Also called Inner-Types or Path-Dependent Types
  * @param session
  */
case class RedisSession(session : String) {

  case class RedisHashData(data: String) {

  }

  val allSessions = scala.collection.mutable.Buffer[RedisHashData]()

}
