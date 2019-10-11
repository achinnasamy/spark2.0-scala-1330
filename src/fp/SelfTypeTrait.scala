package fp

object SelfTypeTrait {


}


class RedisDataStore extends RedisCache with RedisConnectionPool {

}

trait RedisCache {

  this: RedisConnectionPool =>

  def fetchCache() = {
    "HASHES"

    // Use connectionPool here
    connectionPool
  }

}


trait RCache extends RedisConnectionPool {

  def fetchCache() = {
    connectionPool
  }
}

trait RedisConnectionPool {

  def connectionPool = ConnectionPool("slz_zone3", "NMxy67534uutyu##4444d")
}


case class ConnectionPool(username: String, password: String)

