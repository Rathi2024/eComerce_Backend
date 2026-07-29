package com.rathi.ecom_project.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL)
    private List<OrderItem> items;
}