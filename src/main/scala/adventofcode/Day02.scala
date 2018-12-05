package adventofcode


import scala.io.Source

object Day02 extends App {

  val ids = Source.fromFile(s"input/02.txt").getLines().toVector
  val checksum = PartOne(ids)
  val same = PartTwo(ids)
  println(s"Checksum: $checksum, Same: $same")


  def PartOne(ids: Vector[String]) = {
    val chars = ids.map(_.groupBy(c => c).mapValues(chars => chars.length))
    val twos = chars.flatMap(_.collect{ case (char, int) if int == 2 => int}.toList.distinct)
    val threes = chars.flatMap(_.collect{ case (char, int) if int == 3 => int}.toList.distinct)
    twos.length * threes.length
  }

  def PartTwo(ids: Vector[String]) = {
    val matches = ids.flatMap(id => ids.find(s => s.zip(id).count(c => c._1 != c._2) == 1))
    val index = matches.head.zip(matches.last).indexWhere(c => c._1 != c._2)

    matches.head.substring(0, index) + matches.head.substring(index + 1)
  }
}


