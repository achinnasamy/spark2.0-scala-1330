package catalyst

class JsonFileImpl extends AbstractFileFactory {

  override def fetchFileName(): String = {

    "enel.json"
  }

  override def readInputFile(): String = {


    "content of enel_json"
  }
}
