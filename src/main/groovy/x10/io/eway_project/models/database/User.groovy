package x10.io.eway_project.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "users")
class User {

    @Id
    String id

    String roleId

    String organizationId

    @Indexed(unique = true)
    int fingerId

    @Indexed(unique = true)
    String userId

    String fullName

    @Indexed(unique = true)
    String email

    String googleId

    String userName

    String password

    boolean status

    LocalDate createdAt

    LocalDate modifiedAt
}