package lectures.part2opp

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutwith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person(s"$name ($nickname)", s"$favoriteMovie")

    def unary_! : String = s"$name what the heck!"

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name $name and i like $favoriteMovie"

    def apply(n: Int): String = s"$name watch $favoriteMovie $n times"

    def learns(thing: String) = s"$name is learning $thing"

    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // Equivalent infix operator syntatic sugar

  //Operator in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutwith tom)
  println(mary + tom)

  //ALL OPERATOR ARE METHODS

  //prefix notation
  val x = -1 //equivalten with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only work with +-!
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) //equivalent

  println((mary + "the rockstar") ())
  println((+mary).age)
  println(mary learnsScala)

  println(mary(10))
}