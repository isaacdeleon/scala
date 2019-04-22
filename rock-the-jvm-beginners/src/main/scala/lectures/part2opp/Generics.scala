package lectures.part2opp

object Generics extends App {

  //Generic Class
  class MyList[+A] {
    //Type A
    def add[B >: A] (element: B): MyList[A] = ???
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  // generic method
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInteger = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //Coveriance
  class CovariantList[+A]
  val animal: Animal = new Cat()
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  //animalist.add(new Dog) ???

  //Invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //CONTRAVARIANTS
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded types
  class Cage[A <: Animal](animal: Animal)
  val cage = new Cage(new Dog)



}
