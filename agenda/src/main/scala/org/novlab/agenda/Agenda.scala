package org.novlab.agenda

class Agenda (val meetings: List[Meeting]) {
  
// Solution without grouping
//  private def isMorning(time: String): Boolean = {
//    if (time.contains("am")) {
//      true
//    } else {
//      false
//    }
//  }


//  def printDaySchedule(day: String): Unit = {
//    val meetingsForTheDay = meetings.filter(_.day == day)
//    if (meetingsForTheDay.nonEmpty) {
//      for (meeting <- meetingsForTheDay)
//        if (isMorning({meeting.time})) {
//          println(s"$day morning:")
//          println(s" ${meeting.time}: ${meeting.name}")
//        }else{
//          println(s"$day afternoon:")
//          println(s" ${meeting.time}: ${meeting.name}")
//        }
//    } else {
//      println(s"There are no meetings on ${day}")
//    }
//  }

// Solution with grouping
  private def timePeriod(str: String):String = {
    if (str.contains("am")) {
      "morning"
    }else{
      "afternoon"
    }
  }

  def printDaySchedule(day: String): Unit = {
    val meetingsForDay = meetings
      .filter(_.day.equalsIgnoreCase(day))
      .sortBy(_.time)

    if (meetingsForDay.isEmpty) {
      println(s"There are no meetings on $day")
    } else {
      val grouped = meetingsForDay
        .groupBy(m => timePeriod(m.time))

      val output = new StringBuilder

      List("morning", "afternoon").foreach { period =>
        grouped.get(period).foreach { meetings =>
          output.append(s"$day $period:\n")
          meetings.foreach(m => output.append(s" ${m.time}: ${m.name}\n"))
        }
      }
      println(output.toString.trim)
    }
  }
}

class Meeting (val name: String, val day: String, val time: String)

