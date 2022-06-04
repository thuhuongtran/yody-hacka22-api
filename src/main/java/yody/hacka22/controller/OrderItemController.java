package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yody.hacka22.dao.OrderItemDao;
import yody.hacka22.entity.OrderItem;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("order-item")
public class OrderItemController {
    @Autowired
    private OrderItemDao orderItemDao;

    @PostMapping("save")
    public String save(@RequestBody OrderItem orderItem) {
        orderItemDao.save(orderItem);
        return OK.toString();
    }

    @GetMapping("find")
    public OrderItem getOne(@RequestParam("id") String id) {
        return orderItemDao.findById(id).get();
    }
}
