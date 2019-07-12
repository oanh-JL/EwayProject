package x10.io.eway_project.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import x10.io.eway_project.models.database.RawDaily
import x10.io.eway_project.models.response.SystemResponse
import x10.io.eway_project.services.RawDailyService

@RestController
@RequestMapping("/raw_daily")
class RawDailyController {

    @Autowired
    RawDailyService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody List<RawDaily> dailies) {
        return service.create(dailies)
    }

}
