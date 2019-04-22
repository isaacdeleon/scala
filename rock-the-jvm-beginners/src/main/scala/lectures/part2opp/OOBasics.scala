package lectures.part2opp

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  person.greet("Iaaac")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWritenBy(author))

  val counter = new Counter()
  counter.inc.inc.inc.print
  counter.inc(10).print
}

//contructors
// class parameters are not attributtes excepts if use val
class Person(name: String, val age: Int = 0) {

  val x = 2

  //overloading
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("jhon")

}

// novel and writer class
class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year

  def isWritenBy(author: Writer) = author == this.author

  def copy(newYear: Int) = new Novel(name, newYear, author)
}

//Counter Class
class Counter(val count: Int = 0) {
  def inc = {
    println("Incrementing")
    new Counter(count + 1) //inmutability
  }

  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}
