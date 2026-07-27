package com.rathi.ecom_project.controller;

import com.rathi.ecom_project.model.Wishlist;
import com.rathi.ecom_project.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @Operation(
            summary = "Add Product to Wishlist",
            description = "Adds the specified product to the authenticated user's wishlist."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product added to wishlist successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "401", description = "User is not authenticated")
    })
    @PostMapping("/{productId}")
    public Wishlist addToWishlist(@PathVariable int productId, Authentication authentication) {

        String username = authentication.getName();

        return wishlistService.addToWishlist(username, productId);
    }

    @Operation(
            summary = "Get User Wishlist",
            description = "Fetches all products added to the currently authenticated user's wishlist."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Wishlist fetched successfully"),
            @ApiResponse(responseCode = "401", description = "User is not authenticated")
    })
    @GetMapping
    public List<Wishlist> getWishlist(Authentication authentication) {

        String username = authentication.getName();

        return wishlistService.getWishlist(username);
    }


    @Operation(
            summary = "Remove Product from Wishlist",
            description = "Removes the specified product from the authenticated user's wishlist."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product removed from wishlist successfully"),
            @ApiResponse(responseCode = "404", description = "Wishlist item not found"),
            @ApiResponse(responseCode = "401", description = "User is not authenticated")
    })
    @DeleteMapping("/{productId}")
    public String removeFromWishlist(
            @PathVariable int productId,
            Authentication authentication) {

        String username = authentication.getName();

        wishlistService.removeFromWishlist(username, productId);

        return "Product removed from wishlist";
    }
}