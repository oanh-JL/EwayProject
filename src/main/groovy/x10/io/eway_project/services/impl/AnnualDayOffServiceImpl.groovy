package x10.io.eway_project.services.impl

import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.Field
import org.springframework.data.mongodb.core.aggregation.LookupOperation
import org.springframework.data.mongodb.core.aggregation.MatchOperation
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation
import org.springframework.data.mongodb.core.aggregation.UnwindOperation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Service
import x10.io.eway_project.services.AnnualDayOffService

@Service
class AnnualDayOffServiceImpl implements AnnualDayOffService {

    @Autowired
    MongoTemplate mongoTemplate

    @Override
    List<Document> showOrganizationDayOff(String annualDayOffId) {

        //UnwindOperation unwindOperation = Aggregation.unwind("OrganizationsDayOff")
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("organizations").localField("organization_id")
                .foreignField("organization_id").as("OrganizationsDayOff")

        LookupOperation lookupOperation1 = LookupOperation.newLookup()
                .from("users").localField("organization_id")
        MatchOperation matchOperation = Aggregation.match(new Criteria()
                .where("annual_day_off_id").is(annualDayOffId))

        ProjectionOperation projectionOperation = Aggregation
                .project("annual_day_off_id", "organization_id", "start_day_off",
                        "end_day_off", "OrganizationsDayOff").andExclude("_id")

        Aggregation aggregation = Aggregation
                .newAggregation(matchOperation, lookupOperation, projectionOperation)

        List<Document> result = mongoTemplate.aggregate(aggregation,
                "annual_day_offs", Document.class) as List<Document>

        return result
    }

}
