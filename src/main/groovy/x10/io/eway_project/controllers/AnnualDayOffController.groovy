package x10.io.eway_project.controllers

import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import x10.io.eway_project.services.AnnualDayOffService

@RestController
@RequestMapping("/annual_day_off")
class AnnualDayOffController {

    @Autowired
    AnnualDayOffService service

    @GetMapping("/{annual_day_off_id}")
    List<Document> showAll(@PathVariable("annual_day_off_id") String annualDayOffId) {
        return service.showOrganizationDayOff(annualDayOffId)
    }

}
