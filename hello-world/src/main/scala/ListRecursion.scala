package org.novlab.scala

object ListRecursion {
  private def total(number: List[Int]): Int = {
    number match {
      case next::rest=>next + total(rest)
      case Nil=>0
    }
  }

  def main(args: Array[String]): Unit = {
    println(total(List(1,2,3)))
  }
}
