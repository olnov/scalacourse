import org.novlab.agenda.Meeting
import org.novlab.agenda.Agenda
import org.scalatest.funsuite.AnyFunSuite

import java.io.{ByteArrayOutputStream, PrintStream}

class AgendaTest extends AnyFunSuite {
  test("Should return tennis on Monday at 10am") {
    val m1 = new Meeting("Tennis", "Monday", "10am")
    val newAgenda = new Agenda(List(m1))
    val outputStream = new ByteArrayOutputStream()
    Console.withOut(new PrintStream(outputStream)) {
      newAgenda.printDaySchedule("Monday")
    }
    val output = outputStream.toString.trim
    assert(output == "Monday:\r\n 10am: Tennis")
  }

  test("Should return Tennis on Monday at 10am and School at 8am") {
    val m1 = new Meeting("School", "Monday", "8am")
    val m2 = new Meeting("Tennis", "Monday", "10am")
    val newAgenda = new Agenda(List(m1,m2))
    val outputStream = new ByteArrayOutputStream()
    Console.withOut(new PrintStream(outputStream)) {
      newAgenda.printDaySchedule("Monday")
    }
    val output = outputStream.toString.trim
    assert(output == "Monday:\r\n 8am: School\r\n 10am: Tennis")
  }

}
