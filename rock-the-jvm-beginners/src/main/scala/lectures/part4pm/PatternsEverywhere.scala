package lectures.part4pm

object PatternsEverywhere extends App {

  //
  try {

  } catch {
    case e: RuntimeException => "Runtime"
    case npe : NullPointerException => "npe"
    case _ => "Something else"
  }

  // catches are actually matches

  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  //generator are patter mathing
  val tuples = List((1,2), (3,4))
  val filteredTupples = for {
    (first, second) <- tuples
  } yield first * second


  //multiple v
  val aTupple = (1,2,3)
  val (a,b,c) = aTupple
  println(b)

  val head :: tail = list
  println(head)
  println(tail)

  val mappedList = list.map { x => x match
    {
      case v if v % 2 == 0 => s" $v is even"
      case 1 => "the one"
      case _ => "Something else"
    }
  }

  println(mappedList)
}
