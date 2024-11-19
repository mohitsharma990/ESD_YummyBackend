package com.mohit.ESD_YummyBackend.service;

import com.mohit.ESD_YummyBackend.dto.ProductRequest;
import com.mohit.ESD_YummyBackend.entity.Product;
import com.mohit.ESD_YummyBackend.helper.JWTHelper;
import com.mohit.ESD_YummyBackend.mapper.ProductMapper;
import com.mohit.ESD_YummyBackend.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final JWTHelper jwtHelper;
    private final ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public String addProduct(ProductRequest product) {
        Product product1 = productMapper.toProduct(product);
        productRepo.save(product1);
        return "Product added";
    }

    public Product getProduct(String name) {
        Product product = productRepo.findByName(name).orElse(null);
        return product;
    }

    public String updateProduct(ProductRequest product) {
        Product productt = getProduct(product.name());
        productt.setPrice(product.price());
        productRepo.save(productt);
        return "Product updated";
    }

    public String deleteProduct(String name) {
        Product product = productRepo.findByName(name).orElse(null);
        productRepo.delete(product);
        return "Product deleted";
    }

}