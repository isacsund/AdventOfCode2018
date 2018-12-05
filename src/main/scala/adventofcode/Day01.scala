package adventofcode

import adventofcode.Day01.{readInput}

import scala.collection.mutable.HashSet
import scala.io.Source

object Day01 extends App {

  PartOne
  PartTwo

  def readInput(): String = Source.fromFile(s"input/01.txt").getLines().mkString("\n")
}

object PartOne {
  val frequency = readInput().split("\n").map(_.toInt).sum
  println(s"Frequency: $frequency")
}

object PartTwo {
  var frequency = 0
  var frequencies = new HashSet[Int]()
  var idx = 0
  val deltaFrequency = readInput().split("\n").map(_.toInt)

  while (frequencies.add(frequency)) {
    frequency += deltaFrequency(idx % deltaFrequency.length)
    idx += 1
  }
  println(s"Duplicate: $frequency")

}