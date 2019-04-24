package lectures.part3fp

object HofsAndCurries extends App {

  //High Order Function Map, FlatMap, Filter
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int, Int) = null

  //function that applies another function
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))


  //Curried function
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(3))
  println(superAdder(3)(10))

  //functions with multiple parameters list
  def curriedFormater(c: String)(x: Double): String = c.format(x)
  val standarFormat: (Double => String) = curriedFormater("%4.2f")
  val preciseFormat: (Double => String) = curriedFormater("%10.8f")

  println(standarFormat(Math.PI))
  println(preciseFormat(Math.PI))



}
