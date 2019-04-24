package lectures.part3fp

object AnonymousFunctions extends App {

  //anonymous function(LAMBDA) one param
  val doubler: Int => Int = x => x * 2

  //multiple params
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //no params
  val justDoSomething:() => Int = () => 3

  //careful
  println(justDoSomething) //function
  println(justDoSomething()) // call

  //curly braces
  val stringToInt = { (str: String ) =>
    str.toInt

  }

  //More Sysntatic Sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalente  to x => x + 1
  val niceAdded: (Int, Int) => Int = _ + _ //equivalent to (a,b) => a + b

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
