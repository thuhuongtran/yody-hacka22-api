package yody.hacka22.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import yody.hacka22.dao.TemplateShirtDao;
import yody.hacka22.entity.TemplateShirt;

import java.util.List;
import java.util.Map;

@Repository
public class TemplateShirtRepository {
    @Autowired
    TemplateShirtDao templateShirtDao;
    @Autowired
    MongoTemplate mongoTemplate;

    public TemplateShirt findTemplateShirt(Map<String, String> map){
        if (map != null && map.size() > 0){
            Query query = new Query();
            int time = 0;
            for (Map.Entry<String, String> entry : map.entrySet()){
                query.addCriteria(Criteria.where(entry.getKey()).regex(entry.getValue()));
            }
            List<TemplateShirt> list =  mongoTemplate.find(query,TemplateShirt.class);
            if (list != null && list.size() > 0){
                return list.get(0);
            }
            else return null;
        }
        return null;
    }

    public TemplateShirt createTemplateShirt(TemplateShirt templateShirt){
        try {
            TemplateShirt response = templateShirtDao.save(templateShirt);
            if (response != null){
                return response;
            }
            return null;
        }
        catch (Exception exception){
            System.out.printf("ERRR when create shirt template");
            return null;
        }
    }
}
