package yody.hacka22.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import yody.hacka22.entity.DesignShirt;

public interface DesignShirtDao extends MongoRepository<DesignShirt, String> {
}
