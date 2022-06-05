package yody.hacka22.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import yody.hacka22.entity.Photo;

public interface PhotoDao extends MongoRepository<Photo, String> {
}
