package com.example.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator="order_sequence")
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false, columnDefinition="Decimal(10,2)")
    private Double price;

    private String comment;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> products;

    public enum OrderStatus {
        CREATED_NEED_PAYMENT,
        PAYED_AND_CLOSED,
        CANCELED,
        ERROR
    }

}
