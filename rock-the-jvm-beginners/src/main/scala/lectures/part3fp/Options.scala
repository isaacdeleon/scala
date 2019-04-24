package lectures.part3fp

import java.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val nonOption: Option[Int] = None

  println(myFirstOption)
  println(nonOption)

  //unsafe apis
  def unsafeMethod(): String = null

  //val reuslt = Some(unsafeMethod()) // WRONG
  val result = Option(unsafeMethod())
  println(result)

  //chained methods
  def backUpMethod(): String = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backUpMethod()))

  println(chainedResult)

  //design unsafe APIS
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid Result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()


  // functions
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // unsafe do not use this

  //flat map filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for comprehension
  val config: Map[String, String] = Map {
    "host" -> "172.45.35.1"
    "port" -> "80"
  }

  class Connection {
    def connect = "Connnected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  // chained call
  config.get("host").flatMap(host => config.get("port")
    .flatMap(port => Connection(host, port))
    .map(connection => connection.connect)).foreach(println)

  val connectionsStatusFor = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  connectionsStatusFor.foreach(println)
}
