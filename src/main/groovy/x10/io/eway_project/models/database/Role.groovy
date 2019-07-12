package x10.io.eway_project.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "roles")
class Role {

    @Id
    String id

    @Indexed(unique = true)
    String roleId

    String role

    @Indexed(unique = true)
    String parentRole

    LocalDate createdAt

    LocalDate modifiedAt
}
