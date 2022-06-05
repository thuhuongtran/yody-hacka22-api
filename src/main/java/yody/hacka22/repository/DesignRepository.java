package yody.hacka22.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import yody.hacka22.dao.DesignDao;
import yody.hacka22.entity.Business;
import yody.hacka22.entity.Design;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DesignRepository {
    @Autowired
    private DesignDao designDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Design> searchDesignImageByTags(List<String> tags) {
        List<Design> designs = new ArrayList<>();
        tags.forEach(tag -> {
            Query query = new Query();
            query.addCriteria(Criteria.where("tags").regex(tag));
            designs.addAll(mongoTemplate.find(query, Design.class));
        });
        return designs;
    }
}
