package com.cn.cnkart.controller;

import com.cn.cnkart.entity.Item;
import com.cn.cnkart.entity.Order;
import com.cn.cnkart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/id/{id}")
    public Order getOrderById(@PathVariable int id)
    {
        return orderService.getOrderById(id);
    }

    @PostMapping("/save")
    public void saveOrder(@RequestBody Order order)
    {
        orderService.saveOrder(order);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteOrder(@PathVariable int id)
    {
        orderService.delete(id);
    }
}
