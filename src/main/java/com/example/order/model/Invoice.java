package com.example.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    public Invoice(Order order) {
        this.id = order.getId();
        this.price = order.getPrice();
        this.comment = order.getComment();
        this.products = order.getProducts();
    }

    @Id
    @GeneratedValue(generator="invoice_sequence")
    @SequenceGenerator(name = "invoice_sequence", sequenceName = "invoice_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false, columnDefinition="Decimal(10,2)")
    private Double price;

    private String comment;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> products;
}
