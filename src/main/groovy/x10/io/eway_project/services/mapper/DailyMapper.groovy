package x10.io.eway_project.services.mapper

import org.springframework.stereotype.Component
import x10.io.eway_project.models.database.Daily

import java.time.LocalDate
import java.time.LocalTime

@Component
class DailyMapper {

    static void create(Daily daily) {
        LocalTime checkIn = LocalTime.parse(daily.getCheckIn().toString())
        LocalTime checkOut = LocalTime.parse(daily.getCheckOut().toString())
        daily.setDate(LocalDate.parse(daily.getDate().toString()))
        daily.setCheckIn(checkIn)
        daily.setCheckOut(checkOut)

    }

    static void update(Daily daily) {
        daily.setDate(LocalDate.parse(daily.getDate().toString()))
        daily.setCheckIn(LocalTime.parse(daily.getCheckIn().toString()))
        daily.setCheckOut(LocalTime.parse(daily.getCheckOut().toString()))
        daily.setModifiedAt(LocalDate.now())
    }
}
