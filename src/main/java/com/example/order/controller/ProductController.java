package com.example.order.controller;

import com.example.order.model.Product;
import com.example.order.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) throws Exception {
        var product = productService.getOne(id);
        return ResponseEntity.of(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() throws Exception {
        var products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) throws Exception {
        return ResponseEntity.ok(productService.saveNew(product));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) throws Exception {
        if (product.getId() == null) {
            throw new Exception("Product for update must have an ID");
        }
        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) throws Exception {
        productService.deleteById(id);
        return ResponseEntity.ok(id);
    }

}
