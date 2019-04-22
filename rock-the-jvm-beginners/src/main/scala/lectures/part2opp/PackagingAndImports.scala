package lectures.part2opp

import playground.{PlaygroundJava, Prince => SonOfKing, playgroundScalaClass}


object PackagingAndImports extends App {

  val writr = new Writer("Daniel", "RockThe JVM", 2018)

  val playgroundScala = new playgroundScalaClass //paquete.clase

  sayHello
  println(SPEED_OF_LIGHT)

  val prince = new SonOfKing()


}
