package x10.io.eway_project.services

import org.bson.Document

interface AnnualDayOffService {

  List<Document> showOrganizationDayOff(String annualDayOffId)
}