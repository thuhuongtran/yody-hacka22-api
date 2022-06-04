package yody.hacka22.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import yody.hacka22.entity.OrderItem;

public interface OrderItemDao  extends MongoRepository<OrderItem, String> {
}
