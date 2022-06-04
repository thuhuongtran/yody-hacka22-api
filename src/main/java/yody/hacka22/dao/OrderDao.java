package yody.hacka22.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import yody.hacka22.entity.Order;

public interface OrderDao extends MongoRepository<Order, String> {
}
