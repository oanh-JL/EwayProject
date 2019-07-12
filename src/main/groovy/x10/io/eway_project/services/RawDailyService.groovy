package x10.io.eway_project.services

import org.springframework.http.ResponseEntity
import x10.io.eway_project.models.database.RawDaily
import x10.io.eway_project.models.response.SystemResponse

interface RawDailyService {

    ResponseEntity<SystemResponse> create(List<RawDaily> rawDailies)

}