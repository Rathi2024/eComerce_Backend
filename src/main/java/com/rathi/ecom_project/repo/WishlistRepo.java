package com.rathi.ecom_project.repo;

import com.rathi.ecom_project.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {

    List<Wishlist> findByUsername(String username);

    void deleteByUsernameAndProductId(String username, int productId);

    boolean existsByUsernameAndProductId(String username, int productId);
}