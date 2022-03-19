package com.example.order.service;

import com.example.order.model.Product;
import com.example.order.model.Product;
import com.example.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Optional<Product> getOne(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product saveNew(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
