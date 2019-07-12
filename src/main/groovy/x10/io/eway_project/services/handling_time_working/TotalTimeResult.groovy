package x10.io.eway_project.services.handling_time_working

import java.time.LocalTime

class TotalTimeResult {

    static LocalTime totalTime(String startTime, String endTime) {
        ConvertTime convertTime = new ConvertTime()
        HandlingTime handlingTime = new HandlingTime()
        LocalTime timeFrom = convertTime.convertTimeStartToStandard(convertTime.convertStringToLocalTime(startTime))
        LocalTime timeTo = convertTime.convertTimeEndToStandard(convertTime.convertStringToLocalTime(endTime))
        return handlingTime.handlingTime(timeFrom, timeTo)
    }
}