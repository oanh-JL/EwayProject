package x10.io.eway_project.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import x10.io.eway_project.models.database.Daily

import java.time.LocalDate

interface DailyRepository extends MongoRepository<Daily, String> {
    Daily findByFingerIdAndDate(int fingerId, LocalDate date)
}