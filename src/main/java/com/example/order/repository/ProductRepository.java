package com.example.order.repository;

import com.example.order.model.Order;
import com.example.order.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getOneByName(String name);
}
