package yody.hacka22.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import yody.hacka22.entity.Design;

public interface DesignDao extends MongoRepository<Design, String> {
}
