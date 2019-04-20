package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " i First need of facotiral of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computing factorial of " + n)
      result
    }
  }

  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumualtor: BigInt): BigInt =
      if (x <= 1) accumualtor
      else factorialHelper(x - 1, x * accumualtor) //tail recursion user recusrsiv call as the last expresion
    factorialHelper(n, 1)
  }

  println(anotherFactorial(10))
  println(anotherFactorial(5000))
  //When you need loops USER tail RECURSION

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n - 1, aString + accumulator)
  }

  println(concatenateTailrec("Hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextLast: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextLast, last)

    if (n <= 2) 1
    else fiboTailrec(3, 1, 1)
  }

  println(fibonacci(8))
}
