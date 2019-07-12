package x10.io.eway_project.services

import x10.io.eway_project.models.database.RawDaily

interface DailyService {

    void create(RawDaily daily)

    void update(RawDaily daily)
}