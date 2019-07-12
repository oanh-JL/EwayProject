package x10.io.eway_project.models.request

import java.time.LocalDate
import java.time.LocalTime

class RawDailyRequest {

    String id

    int fingerId

    String userName

    LocalDate date

    LocalTime checkIn

    LocalTime checkOut

    LocalDate createdAt
}
