package com.rathi.ecom_project.repo;

import com.rathi.ecom_project.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {

}