package com.mohit.ESD_YummyBackend.mapper;

import com.mohit.ESD_YummyBackend.dto.ProductRequest;
import com.mohit.ESD_YummyBackend.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct (ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .price(request.price())
                .build();
    }
}

