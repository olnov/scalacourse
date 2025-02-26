object FizzBuzz {

    def buzzFizz(number: Int): String = {
        if (number % 3 == 0 && number % 5 == 0) {
            "FizzBuzz"
        } else if (number % 3 == 0) {
            "Fizz"
        } else if (number % 5 == 0) {
            "Buzz"
        } else {
            number.toString
        }
    }

    def main(args: Array[String]): Unit = {
        for (i <- 1 to 15) {
            println(buzzFizz(i))
        }
    }
}