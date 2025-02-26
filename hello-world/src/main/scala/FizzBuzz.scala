package org.novlab.scala

object FizzBuzz {
//  private def fizzBuzzCheck(number: Int): String = {
//    if (number % 15 == 0) {
//      "FizzBuzz"
//    } else if (number % 3 == 0) {
//      "Fizz"
//    } else if (number % 5 == 0) {
//      "Buzz"
//    } else {
//      number.toString
//    }
//  }

private def fizzBuzzCheck(number: Int): String = (number % 5, number % 3) match {
  case (0,0) => "FizzBuzz"
  case (_,0) => "Fizz"
  case (0,_) => "Buzz"
  case (_,_) => number.toString
}

  def generate(limit: Int): String = {
    var output: String = ""
    for(i <-1 to limit) {
      if (i<limit) {
        output +=fizzBuzzCheck(i)+", "
      } else {
        output +=fizzBuzzCheck(i)
      }
    }
    output
  }
}

object Benchmark {
  def main(args: Array[String]): Unit = {
    val limit = 100000

    // Warm-up: run the function once to allow for any JIT compilation
    FizzBuzz.generate(limit)

    // Start the timer
    val startTime = System.nanoTime()

    // Call the function whose execution time you want to measure
    val result = FizzBuzz.generate(limit)

    // End the timer
    val endTime = System.nanoTime()

    // Calculate the duration in milliseconds
    val durationMs = (endTime - startTime) / 1e6

    println(s"Result: $result")
    println(s"Execution time: $durationMs ms")
  }
}
