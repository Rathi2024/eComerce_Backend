package com.rathi.ecom_project.dto;

import lombok.Data;

@Data
public class OrderItemRequest {

    private int productId;
    private int quantity;

}