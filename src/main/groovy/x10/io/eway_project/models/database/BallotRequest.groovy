package x10.io.eway_project.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "ballot_requests")
class BallotRequest {

    @Id
    String id

    String userId

    int dayOffTypeId

    String reason

    LocalDate dateFrom

    LocalDate dateTo

    LocalDate createdAt

    LocalDate modifiedAt
}
