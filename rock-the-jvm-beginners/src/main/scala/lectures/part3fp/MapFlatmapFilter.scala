package lectures.part3fp

object MapFlatmapFilter extends App {

  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + " Is a member"))

  println(list.filter(_ % 2 == 0))

  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("Black", "White")

  val combinations = numbers.flatMap(n => chars.map(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)

  list.foreach(println)

  //if guard is like filter
  val forCombination = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombination)

  for {
    n <- numbers
  } println(n)


  //syntax overload
  list.map{ x =>
    x * 2
  }
}
