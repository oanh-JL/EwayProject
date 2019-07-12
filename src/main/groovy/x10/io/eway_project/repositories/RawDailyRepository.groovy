package x10.io.eway_project.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import x10.io.eway_project.models.database.RawDaily

import java.time.LocalDate

interface RawDailyRepository extends MongoRepository<RawDaily, String> {

    RawDaily findByFingerIdAndDate(int fingerId, LocalDate date)
}