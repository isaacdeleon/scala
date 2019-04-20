package lectures.part1basics

object DefaultArgs extends App {

  //Defaults values
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1,n * acc)

  val fact10Default = trFact(10)
  val fact10 = trFact(10, 1)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080) = println("Saving Picture")
  savePicture(width = 800)
  savePicture(height = 700, width = 800, format = "bmp")
}
