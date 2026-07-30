package com.rathi.ecom_project.controller;

import com.rathi.ecom_project.dto.OrderRequest;
import com.rathi.ecom_project.model.Order;
import com.rathi.ecom_project.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(
            summary = "Place Order",
            description = "Places an order for the authenticated user."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Order placed successfully"),
            @ApiResponse(responseCode = "401", description = "User is not authenticated")
    })
    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest request, Authentication authentication) {

        String username = authentication.getName();

        return orderService.placeOrder(request, username);
    }

    @Operation(
            summary = "Get My Orders",
            description = "Fetches all orders of the authenticated user."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Orders fetched successfully"),
            @ApiResponse(responseCode = "401", description = "User is not authenticated")
    })
    @GetMapping
    public List<Order> getOrders(Authentication authentication) {

        String username = authentication.getName();

        return orderService.getOrders(username);
    }

    @Operation(
            summary = "Delete Order",
            description = "Deletes an order by its ID. Only the owner of the order or an admin can delete it."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Order deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid order ID"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Order not found"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error"
            )
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {

        orderService.deleteOrder(id);

        return ResponseEntity.ok("Order deleted successfully");

    }
}