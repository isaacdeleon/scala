package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESION
  println(x)

  println(2 + 3 * 4)
  println(1 == 2)
  println(!(1 == x))

  var aVariable = 2
  aVariable += 3 // side effect
  println(aVariable)

  // instrucction (DO) vs Expresions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionalValue = if (aCondition) 5 else 3 //IF EXPRESION
  println(aConditionalValue)

  //WRONG WAY OF ITERATE
  var i = 0
  var aWhile = while (i < 10) {
    println(i)
    i += 1
  }


  // everything of scala is in expression
  val aWeirdValue = (aVariable = 3) // UNIT === void
  println(aWeirdValue)

  //side effect: println(), whiles , reassigning and return UNit

  //Code blocks is an expresion
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "GoodBye"
  }

  println(aCodeBlock)

  // difference between "hello world" vs println("hello world")
  //

  val someValue = {
    2 < 3
  }

  println(someValue)

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(42)
}
