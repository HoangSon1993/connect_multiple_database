package com.sondev.mybatis.service;

import com.sondev.mybatis.primary.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
}
