package lectures.part4pm

import exercises.{Cons, Empty}
import lectures.part2opp.Generics.MyList

object AllThePatterns extends App {
  //1 constant
  val x: Any = "Scala"
  val constant = x match {
    case 1 => "x number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePatterns => "Singleton object"
  }

  // 2 match anything (wildcar)
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 matching variable
  val matchVariable = x match {
    case something => s"i ve found $something"
  }

  //3 tuples
  val aTuple = (1,2)
  val matchTuppl = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"i ve found $something"
  }

  val nestedTupple = (1, (2, 3))
  val matchNestedTuple = nestedTupple match {
    case (_, (2, v)) =>
  }

  // can be nested
  //4 clase matching

//  val aStandardList = (1,2,3,4)
//  val standardListMatching = aStandardList match {
//    case List(1, _, _, _) =>
//    case List(1, _*) => //list of arbitrary length
//    //case 1 :: List(_) => //infix pattern
//    case List(1,2,4) :+ 42 =>
//  }

//  val unkown : Any = 2
//  val unkownMatch = unkown match {
//    case list: List[Int] => //explicit type especifier
//    case _ =>
//  }
//
//  val numbers = List(1,2,3)
//  val numbersMatch = numbers match {
//    case listOfString: List[String] => "List of string"
//    case listOfNumbers: List[Int] => "list of numbers"
//    case _ => ""
//  }

  //println(numbersMatch)
}
