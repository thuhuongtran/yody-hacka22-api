package yody.hacka22.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yody.hacka22.dao.OrderDao;
import yody.hacka22.entity.Order;

@Repository
public class OrderRepository {
    @Autowired
    OrderDao orderDao;
    public Order createOrder(Order order){
        Order response;
        try {
            response = orderDao.save(order);
            if (response!= null){
                return response;
            }
            else {
                throw new RuntimeException();
            }
        }
        catch (Exception exception){
            throw new RuntimeException();
        }
    }
}
