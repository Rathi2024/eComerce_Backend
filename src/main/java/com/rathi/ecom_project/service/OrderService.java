package com.rathi.ecom_project.service;

import com.rathi.ecom_project.dto.OrderItemRequest;
import com.rathi.ecom_project.dto.OrderRequest;
import com.rathi.ecom_project.model.Order;
import com.rathi.ecom_project.model.OrderItem;
import com.rathi.ecom_project.model.Product;
import com.rathi.ecom_project.repo.OrderRepo;
import com.rathi.ecom_project.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    public List<Order> getOrders(String username) {
        return orderRepo.findByUsername(username);
    }

    @Transactional
    public Order placeOrder(OrderRequest request, String username) {

        Order order = new Order();
        order.setUsername(username);
        order.setOrderDate(new Date());

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderItemRequest itemRequest : request.getItems()) {

            Product product = productRepo.findById(itemRequest.getProductId())
                    .orElseThrow(() ->
                            new RuntimeException("Product not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setPrice(product.getPrice());

            orderItems.add(orderItem);

            totalAmount = totalAmount.add(
                    product.getPrice().multiply(
                            BigDecimal.valueOf(itemRequest.getQuantity())
                    )
            );
        }

        order.setItems(orderItems);
        order.setTotalAmount(totalAmount);

        return orderRepo.save(order);
    }

    public void deleteOrder(int id) {

        Order order = orderRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        orderRepo.delete(order);
    }

    }
