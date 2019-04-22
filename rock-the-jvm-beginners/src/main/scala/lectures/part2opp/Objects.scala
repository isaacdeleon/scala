package lectures.part2opp

object Objects {

  //SCALA DOES NOT CLASS-LEVEL FUNCTIONALITY ("Static")
  object Person {
    //static class funcionality
    val N_EYES = 2

    def canFly: Boolean = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Kevin")
  }

  class Person(val name: String) {
    // instance level functionality
  }

  //companions object class

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala Object = Singleton Instance
    val mary = Person
    val john = Person
    println(mary == john)

    val maryClass = new Person("Mary")
    val johnClass = new Person("Person")
    println(maryClass == johnClass)

    val kevin = Person(maryClass, johnClass)

    //Scala applications = Scala Object with def main(args: Array[String]): Unit
  }
}
