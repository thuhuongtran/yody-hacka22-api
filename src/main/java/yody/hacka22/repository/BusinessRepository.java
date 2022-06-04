package yody.hacka22.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import yody.hacka22.dao.BusinessDao;
import yody.hacka22.entity.Business;

import java.util.List;

@Repository
public class BusinessRepository {
    @Autowired
    private BusinessDao businessDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Business> listBusinessByUserId(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("user.id").regex(userId));
        return mongoTemplate.find(query, Business.class);
    }
}
