package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case 3 => "Third time is the charm"
    case _ => "Something else" //wildcard
  }

  println(x)
  println(description)

  // 1 decompose values
  case class Person(name: String, age: Int)

  val jim = Person("Jim", 20)

  val greeting = jim match {
    case Person(n, a) if a < 21 => s"Hi my name is $n and i cant drink in USA"
    case Person(n, a) => s"Hi my name is $n and i am $a year old"
    case _ => "i dont know who i am"
  }

  println(greeting)

  //case are match in order
  // use wildcard to mattcherror
  // compiler will unify the types of data
  // work good with sealed clases
  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of he $someBreed breed")
  }

  // match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  } //over coded

  // not use pattern matching for everything
  val isEvenNormal = x % 2 == 0

  trait Expr

  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " " + show(e2)
    case Prod(e1, e2) =>
      def maybeShowParentesis(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }

      maybeShowParentesis(e1) + " * " + maybeShowParentesis(e2)
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4)))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))

}
