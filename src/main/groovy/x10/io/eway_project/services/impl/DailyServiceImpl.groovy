package x10.io.eway_project.services.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import x10.io.eway_project.models.database.Daily
import x10.io.eway_project.models.database.RawDaily
import x10.io.eway_project.repositories.DailyRepository
import x10.io.eway_project.services.DailyService
import x10.io.eway_project.services.handling_time_working.TotalTimeResult
import x10.io.eway_project.services.mapper.DailyMapper

import java.time.LocalDate
import java.time.LocalTime

@Service
class DailyServiceImpl implements DailyService {

    @Autowired
    DailyMapper mapper
    @Autowired
    DailyRepository repository

    @Override
    void create(RawDaily raw) {
        Daily daily = parseDaily(raw)
        Daily dailyFound = repository.findByFingerIdAndDate(daily.fingerId, daily.date)
        if (!dailyFound) {
            mapper.create(daily)
            daily.setCreatedAt(LocalDate.now())
            daily.setModifiedAt(null)
            repository.save(daily)
        }
    }

    @Override
    void update(RawDaily raw) {
        Daily daily = parseDaily(raw)
        Daily dailyFound = repository.findByFingerIdAndDate(daily.fingerId, daily.date)
        if (dailyFound) {
            daily.setId(dailyFound.getId())
            daily.setStatus(dailyFound.status)
            daily.setTotalTime(dailyFound.totalTime)
            mapper.create(daily)
            repository.save(daily)
        }
    }

    static Daily parseDaily(RawDaily raw) {
        int status = 1
        LocalTime totalTime = TotalTimeResult.totalTime(raw.checkIn.toString(), raw.checkOut.toString())
        LocalTime nullTime = LocalTime.parse("00:00")
        String day = LocalDate.parse(raw.date.toString()).dayOfWeek
        if (raw.checkIn == nullTime && raw.checkOut == nullTime) {
            status = 0
        }
        if (day == "SATURDAY" || day == "SUNDAY") {
            status = 0
        }
        return new Daily(raw.fingerId,
                raw.date,
                raw.checkIn,
                raw.checkOut,
                totalTime,
                status,
                raw.createdAt,
                raw.modifiedAt)
    }
}
