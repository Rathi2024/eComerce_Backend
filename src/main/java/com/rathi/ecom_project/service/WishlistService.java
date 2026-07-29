package com.rathi.ecom_project.service;

import com.rathi.ecom_project.model.Product;
import com.rathi.ecom_project.model.Wishlist;
import com.rathi.ecom_project.repo.ProductRepo;
import com.rathi.ecom_project.repo.WishlistRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistRepo wishlistRepo;
    private final ProductRepo productRepo;


    public Wishlist addToWishlist(String username, int productId) {

        if (wishlistRepo.existsByUsernameAndProductId(username, productId)) {
            throw new RuntimeException("Product already exists in wishlist");
        }

        Product product = productRepo.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        Wishlist wishlist = new Wishlist();
        wishlist.setUsername(username);
        wishlist.setProduct(product);

        return wishlistRepo.save(wishlist);
    }

    public List<Wishlist> getWishlist(String username) {
        return wishlistRepo.findByUsername(username);
    }

    @Transactional
    public void removeFromWishlist(String username, int productId) {
        wishlistRepo.deleteByUsernameAndProductId(username, productId);
    }
}