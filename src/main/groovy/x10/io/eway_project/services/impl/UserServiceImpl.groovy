package x10.io.eway_project.services.impl

import org.bson.Document
import org.springframework.stereotype.Service
import x10.io.eway_project.services.UserService

@Service
class UserServiceImpl implements UserService {
    @Override
    List<Document> showAll(String dateFrom, String dateTo) {
        return null
    }
}
