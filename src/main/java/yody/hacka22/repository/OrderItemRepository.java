package yody.hacka22.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yody.hacka22.dao.OrderItemDao;
import yody.hacka22.entity.OrderItem;

import java.util.List;

@Repository
public class OrderItemRepository {
    @Autowired
    OrderItemDao orderItemDao;
    public OrderItem createOrderItem(OrderItem orderItem){
        OrderItem response;
        try{
            response = orderItemDao.save(orderItem);
            if (response != null){
                return response;
            }
            else throw new RuntimeException("fail when create a order item ");
        } catch (Exception exception){
            throw new RuntimeException("fail when create a order item ");
        }
    }

    public void createListOrderItem(List<OrderItem> orderItemList){
        try{
            orderItemDao.saveAll(orderItemList);
        } catch (Exception exception){
            throw new RuntimeException("fail when create a order item ");
        }
    }


}
