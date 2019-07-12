package x10.io.eway_project.services.handling_time_working

import java.time.LocalTime

class ConvertTime {

    CheckTime checkTime = new CheckTime()

    static LocalTime convertStringToLocalTime(String timeString) {
        if(timeString == null || timeString == ""){
            return LocalTime.parse("00:00")
        }
        LocalTime time = LocalTime.parse(timeString)
        return time
    }


    LocalTime convertTimeStartToStandard(LocalTime timeStart) {
        if (timeStart.isBefore(checkTime.TIME_START_MORNING)) {
            return checkTime.TIME_START_MORNING
        }
        if (timeStart.isBefore(checkTime.TIME_START_AFTERNOON) && timeStart.isAfter(checkTime.TIME_START_LUNCH)) {
            return checkTime.TIME_START_AFTERNOON
        }
        return timeStart
    }

    LocalTime convertTimeEndToStandard(LocalTime timeEnd) {
        if (timeEnd.isAfter(checkTime.TIME_START_LUNCH) && timeEnd.isBefore(checkTime.TIME_START_AFTERNOON)) {
            return checkTime.TIME_START_LUNCH;
        }
        if (timeEnd.isAfter(checkTime.TIME_END_EVENING)) {
            return checkTime.TIME_END_EVENING
        }
        return timeEnd
    }
}
