//package reflection
//
//import scala.reflect.runtime.{universe => ru}
//
//object MarchForthClassFactory {
//
//
//  /** Get an instance of a given class
//    *
//    * USAGE:
//    * val myClass = ClassFactory.GetClassInstance[org.whatever.MyClass]
//    *
//    * @tparam T The FQCN of the class to get an instance of
//    * @return Returns a new instance of type T
//    */
//  def fetchClassInstance[T: ru.TypeTag] : T = {
//
//    val m = ru.runtimeMirror(getClass.getClassLoader)
//    val clazz = ru.typeOf[T].typeSymbol.asClass
//    val cm = m.reflectClass(clazz)
//    val constructor = ru.typeOf[T].decl(ru.termNames.CONSTRUCTOR).asMethod
//    val constructorMethod = cm.reflectConstructor(constructor)
//    constructorMethod().asInstanceOf[T]
//  }
//
//  def main(args: Array[String]): Unit = {
//
//    val enel = MarchForthClassFactory.fetchClassInstance[com.dmac.EnelTestSuite]
//    println(enel.fetchData())
//
//  }
//}
//
