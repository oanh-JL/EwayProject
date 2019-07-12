package x10.io.eway_project.services

import org.bson.Document

interface UserService {

    List<Document> showAll(String dateFrom, String dateTo)

}