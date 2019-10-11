package designpattern

//Type Enrichment also called as Pimp-My-Library
object TypeEnrichment {

  implicit def fetchContractsApplied(contract : String) = new ReckonContractsString(contract)

  def main(args : Array[String]) = {
    println("Pimp-My-Library")

    println("Input DATA"._contractApplier)
  }
}


class ReckonContractsString(string: String) {

  def _contractApplier = "__APPLIED__" + string + "__CONTRACTS__"

}
