package com.example.order;

import com.example.order.model.Order;
import com.example.order.model.Product;
import com.example.order.repository.OrderRepository;
import com.example.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
public class OrderApplication {


    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @PostConstruct
    private void fillTable() {

        productRepository.save(new Product(null,"book" , 50.99, "book"));
        productRepository.save(new Product(null,"laptop" , 25000.00, "laptop"));
        productRepository.save(new Product(null,"powerBank" , 800.50, "powerBank"));
        orderRepository.save(new Order(null, 50.99, "new", Order.OrderStatus.CREATED_NEED_PAYMENT, Collections.singletonList(productRepository.getOneByName("book"))));
    }
}
