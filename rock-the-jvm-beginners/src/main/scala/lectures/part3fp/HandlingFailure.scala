package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SuperFail"))

  println(aSuccess)
  println(aFailure)

  //try via apply method
  def unsafeMethod(): String = throw new RuntimeException("Not String for you")

  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  val anotherPotentialFailure = Try {
    //code might throw exception
  }

  //utilites
  println(potentialFailure.isSuccess)

  //or elese
  def backUpMethod(): String = "a valid result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backUpMethod()))
  println(fallbackTry)


  //if you design the API
  def betterUnsafeMethod(): Try[String] = new Failure(new RuntimeException)

  def betterBackupMethod(): Try[String] = Success("A valid result")

  val betterFallBack = betterUnsafeMethod() orElse betterBackupMethod()


  //flat map , filter, map
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))

  val host = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection Interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone Else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  val possibleConnection = HttpService.getSafeConnection(host, port)
  val posibleHtml = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  posibleHtml.foreach(renderHTML)

  //shorthanded version
  HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  // for comprehension version
  for {
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)


}
