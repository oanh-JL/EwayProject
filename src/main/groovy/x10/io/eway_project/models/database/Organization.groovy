package x10.io.eway_project.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "organizations")
class   Organization {

    @Id
    String id

    @Indexed(unique = true)
    String organizationId

    @Indexed(unique = true)
    String managerId

    String nameOrganization

    String parentOrganization

    String description

    LocalDate createdAt

    LocalDate modifiedAt
}
