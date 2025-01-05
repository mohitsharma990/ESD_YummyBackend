package com.mohit.ESD_YummyBackend.controller;

import com.mohit.ESD_YummyBackend.dto.ProductRequest;
import com.mohit.ESD_YummyBackend.entity.Product;
import com.mohit.ESD_YummyBackend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductsController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{low}/{high}")
    public ResponseEntity<String> getProducts(@PathVariable String low, @PathVariable String high) {
        return ResponseEntity.ok(productService.getProductsWithPriceRange(low,high));
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductRequest product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProduct(@PathVariable String name) {
        return ResponseEntity.ok(productService.getProduct(name));
    }

    @PutMapping()
    public ResponseEntity<String> updateProduct(@RequestBody ProductRequest product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }


    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteProduct(@PathVariable String name) {
        return ResponseEntity.ok(productService.deleteProduct(name));
    }
}