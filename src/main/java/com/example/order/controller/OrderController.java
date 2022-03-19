package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.model.Product;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) throws Exception {
        var order = orderService.getOne(id);
        return ResponseEntity.of(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() throws Exception {
        var orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody List<Product> products) throws Exception {
        return ResponseEntity.ok(orderService.saveNew(products));
    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order order) throws Exception {
        if (order.getId() == null) {
            throw new Exception("Order for update must have an ID");
        }
        return ResponseEntity.ok(orderService.update(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) throws Exception {
        orderService.deleteById(id);
        return ResponseEntity.ok(id);
    }

}
