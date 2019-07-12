package x10.io.eway_project.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "cycle_pay_rolls")
class CyclePayRoll {

    @Id
    String id

    LocalDate dateFrom

    LocalDate dateTo

    LocalDate createdAt

    LocalDate modifiedAt

}