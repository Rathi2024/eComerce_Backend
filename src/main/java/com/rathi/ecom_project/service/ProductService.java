package com.rathi.ecom_project.service;

import com.rathi.ecom_project.exception.ProductNotFoundException;
import com.rathi.ecom_project.model.Product;
import com.rathi.ecom_project.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
     return repo.findAll();

    }

    public Product getProductById(int id) {
        return repo.findById(id)
                .orElseThrow(() ->
                new ProductNotFoundException(
                        "Product with id " + id + " not found"
                ));
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {

        Product existing = repo.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product with id " + id + " not found"
                        ));


        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setBrand(product.getBrand());
        existing.setPrice(product.getPrice());
        existing.setCategory(product.getCategory());
        existing.setReleaseDate(product.getReleaseDate());
        existing.setAvailable(product.isAvailable());
        existing.setStockQuantity(product.getStockQuantity());

        if (imageFile != null && !imageFile.isEmpty()) {
            existing.setImageName(imageFile.getOriginalFilename());
            existing.setImageType(imageFile.getContentType());
            existing.setImageData(imageFile.getBytes());
        }

        return repo.save(existing);
    }

    public void deleteProduct(int id){
        Product product = repo.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product with id " + id + " not found"
                        ));

        repo.delete(product);
    }

    public List<Product> searchProducts(String keyword){
        return repo.searchProducts(keyword);
    }
}
