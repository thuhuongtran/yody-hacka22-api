package yody.hacka22.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import yody.hacka22.entity.TemplateShirt;

public interface TemplateShirtDao extends MongoRepository<TemplateShirt, String> {

}
