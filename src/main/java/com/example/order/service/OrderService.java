package com.example.order.service;

import com.example.order.model.Invoice;
import com.example.order.model.Order;
import com.example.order.model.Product;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    InvoiceService invoiceService;

    public Optional<Order> getOne(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order saveNew(List<Product> products) {
        Order order = new Order(
                null,
                products.stream().mapToDouble(Product::getPrice).sum(),
                java.util.Calendar.getInstance().getTime().toString(),
                Order.OrderStatus.CREATED_NEED_PAYMENT,
                products);
        invoiceService.saveNew(new Invoice(order));
        return orderRepository.save(order);
    }

    public Order update(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
