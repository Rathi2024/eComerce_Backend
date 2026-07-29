package com.rathi.ecom_project.repo;

import com.rathi.ecom_project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {

    List<Order> findByUsername(String username);

}