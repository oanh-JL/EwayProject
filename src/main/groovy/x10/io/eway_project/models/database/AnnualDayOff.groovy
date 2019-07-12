package x10.io.eway_project.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "annual_day_offs")
class AnnualDayOff {

    @Id
    String id

    String annualDayOffId

    List<String> organizationId

    LocalDate startDayOff

    LocalDate endDayOff

    LocalDate createdAt

    LocalDate modifiedAt

}