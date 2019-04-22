package lectures.part2opp

import lectures.part2opp.Exceptions.x

object Exceptions extends App {

  val x: String = null
  //println(x.length)

  //val aWeirValue: String = throw new NullPointerException

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {

    getInt(true)

  } catch {
    case e: RuntimeException => 43
  } finally {
    println("finally")
  }

  println(potentialFail)

  class MyException extends Exception {
    val exception = new MyException
    //throw Exception
  }

  //val array = Array.ofDim(Int.MaxValue)

  //def infinite: Int = 1 + infinite

  class OverFlowException extends RuntimeException

  class UnderFlowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new OverFlowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else if (x < 0 && y > 0 && result < 0) throw new UnderFlowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if(y == 0) throw new MathCalculationException
      else x / y
    }
  }

  //println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(1, 0))
}
