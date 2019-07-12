package x10.io.eway_project.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "day_offs")
class DayOff {

    @Id
    String id

    @Indexed(unique = true)
    int dayOffId

    int dayOffTypeId

    String description

    float totalDayOff

    LocalDate createdAt

    LocalDate modifiedAt
}
