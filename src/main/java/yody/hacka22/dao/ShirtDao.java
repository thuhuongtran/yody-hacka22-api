package yody.hacka22.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import yody.hacka22.entity.Shirt;

public interface ShirtDao extends MongoRepository<Shirt, String> {
}
