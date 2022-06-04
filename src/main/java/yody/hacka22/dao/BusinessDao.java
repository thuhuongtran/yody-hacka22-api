package yody.hacka22.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import yody.hacka22.entity.Business;

public interface BusinessDao extends MongoRepository<Business, String> {
}
