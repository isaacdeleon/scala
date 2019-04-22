package lectures.part2opp

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahahahah")
  }

  println(funnyAnimal.eat)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can i help")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my is jim, how can i help")
  }
}
