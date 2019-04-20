package lectures.part1basics

object ValuesVariablesTypes extends App {

  //vals are inmutable also declared:  val x = 4 2
  val x: Int = 42
  println(x)

  val aString: String = "Hello"
  val anotherString = "Goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val aInt: Int = x;
  val aShort: Short = 4321
  val aLong: Long = 98748843
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables in the scala
  var aVariable: Int = 34
  aVariable = 5 //side effects  on functional
  
}
