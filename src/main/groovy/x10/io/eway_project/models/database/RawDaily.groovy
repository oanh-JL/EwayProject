package x10.io.eway_project.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate
import java.time.LocalTime

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "raw_dailies")
class RawDaily {

    @Id
    String id

    int fingerId

    String userName

    LocalDate date

    LocalTime checkIn

    LocalTime checkOut

    LocalDate createdAt

    LocalDate modifiedAt
}
