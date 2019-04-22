package lectures.part2opp

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("crunch crunch")
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"

    override def eat: Unit = "nomnom"

    override def eat(animal: Animal): Unit = println(s"im a croc im eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs abstracts
  //traits don have constructor parameters
  // multiple treats may inherited by the same class
  // traits behavior, abstract class thing
}
