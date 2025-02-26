package org.novlab.agenda

object Main extends App {
  private val m1 = new Meeting("Tennis", "Monday", "10am")
  private val m2 = new Meeting("Yoga", "Tuesday", "10am")
  private val m3 = new Meeting("Team Meeting", "Tuesday", "3pm")
  private val m4 = new Meeting("School", "Monday", "9pm")
  private val m5 = new Meeting("Makers", "Monday", "9am")
  private val agenda = new Agenda(List(m1,m2,m3,m4,m5))
  agenda.printDaySchedule("Monday")
  agenda.printDaySchedule("Tuesday")
  agenda.printDaySchedule("Thursday")
}
