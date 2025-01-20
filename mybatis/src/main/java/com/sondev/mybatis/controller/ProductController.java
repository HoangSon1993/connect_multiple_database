package com.sondev.mybatis.controller;

import com.sondev.mybatis.primary.entity.Product;
import com.sondev.mybatis.primary.mapper.ProductMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductMapper productMapper;

    public ProductController(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @PostMapping
    public Product create(String name, BigDecimal price, long categoryId){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategoryId(categoryId);

        productMapper.insert(product);
        return product;
    }
}
