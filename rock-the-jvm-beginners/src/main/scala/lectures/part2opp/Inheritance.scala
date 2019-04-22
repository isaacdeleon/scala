package lectures.part2opp

object Inheritance extends App {

  //Single class inheritance
  class Animal {
    val creatureType = "wild"
    protected def eat() = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat()
      println("crunch crucnh")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructor
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overriding fields and methods
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "Domestic"
    override def eat = {
      super.eat()
      println("crunch crucnh")
    }
  }

  val dog = new Dog("cananie")
  dog.eat
  println(dog.creatureType)

  //type substitution polyformism
  val unkownAnimal: Animal = new Dog("K9")
  //unkownAnimal.eat

  // preventing override
  //final to the method o to the class to prevent exxtends
  //sealed the keyword to extends only in the same file
}
