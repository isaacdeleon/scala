package lectures.part2opp

object CaseClasses extends App {

  //1. class parameters are fields
  //2. sensible to String
  //3. equals hashcode implemented
  //4. have handy copy
  //5. Have companion Objects
  //6. Are Serializable AKKA Framework
  //7. have extractors pattern , pattern matching
  case class Person(name: String, age: Int)

  val jim = new Person("Jim", 34)
  //println(jim.name)
  //println(jim.toString)
  println(jim)

  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  val jim3 = jim.copy(age = 45)
  println(jim3)

  val thePerson = Person
  val mary = Person.apply("Mary", 23)

  case object UnitedKingdom {
    def name: String = "The Gb and NI"
  }
}
