package x10.io.eway_project.services.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import x10.io.eway_project.models.database.RawDaily
import x10.io.eway_project.models.response.SystemResponse
import x10.io.eway_project.repositories.RawDailyRepository
import x10.io.eway_project.services.DailyService
import x10.io.eway_project.services.RawDailyService
import x10.io.eway_project.services.mapper.RawDailyMapper

import java.time.LocalDate

@Service
class RawDailyServiceImpl implements RawDailyService {

    @Autowired
    RawDailyRepository repository
    @Autowired
    DailyService dailyService
    @Autowired
    RawDailyMapper mapper

    @Override
    ResponseEntity<SystemResponse> create(List<RawDaily> rawDailies) {

        rawDailies.forEach({

            raw ->
                RawDaily rawFound = repository.findByFingerIdAndDate(raw.fingerId, LocalDate.parse(raw.date.toString()))
                if (!rawFound) {
                    mapper.update(raw)
                    repository.save(raw)
                    dailyService.create(raw)
                } else {
                    mapper.update(raw)
                    raw.setId(rawFound.getId())
                    raw.setModifiedAt(LocalDate.now())
                    repository.save(raw)
                    dailyService.update(raw)
                }

        })
        return new ResponseEntity<>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    };
}

