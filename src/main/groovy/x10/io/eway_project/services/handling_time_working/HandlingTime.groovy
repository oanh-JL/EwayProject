package x10.io.eway_project.services.handling_time_working

import java.time.LocalTime


class HandlingTime {

    CheckTime checkTime = new CheckTime()
    final LocalTime TIME_MAX_WORKING = LocalTime.of(8, 0)
    final LocalTime TIME_MIN_WORKING = LocalTime.of(0, 0)

    LocalTime handlingTime(LocalTime timeStart, LocalTime timeEnd) {
        double totalTime = 0
        if (checkTime.checkTimeOutLunch(timeStart, timeEnd)) {
            totalTime = timeEnd.toSecondOfDay() - timeStart.toSecondOfDay() - checkTime.TIME_FOR_LUNCH.toSecondOfDay()
            return totalTime < 0 ? TIME_MIN_WORKING : result(totalTime)
        } else {
            totalTime = timeEnd.toSecondOfDay() - timeStart.toSecondOfDay()
            return totalTime < 0 ? TIME_MIN_WORKING : result(totalTime)
        }
    }

    private LocalTime result( double totalTime){
        int hourWorking = (int) (totalTime / 3600)
        int minuteWorking = (int) ((totalTime - hourWorking * 3600) / 60)
        return LocalTime.of(hourWorking, minuteWorking).isAfter(TIME_MAX_WORKING) ? TIME_MAX_WORKING : LocalTime.of(hourWorking, minuteWorking)
    }


}