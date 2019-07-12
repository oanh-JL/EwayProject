package x10.io.eway_project.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import x10.io.eway_project.models.database.AnnualDayOff

interface AnnualDayOffRepository extends MongoRepository<AnnualDayOff, String> {

}