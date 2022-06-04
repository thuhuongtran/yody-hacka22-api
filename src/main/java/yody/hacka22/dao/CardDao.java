package yody.hacka22.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import yody.hacka22.entity.Card;

public interface CardDao extends MongoRepository<Card, String> {
}
