package x10.io.eway_project.services.handling_time_working

import java.time.LocalTime

class CheckTime {
    final LocalTime TIME_START_AFTERNOON = LocalTime.of(13, 30)
    final LocalTime TIME_END_EVENING = LocalTime.of(18, 30)
    final LocalTime TIME_START_MORNING = LocalTime.of(8, 30)
    final LocalTime TIME_START_LUNCH = LocalTime.of(12, 0)
    final LocalTime TIME_FOR_LUNCH = LocalTime.of(1, 30)



    boolean checkTimeOutLunch(LocalTime timeStart, LocalTime timeEnd) {
        if (timeStart.isBefore(TIME_START_LUNCH) && timeEnd.isAfter(TIME_START_AFTERNOON))
            return true
        return false
    }
}