package yody.hacka22.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import yody.hacka22.entity.User;

public interface UserDao extends MongoRepository<User, String> {
}
