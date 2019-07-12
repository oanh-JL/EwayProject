package x10.io.eway_project.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id

import java.time.LocalDate


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
class Detail {

    @Id
    String id

    String userId

    LocalDate dayFrom

    LocalDate dayTo

    float totalTime

    float totalDay

    int totalDayOff

    int totalForgetCheck

    List<Daily> dailies

    LocalDate createdAt

    LocalDate modifiedAt
}