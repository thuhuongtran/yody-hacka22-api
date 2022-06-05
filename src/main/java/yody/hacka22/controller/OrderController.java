package yody.hacka22.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import yody.hacka22.entity.Order;
import yody.hacka22.repository.OrderItemRepository;
import yody.hacka22.repository.OrderRepository;


@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @PostMapping("create")
    @Transactional
    public ResponseEntity<Boolean> createOrder(@RequestBody Order order){
        Order response = orderRepository.createOrder(order);
        order.getOrderItemList().forEach(e -> e.setOrderId(response.getId()));
        orderItemRepository.createListOrderItem(order.getOrderItemList());
        return ResponseEntity.ok(true);
    }


}
